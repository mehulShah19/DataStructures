package com.datastructure.tree;

public class BinaryTreeNode<T> {
	T element;
	BinaryTreeNode<T> leftNode, rightNode;
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public BinaryTreeNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
}