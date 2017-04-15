package com.datastructure.queue;

import java.util.EmptyStackException;

/**
 * If we implement Queue using array witout circular array
 * we either have to do shifting operation which will result O(N) complexity
 * Or we will waste lots of space in the start if the element are removed from the start and we keep on expanding the capacity of array
 * 
 * So circular array queue solves both the problem
 * count plays importaant character
 * and the expansion is done when front and end interact each other
 * rear = (rear + 1 % circularqueue.length) will help in finding the index of newly added element
 * 
 * After expandin make the front back to 0 and rear to the length of elements present
 * @author Mehul
 *
 * @param <T>
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
	
	final int DEFAULT_QUEUE_SIZE = 100;
	T[] queue;
	int front,rear;
	int count;
	int noOFElemnts;
	
	
	public CircularArrayQueue() {
		 queue = (T[]) new Object[DEFAULT_QUEUE_SIZE];
	}
	
	public CircularArrayQueue(int initialCapacity){
		 queue = (T[]) new Object[initialCapacity];		
	}
	
	@Override
	public void enqueue(T node) {
//		rear++;
//		
//		if(rear == front){
//			//expandCapacity();
//		}
//		if(rear >= queue.length)
//			rear  = 0;
//		queue[rear] = node;
		rear = (rear+1) % queue.length;
		
		if(rear == front){
			expandCapacity();
		}
		
		queue[rear] = node;
		count++;
			
	}
	
	private void expandCapacity(){
		T[] expandedQueue = (T[])new Object[queue.length * 2];
		for(int i =0 ; i<queue.length ; i++){
			expandedQueue[i] = queue[front % queue.length];
			front++;	
		}
		front = 0;
		rear = queue.length - 1;
		queue  = expandedQueue; 
	}
	

	 public T dequeue() throws EmptyStackException
	   {
	     if  (isEmpty())
	          throw new EmptyStackException();
	     T result = queue[front];
	     queue[front] = null;
	     front = (front+1) % queue.length;
	     count--;
	     return result;
	   }

	@Override
	public T first() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
	
}
