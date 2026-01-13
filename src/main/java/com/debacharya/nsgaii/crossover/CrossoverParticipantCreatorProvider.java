/*
 * MIT License
 *
 * Copyright (c) 2019 Debabrata Acharya
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.debacharya.nsgaii.crossover;

import com.debacharya.nsgaii.Service;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.Population;

import java.util.ArrayList;
import java.util.List;

public class CrossoverParticipantCreatorProvider {

	public static CrossoverParticipantCreator selectByBinaryTournamentSelection() {
		return population -> {

			List<Chromosome> selected = new ArrayList<>();
			List<Chromosome> chromosomes = deleteDuplicate(population.getPopulace());

//			Chromosome parent1 = Service.crowdedBinaryTournamentSelection(population);
//			Chromosome parent2 = Service.crowdedBinaryTournamentSelection(population);

			Chromosome parent1 = Service.crowdedBinaryTournamentSelection(new Population(chromosomes));
			Chromosome parent2 = Service.crowdedBinaryTournamentSelection(new Population(chromosomes));

			int count = 0;
			while(parent1.identicalGeneticCode(parent2) && count < (population.size()*(population.size()) + 1)/2)
				parent2 = Service.crowdedBinaryTournamentSelection(population);

//			while(parent1.identicalGeneticCode(parent2))
//				parent2 = Service.crowdedBinaryTournamentSelection(population);

			selected.add(0, parent1);
			selected.add(1, parent2);

			return selected;
		};
	}
	//去除重复染色体
	public static List<Chromosome> deleteDuplicate(List<Chromosome> originalChromosomes){
		List<Chromosome> chromosomes = new ArrayList<>();
		chromosomes.add(originalChromosomes.get(0));
		int j = 0;
		for (int i = 1; i < originalChromosomes.size(); i++){
			if (!originalChromosomes.get(i).identicalGeneticCode(chromosomes.get(j))){
				chromosomes.add(originalChromosomes.get(i));
				j++;
			}
		}
		return chromosomes;
	}

	public static CrossoverParticipantCreator randomParentSelection() {
		return population -> {

			List<Chromosome> selected = new ArrayList<>();

			Chromosome parent1 = Service.combinedSelection(population);
			Chromosome parent2 = Service.combinedSelection(population);

			int count = 0;

//			while(parent1.identicalGeneticCode(parent2) && count < (population.size()*(population.size()) + 1)/2)
//				parent2 = Service.crowdedBinaryTournamentSelection(population);

			while(parent1.identicalGeneticCode(parent2))
				parent2 = Service.combinedSelection(population);

			selected.add(0, parent1);
			selected.add(1, parent2);

			return selected;
		};
	}
}
