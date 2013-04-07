package experiments;

import java.util.ArrayList;
import java.util.List;
import uk.ac.roslin.ensembl.config.DBConnection.DataSource;
import uk.ac.roslin.ensembl.dao.database.*;
import uk.ac.roslin.ensembl.dao.database.coreaccess.DBGeneDAO;
import uk.ac.roslin.ensembl.dao.database.factory.DBDAOCollectionCoreFactory;
import uk.ac.roslin.ensembl.dao.database.factory.DBDAOSingleSpeciesCoreFactory;
import uk.ac.roslin.ensembl.datasourceaware.compara.DAHomologyPairRelationship;
import uk.ac.roslin.ensembl.datasourceaware.core.DADNASequence;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.mapper.core.GeneMapper;
import uk.ac.roslin.ensembl.model.Mapping;
import uk.ac.roslin.ensembl.model.MappingSet;
import uk.ac.roslin.ensembl.model.database.CoreDatabase;
import uk.ac.roslin.ensembl.model.database.SingleSpeciesCoreDatabase;

public class Experiments {

    // retrieving all the homologue for a gene
    // and comparing the mapping data for this gene in Compara - with
    // that pulled out of correct core database
    static String Stable_Gene_ID = "ENSG00000001626";
    static String Display_Name = "CFTR";
    static String Species_Alias = "human";

    public static void main(String[] args) throws Exception {
        DBRegistry ensemblgenomesRegistry = new DBRegistry(DataSource.ENSEMBLDB);
        DBSpecies species = (DBSpecies) ensemblgenomesRegistry.getSpeciesByAlias(Species_Alias);
       // DBDAOCollectionCoreFactory dbDAOCollectionCoreFactory = (DBDAOCollectionCoreFactory) ((DBCollectionCoreDatabase)
       // CoreDatabase coreDatabase = species.getMostRecentCoreDatabase();
        
        //DBDAOCollectionCoreFactory dbDAOCollectionCoreFactory = (DBDAOCollectionCoreFactory) coreDatabase.get
        //        .getCoreFactory(species);
        CoreDatabase cd = species.getMostRecentCoreDatabase();
        SingleSpeciesCoreDatabase dbCCD = (SingleSpeciesCoreDatabase) cd;
        DBDAOSingleSpeciesCoreFactory dbDAO =(DBDAOSingleSpeciesCoreFactory) dbCCD.getCoreFactory();
        DBGeneDAO dbGeneDAO = dbDAO.getGeneDAO();
        List<DAGene> genes = new ArrayList<DAGene>();
        genes = dbGeneDAO.getGenesByExactName(Display_Name);
        DAGene g = genes.get(0);
        List<DAHomologyPairRelationship> out = g.getHomologies();
        System.out.println(g.getSpecies().getCommonName() + " gene " + g.getStableID() + " has " + out.size() + " homologies.");

        /*
         * DBRegistry eReg = new DBRegistry(DataSource.ENSEMBLDB); 
         * DBSpecies sp = eReg.getSpeciesByAlias(Species_Alias);
         * 
         * DAGene g = sp.getGeneByStableID(Stable_Gene_ID); // property of gene
         * // that is CTFR // is referred to as // "displayName"
         * 
         * List<DAHomologyPairRelationship> out = g.getHomologies();
         * System.out.println(g.getSpecies().getCommonName() + "v" +
         * g.getDBVersion() + " gene " + g.getStableID() + " has " + out.size()
         * + " homologies.");
         * System.out.println("_____________________________________________\r\n"
         * );
         * 
         * for (DAHomologyPairRelationship h : out) {
         * 
         * System.out.print(h.getTargetProperties().getSpeciesName());
         * System.out.print(" gene: " + h.getTarget().getStableID());
         * System.out.println(" [" + h.getType().toString() +
         * "] (last common ancestor: " + h.getLastCommonAncestor() + ")");
         * 
         * System.out.println("MAPPING DATA IN COMPARA");
         * System.out.println("'chromosome' name: " +
         * h.getTargetProperties().getSequenceName() + " [" +
         * h.getTargetProperties().getCoords().toString() + "]");
         * 
         * System.out.println("MAPPING DATA LAZY LOADED FROM CORE");
         * 
         * MappingSet m = null;
         * 
         * m = h.getTarget().getAnnotationLevelMappings();
         * 
         * System.out.print("ANNOTATION LEVEL: "); if (m != null &&
         * !m.isEmpty()) { for (Mapping mp : m) {
         * System.out.println(mp.getTarget().getClass() .getSimpleName() +
         * " name: " + ((DADNASequence) mp.getTarget()).getName() + " id: " +
         * mp.getTarget().getId() + " [" + mp.getTargetCoordinates().toString()
         * + "]");
         * 
         * if (!h.getTargetProperties() .getSequenceName() .contentEquals(
         * ((DADNASequence) mp.getTarget()).getName())) {
         * System.out.println("\n\n\n*********ERROR in name"); } if
         * (h.getTargetProperties().getCoords().getStart() -
         * mp.getTargetCoordinates().getStart() != 0) { System.out
         * .println("\n\n\n*********ERROR in start coord"); } if
         * (h.getTargetProperties().getCoords().getEnd() -
         * mp.getTargetCoordinates().getEnd() != 0) {
         * System.out.println("\n\n\n*********ERROR in end coord"); } if
         * (!h.getTargetProperties().getCoords().getStrand()
         * .equals(mp.getTargetCoordinates().getStrand())) {
         * System.out.println("\n\n\n*********ERROR in strande"); } } } else {
         * System.out.println(""); }
         * 
         * m = h.getTarget().getBuildLevelMappings();
         * System.out.print("BUILD LEVEL: "); if (m != null && !m.isEmpty()) {
         * 
         * for (Mapping mp : m) { System.out.println(mp.getTarget().getClass()
         * .getSimpleName() + " name: " + ((DADNASequence)
         * mp.getTarget()).getName() + " id: " + mp.getTarget().getId() + " [" +
         * mp.getTargetCoordinates().toString() + "]");
         * 
         * if (!h.getTargetProperties() .getSequenceName() .contentEquals(
         * ((DADNASequence) mp.getTarget()).getName())) {
         * System.out.println("\n\n\n*********ERROR in name"); } if
         * (h.getTargetProperties().getCoords().getStart() -
         * mp.getTargetCoordinates().getStart() != 0) { System.out
         * .println("\n\n\n*********ERROR in start coord"); } if
         * (h.getTargetProperties().getCoords().getEnd() -
         * mp.getTargetCoordinates().getEnd() != 0) {
         * System.out.println("\n\n\n*********ERROR in end coord"); } if
         * (!h.getTargetProperties().getCoords().getStrand()
         * .equals(mp.getTargetCoordinates().getStrand())) {
         * System.out.println("\n\n\n*********ERROR in strande"); }
         * 
         * } } else { System.out.println(""); }
         * 
         * m = h.getTarget().getTopLevelMappings();
         * System.out.print("TOP LEVEL: "); if (m != null && !m.isEmpty()) { for
         * (Mapping mp : m) { System.out.println(mp.getTarget().getClass()
         * .getSimpleName() + " name: " + ((DADNASequence)
         * mp.getTarget()).getName() + " id: " + mp.getTarget().getId() + " [" +
         * mp.getTargetCoordinates().toString() + "]");
         * 
         * if (!h.getTargetProperties() .getSequenceName() .contentEquals(
         * ((DADNASequence) mp.getTarget()).getName())) {
         * System.out.println("\n\n\n*********ERROR in name"); } if
         * (h.getTargetProperties().getCoords().getStart() -
         * mp.getTargetCoordinates().getStart() != 0) { System.out
         * .println("\n\n\n*********ERROR in start coord"); } if
         * (h.getTargetProperties().getCoords().getEnd() -
         * mp.getTargetCoordinates().getEnd() != 0) {
         * System.out.println("\n\n\n*********ERROR in end coord"); } if
         * (!h.getTargetProperties().getCoords().getStrand()
         * .equals(mp.getTargetCoordinates().getStrand())) {
         * System.out.println("\n\n\n*********ERROR in strande"); }
         * 
         * } } else { System.out.println(""); }
         * 
         * System.out
         * .println("___________________________________________________");
         * System.out.println(""); // }
         * 
         * }
         * 
         * System.out .println(
         * "\n\n*************************\nCOMPLETED FUNCTIONAL TEST\n*************************\n"
         * );
         */

    }
}