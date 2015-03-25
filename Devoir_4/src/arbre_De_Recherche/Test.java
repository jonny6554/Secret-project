public class Test {
    
    public static void main(String[] args) {
        
        // Given a binary search tree, t, containing the values 1, 2, 3, 4, 5, 6, 7, 8, the call t.count(3,6) returns the value 4.
        
        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<Integer>();
        
        t.add(4);
        t.add(2);
        t.add(6);
        t.add(1);
        t.add(3);
        t.add(5);
        t.add(8);
        t.add(7);
        
        System.out.println(t);
        System.out.println(t.count(3,6));
        
        // Expected result:
        // (((null,1,null),2,(null,3,null)),4,((null,5,null),6,((null,7,null),8,null)))
        // 4
        
    }
    
}
