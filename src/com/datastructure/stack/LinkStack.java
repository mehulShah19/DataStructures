package com.datastructure.stack;

import java.util.EmptyStackException;
/**
 * Using single Linked List we can create Stack operation
 * Elements can be added on the front side and the elements can be removed from the front end
 * O(1) is the time complexity
 * @author Mehul
 *
 * @param <T>
 */

public class LinkStack<T> implements StackADT<T> {

	LinearNode<T> leftMostElement; // D C B A  so D
	int count = 0; // This parameter will be use to calculate size of the stack
	
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		LinearNode<T> newElement = new LinearNode<T>(element);
		count++;
		newElement.setNextNode(leftMostElement);
		leftMostElement = newElement;
		
	}

	@Override
	public T pop() throws EmptyStackException{
		// TODO Auto-generated method stub
		if(leftMostElement == null){
			throw new EmptyStackException();
		}
		T returnElement = leftMostElement.getCurrentElement();
		leftMostElement = leftMostElement.getNextNode();
		count --;
		return returnElement;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(leftMostElement == null){
			throw new EmptyStackException();
		}
		T returnElement = leftMostElement.getCurrentElement();
		return returnElement;	
		}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(leftMostElement == null){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
