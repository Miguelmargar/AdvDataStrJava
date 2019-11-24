package heaps;

import java.util.Comparator;

import priorityQueues.Entry;

public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> {

//	nested AdaptablePQEntry class
//	extension of the PQEntry to include location info
	protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
		private int index;
		public AdaptablePQEntry(K key, V value, int j) {
			super(key, value);
			index = j;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int j) {
			index = j;
		}
	}
	
//	creates empty adaptable priority queue using natural ordering of keys
	public HeapAdaptablePriorityQueue() {
		super();
	}
	public HeapAdaptablePriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
//	protected utilities
//	validates entry to ensure it is location aware
	protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
		if (!(entry instanceof AdaptablePQEntry)) 
			throw new IllegalArgumentException("Invalid entry");
		AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;
		int j = locator.getIndex();
		if (j >= heap.size() || heap.get(j) != locator)
			throw new IllegalArgumentException("Invalid entry");
		return locator;
	}
	
//	exchanges the entries at indices i and j of the array list
	protected void swap(int i, int j) {
		super.swap(i, j);
		((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i);
		((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j);
	}
	
//	restores heap property by moving entry at index j up or down
	protected void bubble(int j) {
		if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
			upheap(j);
		else
			downheap(j);
	}
	
//	inserts key-value pair and returns entry created
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
		heap.add(newest);
		upheap(heap.size() - 1);
		return newest;
	}
	
//	removes given entry from priority queue
	public void remove(Entry<K, V> entry) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		int j = locator.getIndex();
		if (j == heap.size() - 1)
			heap.remove(heap.size() - 1);
		else {
			swap(j, heap.size() - 1);
			heap.remove(heap.size() - 1);
			bubble(j);
		}
	}
	
//	replaces key of an entry
	public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		checkKey(key);
		locator.setKey(key);
		bubble(locator.getIndex());
	}
	
//	replaces value of an entry
	public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		locator.setValue(value);
	}
	
	
	
	
	
}
