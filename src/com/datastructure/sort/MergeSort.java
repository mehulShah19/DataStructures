package com.datastructure.sort;

public class MergeSort {

	/**
	 * MergeSort divides the array into two parts and keep dividing till only single element is present in the list
	 * Then it's being backtracked and two splittled arrays are merged into single array in sorted form
	 * MergeSort2 is more efficient than MergeSort
	 * @param data
	 * @return
	 */

	public static <T extends Comparable<? super T>> T[] mergeSort(T[] data){
		if(data.length <= 1){
			return data;
		}	
		int mid = data.length / 2;
		T[] firstArray = (T[])(new Comparable[mid]);
		T[] secondArray = (T[])(new Comparable[data.length - mid]);

		for(int i = 0 ; i < data.length; i++){
			if(i < mid)
			{firstArray[i] = data[i];
			}else{
				secondArray[i - mid] = data[i];
			}
		}

		T[] sorted1 = mergeSort(firstArray);
		T[] sorted2 =mergeSort(secondArray);

		return merge(sorted1, sorted2);
	}



	public static <T extends Comparable<? super T>> T[]  merge(T[] data1, T[] data2){

		int combinedSortedArrayLength = data1.length + data2.length;
		T[] combinedSortedArray = (T[])(new Comparable[combinedSortedArrayLength]);

		int data1Pointer = 0;
		int data2Pointer = 0;		
		int combinedDataPointer = 0;

		while(data1Pointer < data1.length && data2Pointer < data2.length){

			if(data1[data1Pointer].compareTo(data2[data2Pointer]) <= 0){
				combinedSortedArray[combinedDataPointer] = data1[data1Pointer];
				data1Pointer ++;
				combinedDataPointer++;

			}else{
				combinedSortedArray[combinedDataPointer] = data2[data2Pointer];
				data2Pointer ++;
				combinedDataPointer++;
			}
		}

		if(data1Pointer == data1.length){
			while(data2Pointer < data2.length){
				combinedSortedArray[combinedDataPointer] = data2[data2Pointer];
				data2Pointer ++;
				combinedDataPointer++;
			}
		}else{
			while(data1Pointer < data1.length){
				combinedSortedArray[combinedDataPointer] = data1[data1Pointer];
				data1Pointer ++;
				combinedDataPointer++;
			}
		}
		return combinedSortedArray;

	}
}








