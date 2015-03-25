import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Tuple> l;
        l = new LinkedList<Tuple>();

        l.add(new Tuple('a'));
        l.add(new Tuple('b'));
        l.add(new Tuple('a'));
        l.add(new Tuple('c'));
        l.add(new Tuple('b'));
        l.add(new Tuple('a'));
        l.add(new Tuple('c'));
        l.add(new Tuple('a'));
        l.add(new Tuple('d'));
        l.add(new Tuple('d'));
        l.add(new Tuple('b'));

        Frequency.frequency(l);

    }
}
