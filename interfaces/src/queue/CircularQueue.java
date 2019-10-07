package queue;

public interface CircularQueue<E> extends Queue<E> {

	// rotates the front element of the queue to the back of the queue
	// does nothing if the queue is empty
	void rotate();
}
