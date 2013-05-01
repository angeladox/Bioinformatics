package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.TargetGene;
import org.springframework.stereotype.Component;

import uk.ac.roslin.ensembl.config.DBConnection.DataSource;
import uk.ac.roslin.ensembl.dao.database.DBRegistry;
import uk.ac.roslin.ensembl.dao.database.DBSpecies;
import uk.ac.roslin.ensembl.dao.database.coreaccess.DBGeneDAO;
import uk.ac.roslin.ensembl.dao.database.factory.DBDAOSingleSpeciesCoreFactory;
import uk.ac.roslin.ensembl.datasourceaware.core.DAChromosome;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.exception.ConfigurationException;
import uk.ac.roslin.ensembl.exception.DAOException;
import uk.ac.roslin.ensembl.exception.NonUniqueException;
import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Mapping;
import uk.ac.roslin.ensembl.model.database.CoreDatabase;
import uk.ac.roslin.ensembl.model.database.SingleSpeciesCoreDatabase;

@Component
public class GeneCreator {

    public TargetGene createTargetGene(String displayName, String speciesAlias) {
        DBRegistry ensemblgenomesRegistry = null;
        try {
            System.out.println("Initiating connection to the database...");
            ensemblgenomesRegistry = new DBRegistry(DataSource.ENSEMBLDB);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Coordinate.Strand targetStrand;
        System.out.println("Retrieving the proper species...");
        DBSpecies species = (DBSpecies) ensemblgenomesRegistry.getSpeciesByAlias(speciesAlias);
        CoreDatabase cd = species.getMostRecentCoreDatabase();
        SingleSpeciesCoreDatabase dbCCD = (SingleSpeciesCoreDatabase) cd;
        DBDAOSingleSpeciesCoreFactory dbDAO = (DBDAOSingleSpeciesCoreFactory) dbCCD.getCoreFactory();
        DBGeneDAO dbGeneDAO = null;
        try {
            System.out.println("Retrieving the gene DAO...");
            dbGeneDAO = dbDAO.getGeneDAO();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        List<DAGene> daGenes = new ArrayList<DAGene>();
        try {
            System.out.println("Retrieving gene(s) with display name " + displayName + "...");
            daGenes = dbGeneDAO.getGenesByExactName(displayName);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        DAGene g = daGenes.get(0);
        Coordinate targetCoords = null;
        Mapping chromosomeMapping = null;
        try {
            chromosomeMapping = g.getChromosomeMapping();
        } catch (NonUniqueException e1) {
            e1.printStackTrace();
        }
        targetStrand = chromosomeMapping.getTargetCoordinates().getStrand();
        DAChromosome chr = (DAChromosome) chromosomeMapping.getTarget();
        targetCoords = chromosomeMapping.getTargetCoordinates();

        TargetGene tGene = new TargetGene();
        tGene.setTargetChromosome(chr);
        tGene.setTargetCoords(targetCoords);
        tGene.setTargetDisplayName(displayName);
        tGene.setTargetSpeciesAlias(speciesAlias);
        tGene.setTargetGene(g);
        tGene.setTargetSpecies(species);
        tGene.setTargetStrand(targetStrand);

        return tGene;
    }
}
