package file;
/* Introduction to Computing II (ITI 1121)
 * Introduction a l'informatique II (ITI 1521)
 */

/**
 * Queue Abstract Data Type. A Queue is a linear data structure
 * following first-in-first-out protocol, i.e. the first element that
 * has been added to the Queue, is the first one to be removed.
 *
 * @author Marcel Turcotte
 * @param <E> the type of elements in this queue
 */

public interface Queue<E> {

	/**
	 * Tests if this Queue is empty.
	 *
	 * @return true if this Queue is empty; and false otherwise.
	 */

	public abstract boolean isEmpty();

	/**
	 * Removes and returns the front element of the Queue.
	 *
	 * @return the front element of the Queue.
	 */

	public abstract E dequeue();

	/**
	 * Puts an element at the rear of this Queue.
	 *
	 * @param element the element be put at the rear of this Queue.
	 */

	public abstract void enqueue( E element );

}
