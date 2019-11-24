package priorityQueues;

import java.util.Comparator;

import list.LinkedPositionalList;
import list.Position;
import list.PositionalList;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
//	primary collection of priority queue entries
	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();
	
//	creates empty priority queue based on natural ordering of keys
	public UnsortedPriorityQueue() {
		super();
	}
//	creates empty priority queue using given comparator to order keys
	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
//	returns Position of an entry having minimal key
	private Position<Entry<K, V>> findMin() {
		Position<Entry<K, V>> small = list.first();
		for(Position<Entry<K, V>> walk : list.positions())
			if (compare(walk.getElement(), small.getElement()) < 0)
				small = walk;
		return small;
	}
	
//	Inserts key-value pair and returns the entry created
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}
	
//	returns but doesn't remove entry with minimal key
	public Entry<K, V> min() {
		if (list.isEmpty()) return null;
		return findMin().getElement();
	}
	
//	removes and returns an entry with minimal key
	public Entry<K, V> removeMin() {
		if (list.isEmpty()) return null;
		return list.remove(findMin());
	}
	
	public int size() {
		return list.size();
	}
}
