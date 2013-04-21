package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TempMain {

    private static String Display_Name = "CFTR";
    static Initializer init;
    
    @Autowired
    public TempMain(Initializer init){
        TempMain.init=init;
    }

    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TempMain tm = (TempMain)context.getBean("TempMain");
        tm.start();
    }
    
    private void start(){
        TargetGene targetGene = null;
        try {
            targetGene = init.createGene(Display_Name); // creates the target gene
        } catch (NullPointerException e) {
            System.out.println("Null target gene");
        }
        init.setAllForwardGenes(targetGene);
        init.setAllReverseGenes(targetGene);
        ChromosomeGene theUpstreamGene = init.findUpstreamPlusGene(targetGene, init.getAllForwardGenes(targetGene));
        //init.findUpstreamMinusGene(targetGene, init.getAllReverseGenes(targetGene))
        System.out.println("Upstream gene is " + theUpstreamGene.getChromDisplayName() + " with ID " + theUpstreamGene.getChromStableGeneID());
    }

}
