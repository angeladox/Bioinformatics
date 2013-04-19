package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;
import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpstreamFinder {
/*    
    private AllForwardGenes allForwardGenes;
    private AllReverseGenes allReverseGenes;
    
    @Autowired
    public UpstreamFinder(AllForwardGenes allForwardGenes, AllReverseGenes allReverseGenes){
        this.allForwardGenes = allForwardGenes;
        this.allReverseGenes = allReverseGenes;
    }
    
    //For now this is only dealing with "forward" strand target genes 
    public void findForwardUpstreamGene(TargetGene target){
        ArrayList<ChromosomeGene> forwardGenes = (ArrayList<ChromosomeGene>) allForwardGenes.getForwardGenes();  
        ChromosomeGene curChromosomeGene = forwardGenes.get(0);
        ChromosomeGene bestChromosomeGene = curChromosomeGene;
        for (int i =0; i<forwardGenes.size(); i++){           
            if (curChromosomeGene.getCoordStart()>(target.getCoordEnd())){       //the gene is downstream
                break;
            }
            else if (curChromosomeGene.getCoordStart()<=target.getCoordEnd()){   //the gene is upstream
                if ((target.getCoordStart()-curChromosomeGene.getCoordEnd())<((target.getCoordStart()-bestChromosomeGene.getCoordEnd()))){
                    bestChromosomeGene=curChromosomeGene;
                }
            
            }
        }
    }
    
    public void findReverseUpstreamGene(TargetGene target){
        //if the smaller index of 
    }
*/
}
