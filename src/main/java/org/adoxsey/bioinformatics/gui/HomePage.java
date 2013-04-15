package org.adoxsey.bioinformatics.gui;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.adoxsey.bioinformatics.model.Homologue;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.util.HomologueFinder;

@ManagedBean
@SessionScoped
public class HomePage implements Serializable {

        private static final long serialVersionUID = 1L;
        
        private String geneDisplayName;
        private String homologues;
        TargetGene tGene;
        private HomologueFinder homologueFinder = new HomologueFinder();
               
        public String getGeneDisplayName(){
            return geneDisplayName;
        }
        
        public void setGeneDisplayName(String geneName){
            this.geneDisplayName=geneName;
        }
        
        public String getHomologues(){
            return homologues;
        }
        
        public void setHomologues(String homologues) {
            this.homologues = homologues;
        }
        
        public List<Homologue> homologues(){
            return (List<Homologue>) homologueFinder.getHomologues(tGene);
        }

        public String about(){
            return "about";
        }
        
        public List<Homologue> startProcess(){
            //tGene = homologueFinder.start();
            return (List<Homologue>) homologueFinder.getHomologues(tGene);
        }
}
