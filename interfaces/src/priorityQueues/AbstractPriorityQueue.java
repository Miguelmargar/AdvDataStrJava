package priorityQueues;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
	
//	nested PQEntry class
	protected static class PQEntry<K, V> implements Entry<K, V> {
		private K k;
		private V v;
		public PQEntry(K key, V value) {
			k = key;
			v = value;
		}
//		methods of the entry interface
		public K getKey() { 
			return k;
		}
		public V getValue() {
			return v;
		}
		
//		utilities not exposed as part of the Entry interface
		public void setKey(K key) {
			k = key;
		}
		public void setValue(V value) {
			v = value;
		}
	}
	
	
//	instance variable for an AbstractPriorityQueue
//	Comparator defining the ordering of keys in priority queue
	private Comparator<K> comp;
//	Creates empty priority queue using the given comparator to order keys
	protected AbstractPriorityQueue(Comparator<K> c) {
		comp = c;
	}
//	creates an empty priority queue based on natural ordering of keys
	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}
//	compares two entries according to key
	protected int compare(Entry<K, V> a, Entry<K, V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}
//	Determines whether a key is valid
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key, key) == 0);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
//	Test whether the priority queue is empty
	public boolean isEmpty() {
		return size() == 0;
	}
}





	
	

