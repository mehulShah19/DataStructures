package com.datastructure.map;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Linear Probing is a technique used to resolve collision when more than one element
 * is pointing to the same location
 * In normal LinearProbing Map we first find the location through hash method which uses the hashcode of key and size of the table
 * to find a suitable place for the value
 * If the location is empty then it occupies that location
 * However, if the location is not empty it will move one step forward to find the next location which is not empty
 * Normally, it is incremented by constant i to select the next location
 * 
 * In the assignment, to find the next location we will be using no if collision to detect the next location
 * No. of collision increases if the location is not empty
 * 
 * @author Mehul
 *
 * @param <Key>
 * @param <Value>
 */

public class LinearProbingMap<Key, Value> implements Map<Key, Value> {
	
	private class Entry<Key,Value> {
		public Key key;
		public Value value;
		public boolean isActive; // This value is used to implement Lazy Delete, we will change the flag to false to delete the entry element
		public Entry (Key k, Value v, boolean isActive) {
			key = k;
			value = v;
			this.isActive = isActive;
		}
	}

	private int M; // capacity of the list
	private int N; // No. of elements filled in LinearList
	final static int DEFAULT_CAPACITY = 997;// Default size if the user doesn't pass the size value to constructor

	Entry<Key,Value>[] entries; // this is the array where Key value pair will be stored
	//Default size map is created with this constructor
	public LinearProbingMap() {
		entries = new Entry[DEFAULT_CAPACITY];
		M = DEFAULT_CAPACITY;
		N = 0;
	}

	// Constructor with size of the map
	public LinearProbingMap(int size){
		entries =  new Entry[size];
		M = size;
		N = 0;
	}

	/*THis value will return the position in the list which depends on key and no of collision
	 *  
	 */
	private int hash(Key k , int i){
		return ((k.hashCode() & 0x7fffffff) + i) % M;
	}
	
	/**
	 * It stores the value in the Map
	 * It checks the key value and decide if the element is already present or not
	 * If not present than it will add to the list
	 */
	@Override
	public void put(Key key, Value val) {
		int noOfCollisions = 0;
		// We can expand the array depending on the load factor
		// Suppose load factor is 75% once the no. of elements reaches to 75% of total size(M), we will expand the array
		while(true){  
			int currentPosition = hash(key,noOfCollisions);
			if(entries[currentPosition] == null){
				entries[currentPosition] = new Entry<Key, Value>(key, val, true);
				N++;
				return;
			}
			if(entries[currentPosition].key.hashCode() == key.hashCode()){
				entries[currentPosition].value = val;
				if(!entries[currentPosition].isActive){ // If it's already present but not active i.e. it's been removed from the list
					entries[currentPosition].isActive = true;
					N++;
				}	
				return;
			}
			noOfCollisions++;
		}
	}	

	
	/**
	 * It returns the value of the key if present
	 * else it will return null
	 */
	@Override
	public Value get(Key key) {
		int noOfCollisions = 0;
		int currentPosition = hash(key, noOfCollisions);
		while(entries[currentPosition] !=null){
			if(entries[currentPosition].key.hashCode() == key.hashCode()){
				if(!entries[currentPosition].isActive){
					return null;
				}
				return entries[currentPosition].value;
			}
			noOfCollisions++;
		}
		return null;
	}

	/**
	 * It removes the value of the key if present
	 * Lazy delete is done. It just changes the flag of isActive to flag if it's true 
	 */
	@Override
	public void remove(Key key) {
		int noOfCollisions = 0;
		int currentPosition = hash(key, noOfCollisions);
		while(entries[currentPosition] !=null){
			if(entries[currentPosition].key.hashCode() == key.hashCode()){
				if(entries[currentPosition].isActive){
					entries[currentPosition].isActive = false;
					N--;
				}
				return;
			}
			noOfCollisions++;
		}
		return;
	}

	/**
	 * It checks whether there is any value present to corresponding key
	 */
	@Override
	public boolean contains(Key key) {
		if(get(key) == null){
			return false;
		}
		return true;
	}

	/**
	 * Checks if the size of the array is 0 or not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(N == 0){
			return true;
		}
		return false;
	}

	//Returns the size of the map
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

	// Used to return Iterator which contains key
	@Override
	public Iterable<Key> keys() {        
		Queue<Key> queue = new LinkedList<>();
		for (int i = 0; i < M; i++){
			if(entries[i] != null){
				queue.add(entries[i].key);
			}
		}  
		return queue;
	}

}
