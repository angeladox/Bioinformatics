package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.adoxsey.bioinformatics.repository.AllUpstreamGenes;
import org.adoxsey.bioinformatics.util.ChromosomeCreator;
import org.adoxsey.bioinformatics.util.EitherFinder;
import org.adoxsey.bioinformatics.util.GeneCreator;
import org.adoxsey.bioinformatics.util.IndexCalculator;
import org.adoxsey.bioinformatics.util.SequenceRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    private GeneCreator geneCreator;
    private AllForwardGenes allForwardGenes;
    private AllReverseGenes allReverseGenes;
    private AllUpstreamGenes allUpstreamGenes;
    private ChromosomeCreator chromosomeCreator;
    private IndexCalculator indexCalculator;
    private SequenceRetriever sequenceRetriever;
    private EitherFinder eitherFinder;
    private ChromosomeGene eitherUpstreamGene;

    @Autowired
    public Initializer(AllUpstreamGenes allUpstreamGenes, EitherFinder eitherFinder, SequenceRetriever sequenceRetriever, GeneCreator geneCreator,
            ChromosomeCreator chromosomeCreator, AllForwardGenes allForwardGenes, AllReverseGenes allReverseGenes, IndexCalculator indexCalculator) {
        this.geneCreator = geneCreator;
        this.allForwardGenes = allForwardGenes;
        this.allReverseGenes = allReverseGenes;
        this.chromosomeCreator = chromosomeCreator;
        this.indexCalculator = indexCalculator;
        this.sequenceRetriever = sequenceRetriever;
        this.eitherFinder = eitherFinder;
        this.allUpstreamGenes = allUpstreamGenes;
    }

    public Initializer(GeneCreator geneCreator) {
        this.geneCreator = geneCreator;
    }

    public TargetGene createGeneAndSetUpstreamGenes(String targetGeneString, String speciesNameString) {
        TargetGene targetGene = null;
        try {
            targetGene = createGene(targetGeneString, speciesNameString);
        } catch (NullPointerException e) {
            System.out.println("Null target gene");
        }
        setAllUpstreamGenes(targetGene);
        return targetGene;
    }

    private void setAllUpstreamGenes(TargetGene gene) {
        allUpstreamGenes = chromosomeCreator.initializeUpstreamGenes(gene);
    }

    public ChromosomeGene setEitherUpstreamGene(TargetGene targetGene) {
        if (allUpstreamGenes==null)
            setAllUpstreamGenes(targetGene);
        ChromosomeGene eitherUpstreamGene = eitherFinder.findEitherUpstreamGene(targetGene, allUpstreamGenes);
        setEitherUpstreamGene(eitherUpstreamGene);
        return eitherUpstreamGene;
    }

    public String getEitherUpstreamGeneName(TargetGene targetGene) {
        if (eitherUpstreamGene == null)
            setEitherUpstreamGene(targetGene);
        return eitherUpstreamGene.getChromDisplayName();
    }

    public String getEitherUpstreamGeneStrand(TargetGene targetGene) {
        if (eitherUpstreamGene == null)
            setEitherUpstreamGene(targetGene);
        return eitherUpstreamGene.getChromStrand().toString();
    }

    private void setEitherUpstreamGene(ChromosomeGene eitherUpstreamGene) {
        this.eitherUpstreamGene = eitherUpstreamGene;
    }

    private TargetGene createGene(String displayName, String speciesName) {
        TargetGene tGene = geneCreator.createTargetGene(displayName, speciesName);
        return tGene;
    }

    private void setAllReverseGenes(TargetGene gene) {
        allReverseGenes = chromosomeCreator.initializeReverseChromosomeGenes(gene);
    }

    private void setAllForwardGenes(TargetGene gene) {
        allForwardGenes = chromosomeCreator.initializeForwardChromosomeGenes(gene);
    }

    private AllReverseGenes getAllReverseGenes(TargetGene gene) {
        if (allReverseGenes == null)
            allReverseGenes = chromosomeCreator.initializeReverseChromosomeGenes(gene);
        return allReverseGenes;
    }

    private AllForwardGenes getAllForwardGenes(TargetGene gene) {
        if (allForwardGenes == null)
            allForwardGenes = chromosomeCreator.initializeForwardChromosomeGenes(gene);
        return allForwardGenes;
    }

    public String getSameSequenceString(TargetGene targetGene) {
        String sameSequence = sequenceRetriever.getSameSequence(targetGene);
        return sameSequence;
    }

    public String getEitherSequenceString(TargetGene targetGene) {
        String eitherSequence = sequenceRetriever.getEitherSequence(targetGene);
        return eitherSequence;
    }

    public String getUpstreamPlus(TargetGene targetGene) {
        ChromosomeGene theUpstreamPlusGene = findUpstreamPlusGene(targetGene, getAllForwardGenes(targetGene));
        String returnString = "Upstream plus gene is " + theUpstreamPlusGene.getChromDisplayName() + " with ID " + theUpstreamPlusGene.getChromStableGeneID();
        System.out.println(returnString);
        return returnString;

    }

    public String getUpstreamMinus(TargetGene targetGene) {
        ChromosomeGene theUpstreamMinusGene = findUpstreamMinusGene(targetGene, getAllReverseGenes(targetGene));
        String returnString = "Upstream minus gene is " + theUpstreamMinusGene.getChromDisplayName() + " with ID " + theUpstreamMinusGene.getChromStableGeneID();
        System.out.println(returnString);
        return returnString;

    }

    public ChromosomeGene findUpstreamPlusGene(TargetGene gene, AllForwardGenes allForwardGenes) {
        return indexCalculator.calculateForwardIndices(gene, allForwardGenes);
    }

    public ChromosomeGene findUpstreamMinusGene(TargetGene gene, AllReverseGenes allReverseGenes) {
        return indexCalculator.calculateReverseIndices(gene, allReverseGenes);
    }

}
