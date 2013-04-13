package org.adoxsey.bioinformatics.model;

import uk.ac.roslin.ensembl.model.Coordinate;

public class Homologue {
    
    private String stableID;
    private String speciesName;
    private Coordinate coords;
    private String sequenceName;
    private Coordinate.Strand strand;
    
    public String getStableID() {
        return stableID;
    }
    public void setStableID(String stableID) {
        this.stableID = stableID;
    }
    public String getSpeciesName() {
        return speciesName;
    }
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    public Coordinate getCoords() {
        return coords;
    }
    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }
    public String getSequenceName() {
        return sequenceName;
    }
    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }
    public Coordinate.Strand getStrand() {
        return strand;
    }
    public void setStrand(Coordinate.Strand strand) {
        this.strand = strand;
    }

}
