package org.adoxsey.bioinformatics.repository;

import java.util.ArrayList;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.springframework.stereotype.Component;

@Component
public class AllReverseGenes {

    public ArrayList<ChromosomeGene> reverseGenes;
    
    public ArrayList<ChromosomeGene> getReverseGenes() {
        return reverseGenes;
    }

    public void setReverseGenes(ArrayList<ChromosomeGene> reverseGenes) {
        this.reverseGenes = reverseGenes;
    }

    public AllReverseGenes(){
        reverseGenes = new ArrayList<ChromosomeGene>();
    }
    
    public void addChromosomeGene(ChromosomeGene gene){
        reverseGenes.add(gene);
    }
   
}
