public class Test {
    
    public static void main(String[] args) {

        SinglyLinkedList<String> l;
        l = new SinglyLinkedList<String>();
        
        l.addFirst("A");
        l.addFirst("D");
        l.addFirst("C");
        l.addFirst("A");
        l.addFirst("A");
        l.addFirst("B");
        l.addFirst("A");

        System.out.println(l);
        System.out.println(l.indexOfAll("A"));
       
        // Expected result
        // {A,B,A,A,C,D,A}
        // {0,2,3,6}
    }
    
}
