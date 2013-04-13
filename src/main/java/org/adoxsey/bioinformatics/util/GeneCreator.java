package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.TargetGene;

import uk.ac.roslin.ensembl.config.DBConnection.DataSource;
import uk.ac.roslin.ensembl.dao.database.DBRegistry;
import uk.ac.roslin.ensembl.dao.database.DBSpecies;
import uk.ac.roslin.ensembl.dao.database.coreaccess.DBGeneDAO;
import uk.ac.roslin.ensembl.dao.database.factory.DBDAOSingleSpeciesCoreFactory;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.exception.ConfigurationException;
import uk.ac.roslin.ensembl.exception.DAOException;
import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.database.CoreDatabase;
import uk.ac.roslin.ensembl.model.database.SingleSpeciesCoreDatabase;

public class GeneCreator {
    
    private static String Stable_Gene_ID = "ENSG00000001626";

    private static String Species_Alias = "human";
    
    public TargetGene createTargetGene(String displayName) {
        DBRegistry ensemblgenomesRegistry = null;
        try {
            ensemblgenomesRegistry = new DBRegistry(DataSource.ENSEMBLDB);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Coordinate.Strand targetStrand;
        DBSpecies species = (DBSpecies) ensemblgenomesRegistry.getSpeciesByAlias(Species_Alias);
        CoreDatabase cd = species.getMostRecentCoreDatabase();
        SingleSpeciesCoreDatabase dbCCD = (SingleSpeciesCoreDatabase) cd;
        DBDAOSingleSpeciesCoreFactory dbDAO = (DBDAOSingleSpeciesCoreFactory) dbCCD.getCoreFactory();
        DBGeneDAO dbGeneDAO = null;
        try {
            dbGeneDAO = dbDAO.getGeneDAO();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        List<DAGene> daGenes = new ArrayList<DAGene>();
        try {
            daGenes = dbGeneDAO.getGenesByExactName(displayName);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        List<TargetGene> genes = new ArrayList<TargetGene>();
        for(DAGene gene: daGenes){
            genes.add((TargetGene)gene);
        }
        TargetGene g = genes.get(0);
        Coordinate targetCoords = null;
        try {
            targetCoords = g.getTopLevelTargetCoordinates();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        targetStrand = targetCoords.getStrand();

        TargetGene tGene = new TargetGene();
        tGene.setTargetCoords(targetCoords);
        tGene.setTargetStableGeneID(Stable_Gene_ID);
        tGene.setTargetDisplayName(displayName);
        tGene.setTargetSpeciesAlias(Species_Alias);
        tGene.setTargetGene(g);
        tGene.setTargetSpecies(species);
        tGene.setTargetStrand(targetStrand);

        return tGene;
    }

}
