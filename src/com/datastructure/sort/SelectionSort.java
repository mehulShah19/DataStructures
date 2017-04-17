package com.datastructure.sort;

public class SelectionSort {

	/*Selection Sort selects the smallest value in the list and places it in the firstPosition
	 * Then it selects the second most small element and place it in secondPosition
	 * and so on
	 * O(n2)
	 */
	
	/**
	 * 4 2 1 3
	 * 1 
	 * 
	 * @param data
	 */
	
	public static <T extends Comparable<? super T>> void selectionSort(T []data){
		for(int i = 0; i < data.length ; i++){
			int minIndex = i;
			
			for(int j = i+1; j <data.length; j++){
				
				if(data[minIndex].compareTo(data[j]) > 0){
					minIndex = j;
				}
			}	
		  T temp = data[minIndex];
		  data[minIndex] = data[i];
		  data[i] = temp;
			
		  printdata(data);
		}
	}
	private static <T extends Comparable<? super T>> void printdata(T[] data) {		
		for( int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();	
	}
}
