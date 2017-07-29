package com.datastructure.tree;

import java.util.Iterator;

public interface BinaryTreeADT<T> {

	public T getRoot();
	public int size();
	public boolean isEmpty();
	public boolean contains();
	public T find();
	public Iterator<T> iteratorInOrder();
	public Iterator<T> iteratorPreOrder();
	public Iterator<T> iteratorPostOrder();
	public Iterator<T> iteratorLevelOrder();
		
	
	
	
}
