package tree;

import java.util.ArrayList;
import java.util.List;

import list.Position;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	
//	returns the position of p's siblings or null if no siblings
	public Position<E> sibling(Position<E> p) {
		Position<E> parent = parent(p);
		
		if (parent == null) return null;
		
		if (p == left(parent)) return right(parent);
		else return left(parent);
	}
	
//	returns the number of children of Position p
	public int numChildren(Position<E> p) {
		int count = 0;
		
		if (left(p) != null) count++;
		
		if (right(p) != null) count++;
		
		return count;
	}
	
//	returns an iterable collection of the Positions representing p's children
	public Iterable<Position<E>> children(Position<E> p) {
		List<Position<E>> snapshot = new ArrayList<>(2);
		
		if (left(p) != null) snapshot.add(left(p));
		
		if (right(p) != null) snapshot.add(right(p));
		
		return snapshot;
	}
	
//	Bellow is for inorder Iterable
//	Adds positions of the subtree rooted at Position p to the given snapshot
	private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		if (left(p) != null)
			inorderSubtree(left(p), snapshot);
		snapshot.add(p);
		if (right(p) != null)
			inorderSubtree(right(p), snapshot);
	}
	
//	returns an iterable collection of positions of the tree in order
	public Iterable<Position<E>> inorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			inorderSubtree(root(), snapshot);
		return snapshot;
	}
	
//	overrides positions to make inorder the default order for binary trees
	public Iterable<Position<E>> positions() {
		return inorder();
	}
}


