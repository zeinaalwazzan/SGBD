package Exercice;

import java.util.ArrayList;

public class ExternalSorting {
	int nbElements = 0;
	int nbElementsPerPage = 0;
	int nbPages = 0;
	int nbPagesBuffer = 0;
	int nbMergesPasses = 0;
	int nbRuns = 0;
	String inputPath = "";
	String outputPath = "";

	ArrayList<SGBDRun> listOfRuns = new ArrayList<SGBDRun>();
	ArrayList<Page> listOfPage = new ArrayList<Page>();

	public static void main(String[] args) {

	}

	public void readInputFile(String path) {

		ArrayList<Integer> listNumber = new ArrayList<Integer>();
		// Coder la fonction read
		//If première ligne = "MERGESPASSES"=> 
		//* 1 Lire fichier => sc = new Scanner(new File(dataFile));							
		//* 2 Délimiter => //sc.useDelimiter(",|\r\n");
		//* Ajouter dans new ArrayList();
		
		this.nbElements = listNumber.size();
		this.nbPages = this.nbElements / this.nbElementsPerPage;
		for (Integer nb : listNumber) {
			int cptMaxPage = 0;
			ArrayList<Integer> bufferArray = new ArrayList<Integer>();
			while (cptMaxPage != nbElementsPerPage) {
				bufferArray.add(nb);
			}
			listOfPage.add(new Page(bufferArray));
		}
	}

	public void writeOutPutFile(String path) {
		// Coder la fonction write
		// Ecrire merge peses en haut
		for (SGBDRun run : listOfRuns) {
			run.toString();
		}
	}

	public void externalSort() {
		// Part 2
		 do{
			readInputFile(inputPath);
		// Part 3
			this.nbRuns = Math.round(this.nbPages / (this.nbPagesBuffer - this.nbMergesPasses));
		// Part 4 - Cutting
			for (Page page : listOfPage) {
				int cptMaxRun = 0;
				ArrayList<Page> bufferArray = new ArrayList<Page>();
				while (cptMaxRun != nbRuns) {
					bufferArray.add(page);
				}
				listOfRuns.add(new SGBDRun(bufferArray));
			}
		// Part 5 - Sorting
			for (SGBDRun run : listOfRuns) {
				run.sort();
			}
		// Part 6 - Merge Phase
			this.nbMergesPasses++;
			
		// Part 7 - Write in outputfile
			writeOutPutFile(outputPath);
		}while (this.nbRuns != 1);
	}

}
