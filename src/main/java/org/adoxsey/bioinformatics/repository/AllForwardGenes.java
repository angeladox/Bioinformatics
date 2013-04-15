package org.adoxsey.bioinformatics.repository;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.springframework.stereotype.Component;

@Component
public class AllForwardGenes {
    
    public ArrayList<ChromosomeGene> forwardGenes;
    
    public void setForwardGenes(ArrayList<ChromosomeGene> forwardGenes) {
        this.forwardGenes = forwardGenes;
    }

    public AllForwardGenes(){
        forwardGenes = new ArrayList<ChromosomeGene>();
    }
    
    public void addGene(ChromosomeGene gene){
        forwardGenes.add(gene);
    }
    
    public List<ChromosomeGene> getForwardGenes(){    
        return forwardGenes;
    }
    
    public ChromosomeGene get(int index){
        return forwardGenes.get(index);
    }
    
    

}
