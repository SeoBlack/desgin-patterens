import java.util.Iterator;

public class FibonacciSequence implements Sequence {

    private final int limit; // number of elements to generate

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}