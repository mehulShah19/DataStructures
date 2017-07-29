package com.datastructure.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LevelOrderTraversal<T> implements Iterator<T>{

	List<BinaryTreeNode<T>> queue;
	public LevelOrderTraversal(BinaryTreeNode<T> rootNode) {
		queue = new ArrayList<BinaryTreeNode<T>>();
		if(rootNode != null)
			queue.add(rootNode);
	}		

	@Override
	public boolean hasNext() {
		// If the stack is empty all the items have been traversed
		if(queue.size() != 0){
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		BinaryTreeNode<T> resultNode = dequeue();
		if(resultNode == null){
			return null;
		}else{
			if(resultNode.leftNode != null){
				enqueue(resultNode.leftNode);
			}
			if(resultNode.rightNode != null){
				enqueue(resultNode.rightNode);
			}
		}
		return resultNode.getElement();
	}

	// Adds element in the add of the list
	public void enqueue(BinaryTreeNode<T> element){
		queue.add(element);
	}

	//Returns the first element which was inserted in the queue
	public  BinaryTreeNode<T> dequeue(){
		if(queue.size() == 0){
			return null;
		}
		return queue.remove(queue.size() - 1);
	}

}