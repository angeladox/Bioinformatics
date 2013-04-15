package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.Homologue;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.ac.roslin.ensembl.datasourceaware.compara.DAHomologyPairRelationship;
import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Coordinate.Strand;

@Component
public class HomologueFinder {

    @Autowired
    private AllForwardGenes forward;
    @Autowired
    private AllReverseGenes reverse;

    public List<Homologue> getHomologues(TargetGene target) {

        Coordinate.Strand homologueStrand = null;
        ArrayList<DAHomologyPairRelationship> out = (ArrayList<DAHomologyPairRelationship>) target.getHomologies();
        ArrayList<Homologue> newHomologues = new ArrayList<Homologue>();
        
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
            
            if (homologueStrand == Strand.FORWARD_STRAND)
                forward.addHomologue(newHomologue);
            
            else if (homologueStrand == Strand.REVERSE_STRAND)
                reverse.addHomologue(newHomologue);
            
            else
                System.out.println("You messed up your enums again in HomologueFinder.");
            
            newHomologues.add(newHomologue);            
        }
        target.setTargetHomologues(out);
        return (List<Homologue>)newHomologues;
    }


}