package com.datastructure.stack;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/** 
 * ArrayStack is performed by considering 0 as bottom
 * And the no>ofElement will be top element
 * O(1) for both insert and read operation
 * expandCapacity is used if the number of element has reached to the top most capacity
 * expandCapacity time complexity can be ignore(Since it's not going to be called
 * 
 * @author Mehul
 *
 * @param <T>
 */

public class ArrayStack<T> implements StackADT<T> {

	private static final int DEFAULT_ARRAY_SIZE = 100;
	private int top = 0;
	private T[] stack;
	
	public ArrayStack() {
		stack = (T[])new Object[DEFAULT_ARRAY_SIZE];
	}
	
	public ArrayStack(int capacity){
		stack = (T[])new Object[capacity];
	}
	
	
	@Override
	public void push(T element) {
		if(top == stack.length){
			expandCapacity();
		}
		stack[top] = element;
		top++;
	}
	
	public void expandCapacity(){
		T[] expandedStack = (T[])new Object[(stack.length * 2)];
		for (int i = 0 ; i < stack.length; i++){
			expandedStack[i] = stack[i];
		}
		stack = expandedStack;
	}
	
	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty() == true){
			throw new EmptyStackException();
		}
			top--;
			T result = stack[top];
			return result;
	}

	@Override
	public T peek() {
		if(isEmpty() == true){
			throw new EmptyStackException();
		}
			T result = stack[top];
			return result;
	}

	@Override
	public boolean isEmpty() {
		if(top == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return top;
	}
}
