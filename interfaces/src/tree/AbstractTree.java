package tree;

import java.util.ArrayList;
import java.util.List;
import list.Position;
import queue.LinkedQueue;
import queue.Queue;


public abstract class AbstractTree<E> implements Tree<E> {
	
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}
	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}
	public boolean isRoot(Position<E> p) {
		return p == root();
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int depth(Position<E> p) {
		if (isRoot(p)) return 0;
		else return 1 + depth(parent(p));
	}
	
	private int heightBad() {
		int h = 0;
		for (Position<E> p : positions()) {
			if (isExternal(p)) h = Math.max(h, depth(p));
		}
		return h;
	}
	
	public int height(Position<E> p) {
		int h = 0;
		for (Position<E> c : children(p)) {
			h = Math.max(h, 1 + height(c));
		}
		return h;
	}
	
//	adds positions of the subtree rooted at Position p to the given snapshot
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p);
		for (Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}
	
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) preorderSubtree(root(), snapshot);
		return snapshot;
	}
	
//	Adds positions of the subtree rooted at Position p to the given snapshot
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p);
	}
	
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) postorderSubtree(root(), snapshot);
		return snapshot;
	}
	
//	Returns an iterable collection of positions of the tree in breath-first order
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				snapshot.add(p);
				for (Position<E> c : children(p))
					fringe.enqueue(c);
			}
		}
		return snapshot;
	}
}
