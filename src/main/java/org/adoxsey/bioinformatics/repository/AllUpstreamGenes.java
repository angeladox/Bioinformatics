package org.adoxsey.bioinformatics.repository;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.springframework.stereotype.Component;

@Component
public class AllUpstreamGenes {
    
    public ArrayList<ChromosomeGene> upstreamGenes;
    
    public void setUpstreamGenes(ArrayList<ChromosomeGene> upstreamGenes) {
        this.upstreamGenes = upstreamGenes;
    }

    public AllUpstreamGenes(){
        upstreamGenes = new ArrayList<ChromosomeGene>();
    }
    
    public void addGene(ChromosomeGene gene){
        upstreamGenes.add(gene);
    }
    
    public List<ChromosomeGene> getUpstreamGenes(){    
        return upstreamGenes;
    }
    
    public ChromosomeGene get(int index){
        return upstreamGenes.get(index);
    }
    
    

}
