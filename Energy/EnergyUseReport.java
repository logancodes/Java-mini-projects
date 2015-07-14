/*
Ushanth Loganathan
V00810681
  Program name: EnergyUseReport
  Program description: This program use objects from a different class called Energydata to get 
  information of energy usage from an input file.
  Program input: Data collected from the input file
  Program output: Displays the region according to highest and lowest total energy growth and its use per capaita
  during 1990-2008.
  The data is sorted and its stored in an array.
*/
import java.io.*;
import java.util.*;

public class EnergyUseReport{
	public static void main(String [] args)throws FileNotFoundException{
		File file=new File("EnergyUse.txt");
		if(file.exists()){//to check whether the file exists or not
			Scanner input = new Scanner(file);
			String value=input.nextLine();
			int number=input.nextInt();
			EnergyData ed[] = new EnergyData[number];
			for(int i=0;i<number;i++){//to extract data and put them into proper objects
				ed[i] = new EnergyData();
				ed[i].setRegion(input.next());
				ed[i].setPerCapita1990(input.nextDouble());
				ed[i].setPerCapita2008(input.nextDouble());
				ed[i].setPopulation1990(input.nextInt());
				ed[i].setPopulation2008(input.nextInt());
				ed[i].setTotal1990(input.nextDouble());
				ed[i].setTotal2008(input.nextDouble());
			}
			sortByPerCapitaGrowth(ed);
			System.out.println("The region with lowest energy per capita growth in energy use is "+ed[0].getRegion());
			System.out.println("The region with highest energy per capita growth in energy use is  "+ed[ed.length-1].getRegion());
			sortByTotalGrowth(ed);
			System.out.println("");
			System.out.println("The region with the lowest total growth in energy use is "+ed[0].getRegion());
			System.out.println("The region with the highest total growth in energy use is "+ed[ed.length-1].getRegion());
			System.out.println("Region that have more than doubled their energy between 1990-2008 are:");
			for(int i=0;i<ed.length;i++){
				if(ed[i].getTotalGrowthPercent()>100.0){//double the percentage
					System.out.println(ed[i].getRegion());
				}
			}
			System.out.println("");
			System.out.println("Region   GrowthPerCapita(%)    TotalGrowth(%)");
			for(int i=0;i<ed.length;i++){
				System.out.println(ed[i].getRegion()+"     "+ed[i].getPerCapitaGrowthPercent()+"       "+ed[i].getTotalGrowthPercent());
				//System.out.println();
			}
		}
	}
	/*
	purpose:to sort the data of TotalGrowth in increasing order
	output:to output the data in increasing order
	*/
	public static void sortByTotalGrowth(EnergyData array[]){
		for (int i = 0; i < array.length - 1; i++) {
			// find index of smallest remaining value
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].getTotalGrowthPercent() < array[min].getTotalGrowthPercent()) {
					min = j;
				}
			}
			// swap smallest value its proper place, a[i]
			swapObj(array, i, min);
		}
	}
	/*
	purpose:to sort the data of Percapita Growth in increasing order
	output:to output the data in increasing order
	*/
	public static void sortByPerCapitaGrowth(EnergyData array[]){
		for (int i = 0; i < array.length - 1; i++) {
			// find index of smallest remaining value
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].getPerCapitaGrowthPercent() < array[min].getPerCapitaGrowthPercent()) {
					min = j;
				}
			}
			// swap smallest value its proper place, a[i]
			swapObj(array, i, min);
		}
	}
	/*
	purpose:to swap data
	output:sawp data according to index 1 and index 2
	*/
	public static void swapObj(EnergyData[] a, int index1, int index2) {
		if (index1 >= 0 && index2 >= 0 && index1 < a.length && index2 < a.length){
			EnergyData temp = a[index1];
			a[index1] = a[index2];
			a[index2] = temp;
		}
	} 
}
