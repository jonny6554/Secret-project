package file;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        
        CircularQueue<Integer> q;
        q = new CircularQueue<Integer>(8);
        
        for (int i = 0; i < 6; i++) {
            q.enqueue(i);
        }
        
        while (! q.isEmpty()) {
            q.dequeue();
        }

        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }

        List<Integer> l;
        l = q.dequeue(3);

        System.out.print("[");
        for (int i = 0; i < l.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(l.get(i));
        }
        System.out.println("]");

    }

}
