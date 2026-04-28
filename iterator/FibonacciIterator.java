import java.util.Iterator;
import java.util.NoSuchElementException;
public class FibonacciIterator implements Iterator<Integer> {

    private int prev = 1;
    private int current = 1;
    private int count = 0;
    private final int limit;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit; //return true for unlimitted
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int result;

        if (count == 0 || count == 1) {
            result = 1;
        } else {
            result = prev + current;
            prev = current;
            current = result;
        }

        count++;
        return result;
    }
}