package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.util.HomologueFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TempMain {

    private static String Display_Name = "CFTR";
    static Initializer init;
    static HomologueFinder homologueFinder;
    
    @Autowired
    public TempMain(Initializer init, HomologueFinder homologueFinder){
        TempMain.init=init;
        TempMain.homologueFinder = homologueFinder;
    }

    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        TempMain tm = (TempMain)context.getBean("TempMain");
        tm.start();
    }
    
    private void start(){
        TargetGene targetGene = null;
        try {
            targetGene = init.start(Display_Name); // creates the target gene
        } catch (NullPointerException e) {
            System.out.println("Null target gene");
        }
        homologueFinder.getHomologues(targetGene);
    }

}
