package com.datastructure.queue;


/**
 * Queue performs operation in First In First Out basis
 * Queue basic operations are enqueue and dequeue
 * 
 * @author Mehul
 *
 * @param <T>
 */
public interface QueueADT<T> {
	public void enqueue(T node);
	public T dequeue();
	public T first();
	public int size();
	public boolean isEmpty();
	public String toString();
}
