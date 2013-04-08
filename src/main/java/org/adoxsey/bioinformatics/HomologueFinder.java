package org.adoxsey.bioinformatics;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.TargetGene;
import uk.ac.roslin.ensembl.config.DBConnection.DataSource;
import uk.ac.roslin.ensembl.dao.database.*;
import uk.ac.roslin.ensembl.dao.database.coreaccess.DBGeneDAO;
import uk.ac.roslin.ensembl.dao.database.factory.DBDAOSingleSpeciesCoreFactory;
import uk.ac.roslin.ensembl.datasourceaware.compara.DAHomologyPairRelationship;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.exception.ConfigurationException;
import uk.ac.roslin.ensembl.exception.DAOException;
import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.database.CoreDatabase;
import uk.ac.roslin.ensembl.model.database.SingleSpeciesCoreDatabase;

public class HomologueFinder {

    private static String Stable_Gene_ID = "ENSG00000001626";
    private static String Display_Name = "CFTR";
    private static String Species_Alias = "human";

    private static List<DAHomologyPairRelationship> either = new ArrayList<DAHomologyPairRelationship>();
    private static List<DAHomologyPairRelationship> same = new ArrayList<DAHomologyPairRelationship>();

    public TargetGene start() {
        TargetGene tGene = createTargetGene();
        return tGene;
    }

    private TargetGene createTargetGene() {
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
            daGenes = dbGeneDAO.getGenesByExactName(Display_Name);
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
        tGene.setTargetDisplayName(Display_Name);
        tGene.setTargetSpeciesAlias(Species_Alias);
        tGene.setTargetGene(g);
        tGene.setTargetSpecies(species);
        tGene.setTargetStrand(targetStrand);

        return tGene;
    }

    public String getHomologues(TargetGene target) {
        // Just for now, some GUI stuff in here
        String homologueString = "";
        Coordinate.Strand homologueStrand = null;
        List<DAHomologyPairRelationship> out = target.getHomologies();
        homologueString = homologueString + " " + (target.getSpecies().getCommonName() + " gene " + target.getStableID() + " has " + out.size() + " homologies.\n");
        //For now just 10 homologues displayed
        int i = 0;
        for (DAHomologyPairRelationship homologue : out) {
            if (i < 11) {
                homologueString = homologueString + "\n Gene ID: " + homologue.getTarget().getStableID();
                homologueString = homologueString + "\n Species Name: " + homologue.getTargetProperties().getSpeciesName();
                Coordinate coords = homologue.getTargetProperties().getCoords();
                homologueString = homologueString + "\n Chromosome name: " + homologue.getTargetProperties().getSequenceName();
                homologueString = homologueString + "\n Coordinates and Strand: [" + coords.toString() + "]";
                homologueStrand = coords.getStrand();
                i++;
            }
            if (homologueStrand.compareTo(target.getTargetStrand()) != 0) {
                addToEither(homologue);
            } else
                addToSame(homologue);

        }
        target.setTargetHomologues(out);
        return homologueString;
    }

    private static void addToEither(DAHomologyPairRelationship hom) {
        either.add(hom);
    }

    private static void addToSame(DAHomologyPairRelationship hom) {
        same.add(hom);
    }
}