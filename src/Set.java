import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Huy
 */
public class Set<T> implements Iterable<T> {
    T[] values;

    public Set(T[] values) {
        this.values = values;
    }

    public void add(T element) {
        // TODO
    }

    public void remove() {
        // TODO
    }

    public T get(int index) {
        return values[index];
    }

    public void set(int index, T value) {
        values[index] = value;
    }

    public int length() {
        return values.length;
    }

    public Iterator<T> iterator() {
        return new SetIterator();
    }

    private class SetIterator implements Iterator<T> {
        int current = 0;

        public boolean hasNext() {
            if (current < Set.this.values.length) {
                return true;
            } else {
                return false;
            }
        }

        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return values[current++];
        }
    }

    @Override
    public String toString() {
        SetIterator a = new SetIterator();
        String toStr = "Set:{";
        while (a.hasNext()){
            toStr = toStr + "\"" + a.next() + "\"";
            if(a.hasNext()){
                toStr = toStr + ",";
            }
        }
        return toStr + "}";
    }
}