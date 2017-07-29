package com.datastructure.sort;

public class MainSorting {

	
	public static void main(String[] args){
		
	      Integer[] integer = new Integer[]{2, 13, 16, 12, 25, 23, 3, 7};
	      //InsertionSort.insertionSort(integer);
	      //SelectionSort.selectionSort(integer);
	    //  Sorting.selectionSort(integer);
	//      System.out.println("XXXX");
	 //     SelectionSort.selectionSort(integer);

	      ProfSorting.quickSort(integer);
	}
	
	
}
