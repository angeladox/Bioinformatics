package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.util.GeneCreator;

public class Initializer {
        
    private static String Display_Name = "CFTR";
    
    private GeneCreator geneCreator;
    
    public Initializer(){
        geneCreator = new GeneCreator();
    }
    
    public Initializer(GeneCreator geneCreator){
        this.geneCreator = geneCreator;
    }
    
    public TargetGene start() {
        TargetGene tGene = geneCreator.createTargetGene(Display_Name);
        return tGene;
    }

}
