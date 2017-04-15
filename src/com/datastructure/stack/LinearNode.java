package com.datastructure.stack;

public class LinearNode<T> {

	public LinearNode() {
		// TODO Auto-generated constructor stub
	}
	
	public LinearNode(T element){
		currentElement  = element;
	}
	
	private LinearNode<T> nextNode;
	private T currentElement;
	public LinearNode<T> getNextNode() {
		return nextNode;
	}
	
	
	
	public void setNextNode(LinearNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	public T getCurrentElement() {
		return currentElement;
	}
	public void setCurrentElement(T currentElement) {
		this.currentElement = currentElement;
	}
}
