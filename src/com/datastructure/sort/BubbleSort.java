package com.datastructure.sort;

public class BubbleSort {

	/**
	 * Swap two numbers in the whole list and store the largest number in the other corner
	 * Then again start swapping and compare till it reaches the second last position
	 * O(n2)
	 * 
	 * 9 6 8 12 3 1 7
	 * 6 9 8 12 3 1 7
	 * 6 8 9 12 3 1 7
	 * 6 8 9 12 3 1 7
	 * 6 8 9 3 12 1 7
	 * 6 8 9 3 1 12 7
	 * 6 8 9 3 1 7 12
	 * 
	 * Again with second starts from 0 to n -1 
	 * 
	 * @param data
	 */
	
	public static <T extends Comparable<? super T>> void bubbleSort(T[] data){

		for(int i = 1 ; i < data.length; i++){
			
			for(int j = 0; j < data.length - i; j++){
				if(data[j].compareTo(data[j+1]) >=1){
					T temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}	
}
