
package com.datastructure.map;
import java.util.LinkedList;
import java.util.Queue;

/**Chaining Probe technique is a technique used to resolve collision when more than one element
 * is pointing to the same location
 * In a single chain technique, every position contains another collection like list or array to store elements
 * and only one hash function is used
 * 
 * In TwoProbe chain rather then selecting one hash function, we use two hash function to decide on which location the element will be placed
 * This helps in having the shorter chains 
 * 
 * @author Mehul
 *
 * @param <Key>
 * @param <Value>
 */

public class TwoProbeChainMap<Key,Value> implements Map<Key,Value>{

	private class Entry {
		public Key key;
		public Value value;
		public Entry (Key k, Value v) {
			key = k;
			value = v;
		}
	}

	private int N; // capacity of key-value pairs
	private int M; // No. of elements filled in LinearList

	private LinkedList<Entry>[] entries;// this is the array where Key value pair will be stored

	//Default size map is created with this constructor
	public TwoProbeChainMap() {
		this(997);
	}

	// Constructor with size of the map
	public TwoProbeChainMap(int M) {
		this.N = 0;
		this.M = M;
		entries = new LinkedList[M];
		for (int i = 0; i < M; i++)
			entries[i] = new LinkedList<>();
	}

	/**THis value will return the position in the list which depends on key
	 *  
	 */
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	/**THis value will return another suitable position in the list which depends on key
	 *  
	 */
	private int hash2(Key key){
		return ((((key.hashCode() & 0x7fffffff) % M) *31) %M);
	}

	/**
	 * It stores the value in the Map
	 * It checks the key value and decide if the element is already present or not
	 * If not present than it will add to the list
	 */
	@Override
	public void put(Key key, Value val) {
		int hashKey1 = hash(key);
		int hashKey2 = hash2(key);
		Entry newNode = new Entry(key, val);

		LinkedList<Entry> linkedList1= entries[hashKey1];
		LinkedList<Entry> linkedList2= entries[hashKey2];

		//Check if the element is already present
		for(Entry e: linkedList1){
			if(e.key.hashCode() == key.hashCode()){
				e.value = val;
				return;
			}
		}
		for(Entry e: linkedList2){
			if(e.key.hashCode() == key.hashCode()){
				e.value = val;
				return;
			}
		}
		// If element is not present add the element depending on the size of the collection
		if(linkedList1.size() <= linkedList2.size()){
			linkedList1.add(newNode);
		}else{
			linkedList2.add(newNode);
		}
		N++;
	}
	/**
	 * It returns the value of the key if present
	 * else it will return null
	 */
	@Override
	public Value get(Key key) {
		int hashKey1 = hash(key);
		int hashKey2 = hash2(key);
		//Checks in the list of 1st hashkey position
		for(Entry e : entries[hashKey1]){
			if(e.key.hashCode() == key.hashCode())
				return e.value;
		}
		//Checks in the list of 2nd hashkey position
		for(Entry e : entries[hashKey2]){
			if(e.key.hashCode() == key.hashCode())
				return e.value;
		}
		return null;
	}

	/**
	 * It removes the value of the key if present
	 * 
	 */	
	@Override
	public void remove(Key key) {
		int hashKey1 = hash(key);
		int hashKey2 = hash2(key);
		// It checks in the list of 1st hashkey position
		// If key is present then it will delete the element from that list
		for(Entry e : entries[hashKey1]){
			if(e.key.hashCode() == key.hashCode())
				entries[hashKey1].remove(e);
			N--;
			return;
		}
		// It checks in the list of 2nd hashkey position
		// If key is present then it will delete the element from that list
		for(Entry e : entries[hashKey2]){
			if(e.key.hashCode() == key.hashCode())
				entries[hashKey2].remove(e);
			N--;
			return;
		}

	}

	/**
	 * It checks whether there is any value present to corresponding key
	 */
	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		if(get(key) == null)
			return false;
		return true;
	}


	/**
	 * Checks if the size of the array is 0 or not
	 */
	@Override
	public boolean isEmpty() {
		if(N == 0){
			return true;
		}
		return false;
	}

	//Returns the size of the map
	@Override
	public int size() {
		return N;
	}


	// Used to return Iterator which contains key
	@Override
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<>();

		for (int i = 0; i < M; i++)
			for(Entry e : entries[i])
				queue.add(e.key);

		return queue;
	}


}
