package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.adoxsey.bioinformatics.repository.AllUpstreamGenes;
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
    AllUpstreamGenes allUpstreamGenes;

    @Autowired
    public ChromosomeCreator(AllForwardGenes allForwardGenes, AllReverseGenes allReverseGenes, AllUpstreamGenes allUpstreamGenes) {
        this.allForwardGenes = allForwardGenes;
        this.allReverseGenes = allReverseGenes;
        this.allUpstreamGenes = allUpstreamGenes; 
    }

    public AllUpstreamGenes initializeUpstreamGenes(TargetGene targetGene){
        DAChromosome chr = targetGene.getTargetChromosome();
        ArrayList<DAGene> DAGenes = null;
        ArrayList<ChromosomeGene> chromGenes = new ArrayList<ChromosomeGene>();
        try {
            // We only get the upstream genes, that is, those that have indices
            // LOWER than the target gene.
            System.out.println("Retrieving all upstream genes...");
            DAGenes = (ArrayList<DAGene>) chr.getGenesOnRegion(1, targetGene.getCoordEnd());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        ArrayList<DAGene> removeGenes = new ArrayList<DAGene>();
        for (DAGene gene : DAGenes) {
            if (!gene.getBiotype().matches("protein_coding"))
                removeGenes.add(gene);
            try {
                if (gene.getTopLevelTargetCoordinates().getEnd()>targetGene.getTargetCoords().getEnd()) //they are overlapping
                    removeGenes.add(gene);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        for (DAGene removeGene : removeGenes) {
            DAGenes.remove(removeGene);
        }
        Coordinate targetCoords = null;
        Mapping chromosomeMapping = null;

        for (DAGene gene : DAGenes) {
            try {
                chromosomeMapping = gene.getChromosomeMapping();
            } catch (NonUniqueException e1) {
                e1.printStackTrace();
            }
            targetCoords = chromosomeMapping.getTargetCoordinates();
            ChromosomeGene chromosomeGene = new ChromosomeGene();
            chromosomeGene.setChromDisplayName(gene.getDisplayName());
            chromosomeGene.setChromStableGeneID(gene.getStableID());
            try {
                chromosomeGene.setChromStrand(gene.getTopLevelTargetCoordinates().getStrand());
            } catch (DAOException e) {
                e.printStackTrace();
            }
            chromosomeGene.setChromCoords(targetCoords);
            chromosomeGene.setChromCoordStart(targetCoords.getStart());
            chromosomeGene.setChromCoordEnd(targetCoords.getEnd());
            chromosomeGene.setBioType(gene.getBiotype());
            chromosomeGene.setDaGene(gene);
            chromGenes.add(chromosomeGene);
        }
        allUpstreamGenes.setUpstreamGenes(chromGenes);
        return allUpstreamGenes;
    }
    
    public AllForwardGenes initializeForwardChromosomeGenes(TargetGene targetGene) {
        DAChromosome chr = targetGene.getTargetChromosome();
        ArrayList<DAGene> DAGenesFwd = null;
        ArrayList<ChromosomeGene> chromGenesFwd = new ArrayList<ChromosomeGene>();
        try {
            // We only get the upstream genes, that is, those that have indices
            // LOWER than the target gene.
            System.out.println("Retrieving plus upstream genes...");
            DAGenesFwd = (ArrayList<DAGene>) chr.getGenesOnRegion(1, targetGene.getCoordEnd(), Coordinate.Strand.FORWARD_STRAND);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        ArrayList<DAGene> removeGenes = new ArrayList<DAGene>();
        for (DAGene gene : DAGenesFwd) {
            if (!gene.getBiotype().matches("protein_coding"))
                removeGenes.add(gene);
        }
        for (DAGene removeGene : removeGenes) {
            DAGenesFwd.remove(removeGene);
        }
        Coordinate targetCoords = null;
        Mapping chromosomeMapping = null;

        for (DAGene gene : DAGenesFwd) {
            try {
                chromosomeMapping = gene.getChromosomeMapping();
            } catch (NonUniqueException e1) {
                e1.printStackTrace();
            }
            targetCoords = chromosomeMapping.getTargetCoordinates();
            ChromosomeGene chromosomeGene = new ChromosomeGene();
            chromosomeGene.setChromDisplayName(gene.getDisplayName());
            chromosomeGene.setChromStableGeneID(gene.getStableID());
            chromosomeGene.setChromStrand(Coordinate.Strand.FORWARD_STRAND);
            chromosomeGene.setChromCoords(targetCoords);
            chromosomeGene.setChromCoordStart(targetCoords.getStart());
            chromosomeGene.setChromCoordEnd(targetCoords.getEnd());
            chromosomeGene.setBioType(gene.getBiotype());
            chromosomeGene.setDaGene(gene);
            chromGenesFwd.add(chromosomeGene);
        }
        allForwardGenes.setForwardGenes(chromGenesFwd);
        return allForwardGenes;
    }

    public AllReverseGenes initializeReverseChromosomeGenes(TargetGene targetGene) {
        DAChromosome chr = targetGene.getTargetChromosome();
        ArrayList<DAGene> DAGenesRvs = null;
        ArrayList<ChromosomeGene> chromGenesRvs = new ArrayList<ChromosomeGene>();
        try {
            // We only get the upstream genes, that is, those that have indices
            // LOWER than the target gene.
            System.out.println("Retrieving minus upstream genes...");
            DAGenesRvs = (ArrayList<DAGene>) chr.getGenesOnRegion(1, targetGene.getCoordEnd(), Coordinate.Strand.REVERSE_STRAND);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        ArrayList<DAGene> removeGenes = new ArrayList<DAGene>();
        for (DAGene gene : DAGenesRvs) {
            if (!gene.getBiotype().matches("protein_coding"))
                removeGenes.add(gene);
        }
        for (DAGene removeGene : removeGenes) {
            DAGenesRvs.remove(removeGene);
        }
        Coordinate targetCoords = null;
        Mapping chromosomeMapping = null;

        for (DAGene gene : DAGenesRvs) {
            try {
                chromosomeMapping = gene.getChromosomeMapping();
            } catch (NonUniqueException e1) {
                e1.printStackTrace();
            }
            targetCoords = chromosomeMapping.getTargetCoordinates();
            ChromosomeGene chromosomeGene = new ChromosomeGene();
            chromosomeGene.setChromDisplayName(gene.getDisplayName());
            chromosomeGene.setChromStableGeneID(gene.getStableID());
            chromosomeGene.setChromStrand(Coordinate.Strand.REVERSE_STRAND);
            chromosomeGene.setChromCoords(targetCoords);
            chromosomeGene.setChromCoordStart(targetCoords.getStart());
            chromosomeGene.setChromCoordEnd(targetCoords.getEnd());
            chromosomeGene.setBioType(gene.getBiotype());
            chromosomeGene.setDaGene(gene);
            chromGenesRvs.add(chromosomeGene);
        }
        allReverseGenes.setReverseGenes(chromGenesRvs);
        return allReverseGenes;
    }
}
