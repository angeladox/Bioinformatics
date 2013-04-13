package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.Homologue;
import org.adoxsey.bioinformatics.model.TargetGene;
import uk.ac.roslin.ensembl.datasourceaware.compara.DAHomologyPairRelationship;
import uk.ac.roslin.ensembl.model.Coordinate;

public class HomologueFinder {

    private static List<DAHomologyPairRelationship> either = new ArrayList<DAHomologyPairRelationship>();
    private static List<DAHomologyPairRelationship> same = new ArrayList<DAHomologyPairRelationship>();

    public List<DAHomologyPairRelationship> getHomologues(TargetGene target) {

        Coordinate.Strand homologueStrand = null;
        List<DAHomologyPairRelationship> out = target.getHomologies();

        for (DAHomologyPairRelationship homologue : out) {
            String stableID = homologue.getTarget().getStableID();
            String speciesName = homologue.getTargetProperties().getSpeciesName();
            Coordinate coords = homologue.getTargetProperties().getCoords();
            String sequenceName = homologue.getTargetProperties().getSequenceName();
            homologueStrand = coords.getStrand();
            
            Homologue newHomologue = new Homologue();
            newHomologue.setStableID(stableID);
            newHomologue.setSpeciesName(speciesName);
            newHomologue.setSequenceName(sequenceName);
            newHomologue.setStrand(homologueStrand);
            newHomologue.setCoords(coords);

            if (homologueStrand.compareTo(target.getTargetStrand()) != 0) {
                addToEither(homologue);
            } else
                addToSame(homologue);

        }
        target.setTargetHomologues(out);
        return out;
    }

    private static void addToEither(DAHomologyPairRelationship hom) {
        either.add(hom);
    }

    private static void addToSame(DAHomologyPairRelationship hom) {
        same.add(hom);
    }

}