package com.datastructure.sort;

public class InsertionSort {

	/** You create the front section as sorted elements and keep on adding elements
	 * in the sorted list 
	 * First compare two elements then select the third element and so ons
	 *  O(n2)
	 *  
	 *  1 4 3 2 0
	 *  1 4 3 2 0
	 *  1 3 4 2 0
	 *  1 3 2 4 0 
	 *  1 2 3 4 0 
	 *  
	 *  1 2 3 0 4
	 *  1 2 0 3 4
	 *  1 0 2 3 4
	 *  0 1 2 3 4
	 *  
	 *  
	  * @param data
	  */
	public static <T extends Comparable<? super T>> void insertionSort(T[] data){
		
		for(int i = 1; i < data.length; i++){
			
			int j = i - 1;
			T insertedElementInSortingList = data[i];
			while(j >=0 && insertedElementInSortingList.compareTo(data[j]) <= 0){
				T temp = data[j+1];
				data[j+1] = data[j];
				data[j] = temp;
				j--;
			}
			printdata(data);
		}
	}
	
	

	private static <T extends Comparable<? super T>> void printdata(T[] data) {
		// TODO Auto-generated method stub
		
		for( int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
			
		}
		System.out.println();
		
	}
}
