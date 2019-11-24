package tree;

import java.util.ArrayList;

import list.Position;

public class TreeApplications {
	
//	prints preorder representation of subtree of T rooted at p having depth d
	public static<E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
		System.out.println(spaces(2*d) + p.getElement());
		for (Position<E> c : T.children(p))
			printPreorderIndent(T, c, d + 1);
	}
	
//	Prints labeled representation of subtree T rooted at p having depth d
	public static<E> void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
		int d = path.size();
		System.out.println(spaces(2*d));
		for(int j = 0; j < d; j++) System.out.println(path.get(j) + (j == d - 1 ? " ": "."));
		System.out.println(p.getElement());
		path.add(1);
		for(Position<E> c: T.children(p)) {
			printPreorderLabeled(T, c, path);
			path.set(d, 1 + path.get(d));
		}
		path.remove(d);
	}
	
//	creates a string with d number of empty spaces
	public static String spaces(int d) {
		StringBuilder s = new StringBuilder(d);
		for(int i = 0; i < d; i++) s.append(" ");
		return s.toString();
	}
	
//	prints parenthesized representation of subtree of T rooted at p
	public static<E> void parenthesize(Tree<E> T, Position<E> p) {
		System.out.println(p.getElement());
		if (T.isInternal(p)) {
			boolean firstTime = true;
			for(Position<E> c : T.children(p)) {
				System.out.println((firstTime ? " (" : ", "));
				firstTime = false;
				parenthesize(T, c);
			}
			System.out.println(")");
		}
	}
	
//	computes coordinates at which to draw positions of a binary tree
//	public static<E> int layout(BinaryTree<E> T, Position<E> p, int d, int x) {
//		if (T.left(p) != null)
//			x = layout(T, T.left(p), d + 1, x);
//		p.getElement().setX(x++);  // assume setX is defined
//		p.getElement().setY(d);    // assume setY is defined 
//		if (T.right(p) != null)
//			x = layout(T, T.right(p), d + 1, x);
//		return x;
//	}
	
//	returns total disk space for subtree of T rooted at p
	public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
		int subtotal = p.getElement();   // Assume element represents space usage
		for(Position<Integer> c : T.children(p))
			subtotal += diskSpace(T, c);
		return subtotal;
	}
}
