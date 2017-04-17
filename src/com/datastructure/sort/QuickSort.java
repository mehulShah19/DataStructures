package com.datastructure.sort;

public class QuickSort {
	
	/**
	 * The quick sort algorithm sorts a list by partitioning the list using an arbitrarily chosen partition element 
	 * and then recursively sorting the sublists on either side of the partition element.
	 *  The general strategy of the quick sort algorithm is as follows: 
	 *  First, choose one element of the list to act as a partition element. 
	 *  Next, partition the list so that all elements less than the partition element are to the left of
	 *  that element and all elements greater than the partition element are to the right.
	 *  
	 *  No Additional storage like MergeSort
	 *  
	 *  305 65 7 90 120 110 8
	 *    90 as partition element
	 *  8 65 7 90 120 110 305 
	 *  
	 *  To analyze the quickSort function, note that for a list of length n, 
	 *  if the partition always occurs in the middle of the list, 
	 *  there will again be lognlog⁡n divisions. 
	 *  In order to find the split point, each of the n items needs to be checked against the pivot value. 
	 *  The result is nlognnlog⁡n. In addition, there is no need for additional memory as in the merge sort process.

		Unfortunately, in the worst case, the split points may not be in the middle and can be very skewed to the left or the right, 
		leaving a very uneven division. 
		In this case, sorting a list of n items divides into sorting a list of 0 items and a list of n−1n−1 items. 
		Then sorting a list of n−1n−1 divides into a list of size 0 and a list of size n−2n−2, and so on. 
		The result is an O(n2)O(n2) sort with all of the overhead that recursion requires.

		We mentioned earlier that there are different ways to choose the pivot value. 
		In particular, we can attempt to alleviate some of the potential for an uneven division by using a technique called median of three. 
		To choose the pivot value, we will consider the first, the middle, and the last element in the list. 
		In our example, those are 54, 77, and 20. Now pick the median value, in our case 54,
		and use it for the pivot value (of course, that was the pivot value we used originally).
		The idea is that in the case where the the first item in the list does not belong toward the middle of the list, 
		the median of three will choose a better “middle” value. 
		This will be particularly useful when the original list is somewhat sorted to begin with.
		We leave the implementation of this pivot value selection as an exercise.
		
		On the average, it has O(n log n) complexity
		
		
	 */
	
	
	public static <T extends Comparable<? super T>> void quickSort(T[] data , int min, int max){
		int indexofpartition;
	      if (max - min > 0){
	        // Create partitions
	        indexofpartition = partition(data, min, max);
	        // Sort the left side
	        quickSort(data, min, indexofpartition - 1);	        
	        // Sort the right side
	        quickSort(data, indexofpartition + 1, max);
	      }
	}
	
	
	
	private static <T extends Comparable<? super T>> int partition(T[] data, int min, int max)
{
	T partitionelement;
	int left, right;
	//int middle = (min + max) / 2;
	
	
	int partitionIndex = findIndexOfPivotValue(data, min, max);
	partitionelement = data[partitionIndex];
	
	// use the middle data value as the partition element
	//partitionelement = data[middle];
	// move it out of the way for nw
	swap(data, partitionIndex, min);
	
	left = min;
	right = max;
	
	while (left < right)
	{
		// search for an element that is > the partition element
		while (left < right && data[left].compareTo(partitionelement) <= 0)
			left++;
		
		// search for an element that is < the partition element
		while (data[right].compareTo(partitionelement) > 0)
			right--;
		
		if (left < right)
			swap(data, left, right);
	}
	
	
	// move the partition element into place
	swap(data, min, right);
	
	return right;
}

	private static <T extends Comparable<? super T>>
	void swap(T[] data, int index1, int index2)
{
	T temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
}

	private static int findIndexOfPivotValue(Comparable[] a, int min, int max) {
		
    	
    	if(min == max){return min;}
    	
    	
        Comparable firstElement = a[min];
    	Comparable lastElement = a[max];
    	Comparable middleElement = a[(int)(max + min)/2];
    	
    	Comparable[] b = {firstElement, middleElement, lastElement};
    	for(int i = 0; i < b.length - 1; i++){
    		for(int j = i+1; j<b.length; j++){
    			if(b[i].compareTo(b[j]) >=1){
    				Comparable temp = b[i];
    				b[i] = b[j];
    				b[j] = temp;
    			}
    		}
    	}
    	if(b[1] == firstElement){return min;}
    	if(b[1] == lastElement){return max;}
    	return (min+max/2);
    }
}
