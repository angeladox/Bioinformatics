package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllUpstreamGenes;
import org.springframework.stereotype.Component;
import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Coordinate.Strand;

/*The 'either' files include the sequence between the target and the
 next gene upstream of it no matter which strand it occurs on.*/

@Component
public class EitherFinder {

    public ChromosomeGene findEitherUpstreamGene(TargetGene target, AllUpstreamGenes allUpstreamGenes) {
        ArrayList<ChromosomeGene> allUpstreamGenesList = (ArrayList<ChromosomeGene>) allUpstreamGenes.getUpstreamGenes();
        Integer upstreamIndexCalculation = Integer.MAX_VALUE;
        Integer bestIndexCalculation = Integer.MAX_VALUE;
        boolean plus = false;
        boolean minus = false;

        Coordinate targetCoords = target.getTargetCoords();
        Integer targetSmallerIndex = targetCoords.getStart();
        Integer targetLargerIndex = targetCoords.getEnd();

        ChromosomeGene bestGene;
        if (allUpstreamGenesList.get(0).getChromDisplayName() == target.getTargetDisplayName())
            bestGene = allUpstreamGenesList.get(1);
        else
            bestGene = allUpstreamGenesList.get(0);

        for (ChromosomeGene upstreamGene : allUpstreamGenesList) {
            Integer upstreamSmallerIndex = upstreamGene.getChromCoordStart();
            Integer upstreamLargerIndex = upstreamGene.getChromCoordEnd();
            Integer bestLargerIndex = bestGene.getChromCoordEnd();
            Integer bestSmallerIndex = bestGene.getChromCoordStart();

            if (target.getTargetStrand() == Strand.REVERSE_STRAND) {
                plus = false;
                minus = true;
                bestIndexCalculation = calculateUpstreamMinus(bestSmallerIndex, targetLargerIndex);
                upstreamIndexCalculation = calculateUpstreamMinus(upstreamSmallerIndex, targetLargerIndex);
            }

            if (target.getTargetStrand() == Strand.FORWARD_STRAND) {
                minus = false;
                plus = true;
                bestIndexCalculation = calculateUpstreamPlus(targetSmallerIndex, bestLargerIndex);
                upstreamIndexCalculation = calculateUpstreamPlus(targetSmallerIndex, upstreamLargerIndex);
            }

            if (upstreamIndexCalculation < bestIndexCalculation) {
                String upstreamGeneDisplayName = upstreamGene.getChromDisplayName();
                String targetGeneDisplayName = target.getTargetDisplayName();
                if (!(upstreamGeneDisplayName.matches(targetGeneDisplayName)))
                    bestGene = upstreamGene;
            }
        } // end for loop

        if (plus)
            System.out.println("Your gene was on the plus strand. The upstream either gene is " + bestGene.getChromDisplayName());
        if (minus)
            System.out.println("Your gene was on the minus strand. The upstream either gene is " + bestGene.getChromDisplayName());

        return bestGene;

    }

    /*
     * Upstream/Plus: (Target smaller index) - (Upstream larger index) - 1 If no
     * upstream gene: (Target smaller index) - 1)
     */
    private Integer calculateUpstreamPlus(Integer targetSmallerIndex, Integer upstreamLargerIndex) {
        return targetSmallerIndex - upstreamLargerIndex - 1;
    }

    /*
     * (Upstream/Minus)(Upstream smaller index) - (Target larger index) - 1 If
     * no upstream gene: (Scaffold larger index) - (Target larger index)
     */
    private Integer calculateUpstreamMinus(Integer upstreamSmallerIndex, Integer targetLargerIndex) {
        if ((upstreamSmallerIndex - targetLargerIndex - 1) < 0)
            return Integer.MAX_VALUE;
        return upstreamSmallerIndex - targetLargerIndex - 1;
    }

}
