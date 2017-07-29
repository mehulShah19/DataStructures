package com.datastructure.tree;

import java.util.Iterator;

/**
 * Binary sSearch tree has left node smaller and right node larger or equal to the current node
 * 
 * 
 * This explains the logic of removing the element from the list
 * http://www.algolist.net/Data_structures/Binary_search_tree/Removal
 * 
 * Balanced Search Tree
 * AVL tree methodology
 * Find the balancing factor of each node 
 * AVL is height of right tree - height of left tree
 * It can be -1 0 +1
 * Rotation begins from the bottom of the tree
 *
 *Rotation explanation
 *https://www.tutorialspoint.com/data_structures_algorithms/avl_tree_algorithm.htm
 * 
 * We always need to consider the inserted element branch first
 * 
 * Read the instructions mentioned 
 * http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * 
 * Start moving towards root from the inserted child
 * 1. Whenever u find the parent node as -2 or 2
 * Make three labels z - parent y child and x as grandchild
 * z - -2 y - -1 So Right Rotation
 * z = 2 y = 2 So Left Rotation
 * z = -2 y = 1 left right 
 * z =2 y = -1 right left rotation.
 * 
 * 
 * -ve then Right 
 * +ve So left
 * 
 * 
 * Removal or deletion in BST
 * First find the element
 * if element has no child node - great no operation
 * One child then replace that child directly
 * two children  replace it with the minimum element on the right node
 * 
 * AVL removal 
 * 1st perform BST delete
 * http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
 * Go towards root and see if there is any node which is unbalanced
 * 1 st select the z that unbalanced node
 * y will be largest height child of z
 * x will be largest height child of y
 * 
 * 
 * 
 * https://www.cs.bgu.ac.il/~ds122/wiki.files/ds122_ps6.pdf ( 1 sample application)
 * http://digital.cs.usu.edu/~allan/DS/Notes/AVL.pdf
 * 
 * Red BLack
 * http://www.geeksforgeeks.org/red-black-tree-set-1-introduction-2/
 * 
 * 2Log2(n+1)
 * 
 * We try recoloring first, if recoloring doesn’t work, then we go for rotation.
 * The algorithms has mainly two cases depending upon the color of uncle.
 * If uncle is red, we do recoloring. If uncle is black, we do rotations and/or recoloring.
 * 
 * Conditions for Red Black Tree
 * 
 * 1. Root has to be black
 * 2. Child and parent both can't be red
 * 3. No. of black elements from the root to the leaf should be same
 * 
 * 
 * Inserted element will always be red
 * Any element which is placed on root after operation will be black
 * 
 * If parent element is black do nothin
 * If parent element is red and the uncle element is red change the color of parent and uncle and make the grandparent as red
 * grandparent is root make it black. Continue from the grandparent node
 * If parent element is red and uncle element is black(empty element is considered to be black) perform rotation operation
 * After final rotation SWAP the color of parent and grandparent
 * 
 * 
 * Removal of item
 * Sibling color will be considered
 * Look at the color of the sibling
 * 
 * 
 * @author Mehul
 *
 * @param <T>
 */

public class BinarySearchTree<T> implements BinarySearchTreeADT<T> {

	BinaryTreeNode<T> parent;
	int count;
	
	
	
	@Override
	public T getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
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
		return null;
	}

	@Override
	public void addElement(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeElement(T element) {
		// TODO Auto-generated method stub
		
		return null;
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
