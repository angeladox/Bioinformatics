package org.adoxsey.bioinformatics.util;

import java.util.ArrayList;
import java.util.List;

import org.adoxsey.bioinformatics.model.ChromosomeGene;
import org.adoxsey.bioinformatics.model.TargetGene;
import org.adoxsey.bioinformatics.repository.AllForwardGenes;
import org.adoxsey.bioinformatics.repository.AllReverseGenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.ac.roslin.ensembl.datasourceaware.core.DAChromosome;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.model.Coordinate.Strand;

@Component
public class SequenceRetriever {

	@Autowired
	IndexCalculator indexCalculator;
	@Autowired
	AllForwardGenes allForwardGenes;
	@Autowired
	AllReverseGenes allReverseGenes;

	private int length;

	public String getSameSequence(TargetGene targetGene) {
		System.out.println("Retrieving same sequence...");
		ChromosomeGene sameGene = null;
		if (targetGene.getTargetStrand().equals(Strand.FORWARD_STRAND)) {
			sameGene = indexCalculator.calculateForwardIndices(targetGene, allForwardGenes);
		}
		if (targetGene.getTargetStrand().equals(Strand.REVERSE_STRAND)) {
			sameGene = indexCalculator.calculateReverseIndices(targetGene, allReverseGenes);
		}
		return getSequenceBetween(targetGene, sameGene);
	}

	public String getEitherSequence(TargetGene targetGene) {
		System.out.println("Retrieving either sequence...");
		ChromosomeGene eitherGene = null;
		if (targetGene.getTargetStrand().equals(Strand.FORWARD_STRAND)) {
			eitherGene = indexCalculator.calculateReverseIndices(targetGene, allReverseGenes);
		}
		if (targetGene.getTargetStrand().equals(Strand.REVERSE_STRAND)) {
			eitherGene = indexCalculator.calculateForwardIndices(targetGene, allForwardGenes);
		}
		return getSequenceBetween(targetGene, eitherGene);
	}

	public String getSequenceBetween(TargetGene targetGene, ChromosomeGene chromosomeGene) {
		DAChromosome chr = targetGene.getTargetChromosome();
		String sequenceString = "";
		int sequenceLength = 0;
		List<DAGene> daSequence = new ArrayList<DAGene>();
		try {
			daSequence = chr.getGenesOnRegion(targetGene.getCoordEnd(), chromosomeGene.getChromCoordEnd());
			for (DAGene gene : daSequence) {
				sequenceString += gene.getSequenceAsString();
				sequenceLength += gene.getLength();
			}
		} catch (Exception e) {
			System.out.println("Could not get sequence genes.");
		}
		setSequenceLength(sequenceLength);
		return sequenceString;
	}

	public int getSequenceLength() {
		return this.length;
	}

	public void setSequenceLength(int length) {
		this.length = length;
	}
}
