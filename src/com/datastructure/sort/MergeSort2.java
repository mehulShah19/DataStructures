package com.datastructure.sort;

public class MergeSort2 {

	
	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the index of the first element 
     * @param max  the index of the last element
     */
	static <T extends Comparable<T>>
		void mergeSort(T[] data, int min, int max)
	{
		System.out.println("Inside the mergeSort");
		printArray(data, min, max);
		
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
			System.out.println("After Merging");
			printArray(data, min, max);
		}
	}
	
	
	
	private static <T extends Comparable<T>> void printArray(T[] data, int min, int max) {
		// TODO Auto-generated method stub
		System.out.println("");
		for(int i = min ; i <= max; i ++){
			System.out.print(data[i] +" ");
			
		}
		
	}



	/**
     * Merges two sorted subarrays of the specified array.
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray 
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>>
		void merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[])(new Comparable[data.length]);
		
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
   }
}
