package com.datastructure.stack;

/**
 * Stack Basic Functionality is mentioned 
 * i.e. push pop and peek
 * 
 * Theory
 * Last in First out
 * 
 * 
 * @author Mehul
 *
 * @param <T>
 */
public interface StackADT<T> {

	public void push(T element);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public int size();
	public String toString();
}
