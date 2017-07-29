package com.datastructure.tree;

import java.util.Iterator;


public class LinkedBinarySearchTree<T> implements BinarySearchTreeADT<T>{

	int count;
	BinaryTreeNode<T> root;
	
	@Override
	public void addElement(T element) {
		// TODO Auto-generated method stub
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
		newNode.element = element;
		Comparable<T> comparableElement = (Comparable<T>)element;
		if(isEmpty()){
			root = newNode;
			count++;
			return;
		}	
		
	//	Comparable<T> selectedNode = (Comparable<T>) root;
		BinaryTreeNode<T> selectedNode = root;
		boolean isAdded = false;
		while(!isAdded)
		{
		if(comparableElement.compareTo(selectedNode.getElement())< 0){
			//selectedNode = selectedNode.getLeftNode();
			if(selectedNode.leftNode == null){
				selectedNode.leftNode = newNode;
				isAdded= true;
				count++;
			}else{
				selectedNode = selectedNode.getLeftNode();
			}
		}else{
			if(selectedNode.rightNode == null){
				selectedNode.rightNode = newNode;
				isAdded = true;
				count++;
			}else{
				selectedNode = root.getRightNode();
					
			}
	
		}}}
	
	
	

	@Override
	public T removeElement(T targetElement) {
		// TODO Auto-generated method stub
		T result = null;
		if(isEmpty()){
		//	throw new ElementNotFoundException("Binary Search Tree");
		}
		if (((Comparable)targetElement).equals(root.element))
	      {
			result = root.element;
	        root = replacement (root);
	        count--;
	        return result; 
	      }  
	
		BinaryTreeNode<T> current,parent = root;
		boolean found = false;
		
		// THis is used to establish relationship wit the parent
		
		if (((Comparable)targetElement).compareTo(root.element) < 0)
            current = root.leftNode;
         else
            current = root.rightNode;
		
		while (current != null && !found)
        {
  
//			//Steps to perfom remove 
//			1. Search for the node
//			2. if the node is found run remove algorithm
//			
//			Node to be removed has no children
			
			
			
			
			if (targetElement.equals(current.element))
           {
              found = true;
              count--;
              result = current.element;
              if (current == parent.leftNode)
              {
                 parent.leftNode = replacement (current);
              }
              else {
                 parent.rightNode = replacement (current);
              }
           } else {
              parent = current;
if (((Comparable)targetElement).compareTo(current.element) < 0) current = current.leftNode;
              else
                 current = current.rightNode;
           }
        }
		return result;
		
	}
	
	

	 /* Returns a reference to a node that will replace the one
	 * specified for removal.  In the case where the removed node has
	 * two children, the inorder successor is used as its replacement.
	 *
	* @param node the node to be removed
	* @return a reference to the replacing node*/
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		// TODO Auto-generated method stub
		// if the node has no children
		BinaryTreeNode<T> result = null;
		   if ((node.leftNode == null)&&(node.rightNode==null))
		      result = null;
		   else if ((node.leftNode != null)&&(node.rightNode==null))
		      result = node.leftNode;
		   else if ((node.leftNode == null)&&(node.rightNode != null))
		      result = node.rightNode;
		
		
		return null;
	}

	@Override
	public T getRoot() {
		// TODO Auto-generated method stub
		if(root == null){
			return null;
		}
		return root.element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(count == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean contains() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return new LevelOrderTraversal<>(root);
	}

	@Override
	public void removeAllOccurences(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
