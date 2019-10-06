package stack;

public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> linkList = new SinglyLinkedList<E>();
	
	public LinkedStack() {};
	
	public int size() {
		return linkList.size();
	}
	
	public boolean isEmpty() {
		return linkList.isEmpty();
	}
	
	public void push(E e) {
		linkList.addFirst(e);
	}
	
	public E top() {
		return linkList.first();
	}
	
	public E pop() {
		return linkList.removeFirst();
	}
}
