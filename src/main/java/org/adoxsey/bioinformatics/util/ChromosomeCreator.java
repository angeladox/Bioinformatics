package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.ac.roslin.ensembl.datasourceaware.core.DAChromosome;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.exception.DAOException;
import uk.ac.roslin.ensembl.exception.NonUniqueException;
import uk.ac.roslin.ensembl.model.Coordinate;
import uk.ac.roslin.ensembl.model.Mapping;

@Component
public class ChromosomeCreator {
    
    AllForwardGenes allForwardGenes;
    AllReverseGenes allReverseGenes;
    
    @Autowired
    public ChromosomeCreator(AllForwardGenes allForwardGenes, AllReverseGenes allReverseGenes){
        this.allForwardGenes=allForwardGenes;
        this.allReverseGenes=allReverseGenes;
    }
    
    public void initializeForwardChromosomeGenes(TargetGene targetGene){
        DAChromosome chr = targetGene.getTargetChromosome();
        ArrayList<DAGene> DAGenesFwd = null;
        ArrayList<ChromosomeGene> chromGenesFwd = new ArrayList<ChromosomeGene>();
        try {
            DAGenesFwd = (ArrayList<DAGene>)chr.getGenesOnRegion(0, targetGene.getCoordEnd(), Coordinate.Strand.FORWARD_STRAND);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Coordinate targetCoords = null;
        Mapping chromosomeMapping = null;
        
        for (DAGene gene:DAGenesFwd){
            try {
                chromosomeMapping = gene.getChromosomeMapping();
            } catch (NonUniqueException e1) {
                e1.printStackTrace();
            }
            targetCoords = chromosomeMapping.getTargetCoordinates();
            ChromosomeGene chromosomeGene = new ChromosomeGene();
            chromosomeGene.setChromStrand(Coordinate.Strand.FORWARD_STRAND);
            chromosomeGene.setChromCoords(targetCoords);
            chromosomeGene.setChromCoordStart(targetCoords.getStart());
            chromosomeGene.setChromCoordEnd(targetCoords.getEnd());
            DAGenesFwd.add(chromosomeGene);
        }
        allForwardGenes.setForwardGenes(chromGenesFwd);
    }
    
    public void initializeReverseChromosomeGenes(TargetGene targetGene){
        DAChromosome chr = targetGene.getTargetChromosome();
        ArrayList<DAGene> DAGenesRvs = null;
        ArrayList<ChromosomeGene> chromGenesRvs = new ArrayList<ChromosomeGene>();
        try {
            DAGenesRvs = (ArrayList<DAGene>)chr.getGenesOnRegion(0, targetGene.getCoordEnd(), Coordinate.Strand.REVERSE_STRAND);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Coordinate targetCoords = null;
        Mapping chromosomeMapping = null;
        
        for (DAGene gene:DAGenesRvs){
            try {
                chromosomeMapping = gene.getChromosomeMapping();
            } catch (NonUniqueException e1) {
                e1.printStackTrace();
            }
            targetCoords = chromosomeMapping.getTargetCoordinates();
            ChromosomeGene chromosomeGene = new ChromosomeGene();
            chromosomeGene.setChromStrand(Coordinate.Strand.REVERSE_STRAND);
            chromosomeGene.setChromCoords(targetCoords);
            chromosomeGene.setChromCoordStart(targetCoords.getStart());
            chromosomeGene.setChromCoordEnd(targetCoords.getEnd());
            DAGenesRvs.add(chromosomeGene);
        }
        allReverseGenes.setReverseGenes(chromGenesRvs);
    }

}
