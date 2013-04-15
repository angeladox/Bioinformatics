package org.adoxsey.bioinformatics.util;

import org.adoxsey.bioinformatics.model.Homologue;
import org.adoxsey.bioinformatics.model.TargetGene;

import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Coordinate.Strand;
import org.springframework.stereotype.Component;

@Component
public class IndexCalculator {
    
    public void calculateIndices(TargetGene target, Homologue homologue){
        Coordinate targetCoords = target.getTargetCoords();
        Coordinate homologueCoords = homologue.getCoords();
        
        Integer targetStart = targetCoords.getStart();
        Integer targetEnd = targetCoords.getEnd();
        Strand targetStrand = target.getTargetStrand();
        
        Integer homologueStart = homologueCoords.getStart();
        Integer homologueEnd = homologueCoords.getEnd();
        Strand homologueStrand = target.getTargetStrand();
        
        if(targetStrand == Strand.FORWARD_STRAND){
            calculateUpstreamPlus(targetStart, homologueEnd);
        }
        else if(targetStrand == Strand.REVERSE_STRAND){
            calculateUpstreamMinus(targetEnd, homologueStart);
        }
        else{
            System.out.println("You don't understand enums. Dummy");
        }
    }
    
    /*(upstream/plus) In the 5' Flanking sequence (upstream) box, enter
    the value you get by taking the target gene's smaller index minus
    the upstream gene's larger index minus 1 (if no upstream gene, then use
    the target gene's smaller index minus 1). For example, if the target gene
    gene had a smaller index of 100 and the upstream gene had a larger index
    of 50, then you would enter 49, because 100 - 50 - 1 = 49.*/
    private Integer calculateUpstreamPlus(Integer targetStart, Integer homologueEnd){
        return targetStart-homologueEnd-1;
    }
    
    /*(upstream/minus) In the 5' Flanking sequence (upstream) box,
    enter the value you get by taking the upstream gene's smaller
    index minus the target gene's larger index minus 1 (if no 
    upstream gene, then use the scaffold's end index minus target 
    gene's larger index).*/
    private Integer calculateUpstreamMinus(Integer targetEnd, Integer homologueStart){
        return homologueStart-targetEnd-1;
    }


}
