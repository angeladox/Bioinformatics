package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.adoxsey.bioinformatics.util.GeneCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
    
    private GeneCreator geneCreator;
    private AllForwardGenes allForwardHomologues;
    private AllReverseGenes allReverseHomologues;
    
    @Autowired
    public Initializer(GeneCreator geneCreator, AllForwardGenes allForwardHomologues, AllReverseGenes allReverseHomologues){
        this.geneCreator = geneCreator;
        this.allForwardHomologues = allForwardHomologues;
        this.allReverseHomologues = allReverseHomologues;
    }
    
    public Initializer(GeneCreator geneCreator){
        this.geneCreator = geneCreator;
    }
    
    public TargetGene start(String displayName) {
        TargetGene tGene = geneCreator.createTargetGene(displayName);
        return tGene;
    }

}
