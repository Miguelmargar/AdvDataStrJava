package heaps;

import java.util.ArrayList;
import java.util.Comparator;

import priorityQueues.AbstractPriorityQueue;
import priorityQueues.Entry;

// Array-based heap implementation
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
//	primary collection of priority queue entries
	protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
	
//	creates empty priority queue based on the natural ordering of keys
	public HeapPriorityQueue() {
		super();
	}
//	creates empty priority queue using given comparator to order keys
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
//	protected utilities
	protected int parent(int j) {
		return (j - 1) / 2;
	}
	protected int left(int j) {
		return 2 * j + 1;
	}
	protected int right(int j) {
		return 2 * j + 1;
	}
	protected boolean hasLeft(int j) {
		return left(j) < heap.size();
	}
	protected boolean hasRight(int j) {
		return right(j) < heap.size();
	}
	
//	Exchanges the entries at indices i and j of the array list
	protected void swap(int i, int j) {
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
//	moves the entry at index j higher if necessary to restore heap property
	protected void upheap(int j) {
		while (j > 0) {
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0) break;
			swap(j, p);
			j = p;
		}
	}
	
//	moves entry at index j lower if necessary to restore heap property
	protected void downheap(int j) {
		while (hasLeft(j)) {
			int leftIndex = left(j);
			int smallChildIndex = leftIndex;
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
					smallChildIndex = rightIndex;
			}
			if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
				break;
			swap(j, smallChildIndex);
			j = smallChildIndex;
		}
	}
	
//	public methods
//	returns but doesn't remove entry with minimal key
	public int size() {
		return heap.size();
	}
	public Entry<K, V> min() {
		if (heap.isEmpty()) return null;
		return heap.get(0);
	}
	
//	inserts a key-value pair and returns entry created
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		heap.add(newest);
		upheap(heap.size() - 1);
		return newest;
	}
	
//	removes and returns entry with minimal key if any
	public Entry<K, V> removeMin() {
		if (heap.isEmpty()) return null;
		Entry<K, V> answer = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		downheap(0);
		return answer;
	}
}
