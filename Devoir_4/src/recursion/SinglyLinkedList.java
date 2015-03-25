/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node( E value, Node<E> next ) {
            this.value = value;
            this.next  = next;
        }
    }

    // Instance variable
    private Node<E> first;

    //  ----------------------------------------------------------
    //  SinglyLinkedList methods
    //  ----------------------------------------------------------

    public void addFirst( E item ) {
        first = new Node<E>( item, first );
    }

    public boolean isEmpty() { 
        return first == null; 
    }

    public SinglyLinkedList<E> indexOfAll( E element ) {

	throw new UnsupportedOperationException( "** replace this statement by your answer to the question **" );

    }

    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------

    @Override
    public String toString() {
        return "{" + toString(first) + "}";
    }

    private String toString(Node<E> p) {

        String result = "";

        if (p != null) {
            result = p.value.toString();
            if (p.next != null) {
                result = result + "," + toString(p.next);
            }
        }

        return result;
    }
}
