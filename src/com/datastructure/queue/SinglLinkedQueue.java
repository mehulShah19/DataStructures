package com.datastructure.queue;

import java.util.EmptyStackException;

import com.datastructure.stack.LinearNode;

/**
 * Linked List can be used to create the Queue
 * For time complexity to be one, we will implement using the starting Node as rear end 
 * and element will be added at the end 
 * 
 * Condition when 0 1 and many element should be consider while designing
 * 
 * @author Mehul
 *
 * @param <T>
 */
public class SinglLinkedQueue<T> implements QueueADT<T> {
	
	//enqueue and dequeue
	// enqueue will be done in the rear end
	// dequeue or removing the element is from the front end
	
	LinearNode<T> front, rear;
	int count;
	
	public SinglLinkedQueue() {
		front = rear= null;
		count = 0;
	}
	
	
	@Override
	public void enqueue(T node) {
		LinearNode<T> newNode = new LinearNode();
		newNode.setCurrentElement(node);
		
		if(count == 0){
			front = newNode;
			rear = newNode;
		}else{
			rear.setNextNode(newNode);
			rear = newNode;
		}	
		count ++;
	}

	@Override
	public T dequeue() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException(); 
		}
		LinearNode<T> resultNode = front;
		front = front.getNextNode();
		count--;
		
		// This condition will occur when there is only one element in the list
		if(isEmpty()){
			rear = null;
		}
		return resultNode.getCurrentElement();
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new EmptyStackException();
		return front.getCurrentElement();
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		if(count == 0){
			return true;
		}
		return false;
	}

}
