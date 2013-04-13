package org.adoxsey.bioinformatics;

import org.adoxsey.bioinformatics.model.TargetGene;

public class TempMain {

    private static String Display_Name = "CFTR";
    private static TargetGene targetGene;

    public static void main(String[] args) {
        Initializer init = new Initializer();
        targetGene = null;
        try {
            targetGene = init.start(Display_Name); // creates the target gene
        } catch (NullPointerException e) {
            System.out.println("Null target gene");
        }

    }

}
