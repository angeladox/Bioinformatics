package org.adoxsey.bioinformatics.model;

import org.springframework.stereotype.Component;

import uk.ac.roslin.ensembl.dao.database.DBSpecies;
import uk.ac.roslin.ensembl.datasourceaware.core.DAChromosome;
import uk.ac.roslin.ensembl.datasourceaware.core.DAGene;
import uk.ac.roslin.ensembl.model.Coordinate;

@Component
public class ChromosomeGene extends DAGene{
        private static final long serialVersionUID = 1L;
        
        private String Stable_Gene_ID;
        private String Display_Name;;
        private String Species_Alias;
        private DBSpecies species;   
        private DAGene gene;
        private Coordinate coords;
        private Coordinate.Strand strand;   
        private Integer coordStart;
        private Integer coordEnd;
        private DAChromosome chr;
        
        public Integer getChromCoordStart() {
            coordStart = coords.getStart();
            return coordStart;
        }
        public void setChromCoordStart(Integer coordStart) {
            this.coordStart = coordStart;
        }
        public Integer getChromCoordEnd() {
            coordEnd = coords.getEnd();
            return coordEnd;
        }
        public void setChromCoordEnd(Integer coordEnd) {
            this.coordEnd = coordEnd;
        }
        
        public String getChromStableGeneID() {
            return Stable_Gene_ID;
        }
        public void setChromStableGeneID(String stable_Gene_ID) {
            Stable_Gene_ID = stable_Gene_ID;
        }
        public String getChromDisplayName() {
            return Display_Name;
        }
        public void setChromDisplayName(String display_Name) {
            Display_Name = display_Name;
        }
        public String getChromSpeciesAlias() {
            return Species_Alias;
        }
        public void setChromSpeciesAlias(String species_Alias) {
            Species_Alias = species_Alias;
        }
        public DBSpecies getSpecies() {
            return species;
        }
        public void setChromSpecies(DBSpecies species) {
            this.species = species;
        }
        public DAGene getChromGene() {
            return gene;
        }
        public void setChromGene(DAGene gene) {
            this.gene = gene;
        }
        public Coordinate getChromCoords() {
            return coords;
        }
        public void setChromCoords(Coordinate coords) {
            this.coords = coords;
        }
        public Coordinate.Strand getChromStrand() {
            return strand;
        }
        public void setChromStrand(Coordinate.Strand strand) {
            this.strand = strand;
        }
        public void setDAChromosomeChromosome(DAChromosome chr) {
            this.chr=chr;       
        }
        public DAChromosome getDAChromosome() {
            return chr;
        }


}
