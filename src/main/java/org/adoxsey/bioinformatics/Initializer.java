package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.adoxsey.bioinformatics.util.ChromosomeCreator;
import org.adoxsey.bioinformatics.util.GeneCreator;
import org.adoxsey.bioinformatics.util.IndexCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    private GeneCreator geneCreator;
    private AllForwardGenes allForwardGenes;
    private AllReverseGenes allReverseGenes;
    private ChromosomeCreator chromosomeCreator;
    private IndexCalculator indexCalculator;

    @Autowired
    public Initializer(GeneCreator geneCreator, ChromosomeCreator chromosomeCreator, 
            AllForwardGenes allForwardGenes, AllReverseGenes allReverseGenes, IndexCalculator indexCalculator) {
        this.geneCreator = geneCreator;
        this.allForwardGenes = allForwardGenes;
        this.allReverseGenes = allReverseGenes;
        this.chromosomeCreator = chromosomeCreator;
        this.indexCalculator = indexCalculator;
    }

    public Initializer(GeneCreator geneCreator) {
        this.geneCreator = geneCreator;
    }

    public TargetGene createGene(String displayName) {
        TargetGene tGene = geneCreator.createTargetGene(displayName);
        return tGene;
    }

    public AllForwardGenes getAllForwardGenes(TargetGene gene) {
        if (allForwardGenes == null)
            allForwardGenes = chromosomeCreator.initializeForwardChromosomeGenes(gene);
        return allForwardGenes;
    }

    public void setAllForwardGenes(TargetGene gene) {
        allForwardGenes = chromosomeCreator.initializeForwardChromosomeGenes(gene);
    }

    public AllReverseGenes getAllReverseGenes(TargetGene gene) {
        if (allReverseGenes == null)
            allReverseGenes = chromosomeCreator.initializeReverseChromosomeGenes(gene);
        return allReverseGenes;
    }

    public void setAllReverseGenes(TargetGene gene) {
        allReverseGenes = chromosomeCreator.initializeReverseChromosomeGenes(gene);
    }
    
    public ChromosomeGene findUpstreamPlusGene(TargetGene gene, AllForwardGenes allForwardGenes){
        return indexCalculator.calculateForwardIndices(gene, allForwardGenes);
    }
    
   /* public ChromosomeGene findUpstreamMinusGene(TargetGene gene, AllReverseGenes allReverseGenes){
        return new indexCalculator.calculateReverseIndices(gene, allReverseGenes);
    }*/

}
