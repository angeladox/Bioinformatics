package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.Homologue;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;

import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Coordinate.Strand;
import org.springframework.stereotype.Component;

@Component
public class IndexCalculator {

    public ChromosomeGene calculateForwardIndices(TargetGene target, AllForwardGenes allForwardGenes) {
        // AllForwardGenes should now only contain genes on the same chromosome
        // as the target gene
        // with indices less than the target gene and that are not pseudogenes.
        ArrayList<ChromosomeGene> chromGenes = (ArrayList<ChromosomeGene>) allForwardGenes.getForwardGenes();

        Coordinate targetCoords = target.getTargetCoords();
        Integer targetStart = targetCoords.getStart();
        Integer targetEnd = targetCoords.getEnd();
        Strand targetStrand = target.getTargetStrand();
        ChromosomeGene bestGene;
        //if (chromGene.getChromDisplayName() != target.getTargetDisplayName()
        if (chromGenes.get(0).getChromDisplayName()==target.getTargetDisplayName())
            bestGene = chromGenes.get(1);
        else
            bestGene = chromGenes.get(0);

        for (ChromosomeGene chromGene : chromGenes) {
            if (chromGene.getChromStrand() != Strand.FORWARD_STRAND)
                System.out.println("This is an improper calculation of a 'forward strand' gene");
            Integer chromGeneStart = chromGene.getChromCoordStart();
            Integer chromGeneEnd = chromGene.getChromCoordEnd();

            if ((calculateUpstreamPlus(targetStart, chromGeneStart)) < (calculateUpstreamPlus(targetStart, bestGene.getChromCoordEnd()))) {
                if (!(chromGene.getChromDisplayName().matches(target.getTargetDisplayName())))
                    bestGene = chromGene;
            }

        }
        return bestGene;

    }

    /*
     * (upstream/plus) In the 5' Flanking sequence (upstream) box, enter the
     * value you get by taking the target gene's smaller index minus the
     * upstream gene's larger index minus 1 (if no upstream gene, then use the
     * target gene's smaller index minus 1). For example, if the target gene
     * gene had a smaller index of 100 and the upstream gene had a larger index
     * of 50, then you would enter 49, because 100 - 50 - 1 = 49.
     */
    private Integer calculateUpstreamPlus(Integer targetStart, Integer chromGeneEnd) {
        return targetStart - chromGeneEnd - 1;
    }

    /*
     * (upstream/minus) In the 5' Flanking sequence (upstream) box, enter the
     * value you get by taking the upstream gene's smaller index minus the
     * target gene's larger index minus 1 (if no upstream gene, then use the
     * scaffold's end index minus target gene's larger index).
     */
    private Integer calculateUpstreamMinus(Integer targetEnd, Integer chromGeneStart) {
        return chromGeneStart - targetEnd - 1;
    }

}
