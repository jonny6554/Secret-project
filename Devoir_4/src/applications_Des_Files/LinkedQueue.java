/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<E> {

        private E value;
        private Elem<E> next;

        private Elem( E value, Elem<E> next ) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public LinkedQueue() {
        front = rear = null;
    }

    public E peek() {

        // pre-conditions:

        if ( front == null ) {
            throw new EmptyQueueException();
        }

	return front.value;
    }

    public void enqueue( E o ) {

        // pre-conditions:

        if ( o == null ) {
            throw new IllegalArgumentException( "null" );
        }

        Elem<E> newElem;
        newElem = new Elem<E>( o, null );

        if ( rear == null ) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = rear.next;
        }

    }

    public E dequeue() {

        // pre-conditions:

        if ( front == null ) {
            throw new EmptyQueueException();
        }

        E result = front.value;

        if ( front == rear ) {
            front = rear = null;
        } else {
            front = front.next;
        }

        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }

}
