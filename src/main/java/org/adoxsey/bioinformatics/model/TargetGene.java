package org.adoxsey.bioinformatics.model;

import java.util.List;

import uk.ac.roslin.ensembl.dao.database.DBSpecies;
import uk.ac.roslin.ensembl.datasourceaware.compara.DAHomologyPairRelationship;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.model.Coordinate;

public class TargetGene extends DAGene{
    private static final long serialVersionUID = 1L;
    
    private String Stable_Gene_ID;
    private String Display_Name;;
    private String Species_Alias;
    private DBSpecies species;   
    private DAGene gene;
    private Coordinate coords;
    private Coordinate.Strand strand;
    private List<DAHomologyPairRelationship> homologues;
    
    public List<DAHomologyPairRelationship> getTargetHomologues() {
        return homologues;
    }
    public void setTargetHomologues(List<DAHomologyPairRelationship> homologues) {
        this.homologues = homologues;
    }
    public String getTargetStableGeneID() {
        return Stable_Gene_ID;
    }
    public void setTargetStableGeneID(String stable_Gene_ID) {
        Stable_Gene_ID = stable_Gene_ID;
    }
    public String getTargetDisplayName() {
        return Display_Name;
    }
    public void setTargetDisplayName(String display_Name) {
        Display_Name = display_Name;
    }
    public String getTargetSpeciesAlias() {
        return Species_Alias;
    }
    public void setTargetSpeciesAlias(String species_Alias) {
        Species_Alias = species_Alias;
    }
    public DBSpecies getSpecies() {
        return species;
    }
    public void setTargetSpecies(DBSpecies species) {
        this.species = species;
    }
    public DAGene getTargetGene() {
        return gene;
    }
    public void setTargetGene(DAGene gene) {
        this.gene = gene;
    }
    public Coordinate getTargetCoords() {
        return coords;
    }
    public void setTargetCoords(Coordinate coords) {
        this.coords = coords;
    }
    public Coordinate.Strand getTargetStrand() {
        return strand;
    }
    public void setTargetStrand(Coordinate.Strand strand) {
        this.strand = strand;
    }

}
