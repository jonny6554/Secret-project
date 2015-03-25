/* ITI 1121/1521. Introduction to Computer Science II
 *
 * Marcel Turcotte
 */

public interface Queue<E> {

    /** 
     * Returns true if this Queue has no elements.
     *
     * @return true if this Queue has no elements.
     */

    public abstract boolean isEmpty();

    /**
     * Returns a reference to the front element; does not change
     * the state of this Queue.
     *
     * @return The front element of this queue without removing it.
     */

    public abstract E peek() throws EmptyQueueException;

    /**
     * Add an element at the rear of this Queue.
     *
     * @throws FullQueueException if this queue is full.
     */

    public abstract void enqueue( E o );

    /**
     * Remove and returns the front element of this Queue.
     * @return the front element of this Queue.
     */

    public abstract E dequeue() throws EmptyQueueException;
}
