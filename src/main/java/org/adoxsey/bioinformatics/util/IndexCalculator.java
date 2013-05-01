package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;

import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Coordinate.Strand;
import org.springframework.stereotype.Component;

@Component
public class IndexCalculator {

    /*Returns the upstream plus gene*/
    public ChromosomeGene calculateForwardIndices(TargetGene target, AllForwardGenes allForwardGenes) {
        ArrayList<ChromosomeGene> upstreamGenes = (ArrayList<ChromosomeGene>) allForwardGenes.getForwardGenes();
        Coordinate targetCoords = target.getTargetCoords();
        Integer targetSmallerIndex = targetCoords.getStart();
        ChromosomeGene bestGene;
        if (upstreamGenes.get(0).getChromDisplayName()==target.getTargetDisplayName())
            bestGene = upstreamGenes.get(1);
        else
            bestGene = upstreamGenes.get(0);

        for (ChromosomeGene upstreamGene : upstreamGenes) {
            if (upstreamGene.getChromStrand() != Strand.FORWARD_STRAND)
                System.out.println("This is an improper calculation of a 'forward strand' gene");
            Integer upstreamGeneLargerIndex = upstreamGene.getChromCoordEnd();
            Integer bestGeneLargerIndex = bestGene.getChromCoordEnd();
            if ((calculateUpstreamPlus(targetSmallerIndex, upstreamGeneLargerIndex)) < (calculateUpstreamPlus(targetSmallerIndex, bestGeneLargerIndex))) {
                if (!(upstreamGene.getChromDisplayName().matches(target.getTargetDisplayName())))
                    bestGene = upstreamGene;
            }

        }
        return bestGene;
    }

    /* Upstream/plus: (Target smaller index) - (Upstream larger index) - 1 
     * If no upstream gene: (Target smaller index) - 1)
     */
    private Integer calculateUpstreamPlus(Integer targetSmallerIndex, Integer upstreamLargerIndex) {
        return targetSmallerIndex - upstreamLargerIndex - 1;
    }
    
    /*Returns the upstream minus gene*/
    public ChromosomeGene calculateReverseIndices(TargetGene target, AllReverseGenes allReverseGenes) {
        ArrayList<ChromosomeGene> upstreamGenes = (ArrayList<ChromosomeGene>) allReverseGenes.getReverseGenes();

        Coordinate targetCoords = target.getTargetCoords();
        Integer targetLargerIndex = targetCoords.getEnd();
        ChromosomeGene bestGene;
        if (upstreamGenes.get(0).getChromDisplayName()==target.getTargetDisplayName())
            bestGene = upstreamGenes.get(1);
        else
            bestGene = upstreamGenes.get(0);

        for (ChromosomeGene upstreamGene : upstreamGenes) {
            if (upstreamGene.getChromStrand() != Strand.REVERSE_STRAND)
                System.out.println("This is an improper calculation of a 'reverse strand' gene");
            Integer upstreamGeneSmallerIndex = upstreamGene.getChromCoordStart();
            Integer bestGeneSmallerIndex = bestGene.getChromCoordStart();

            if ((calculateUpstreamMinus(upstreamGeneSmallerIndex, targetLargerIndex)) < (calculateUpstreamMinus(bestGeneSmallerIndex, targetLargerIndex))) {
                String upstreamGeneDisplayName = upstreamGene.getChromDisplayName();
                String targetGeneDisplayName = target.getTargetDisplayName();
                if (!(upstreamGeneDisplayName.matches(targetGeneDisplayName)))
                    bestGene = upstreamGene;
            }

        }
        return bestGene;

    }
    /*
     * (upstream/minus) In the 5' Flanking sequence (upstream) box, enter the
     * value you get by taking the upstream gene's smaller index minus the
     * target gene's larger index minus 1 (if no upstream gene, then use the
     * scaffold's end index minus target gene's larger index).
     */
    private Integer calculateUpstreamMinus(Integer upstreamSmallerIndex, Integer targetLargerIndex) {
        if ((upstreamSmallerIndex - targetLargerIndex - 1)<0)
            return Integer.MAX_VALUE;
        return upstreamSmallerIndex - targetLargerIndex - 1;
    }

}
