import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Huy
 */
public class Set<T> implements Iterable<T> {
    /**
     *  @effects
     *      initialise values = T[]
     */
    T[] values;

    /**
     * @effects
     *      set values = elements
     */
    public Set(T[] elements) {
        this.values = elements;
    }

    /**
     *
     * @param element
     */
    public void add(T element) {

    }

    /**
     *
     */
    public void remove() {

    }

    /**
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return values[index];
    }

    /**
     *
     * @param index
     * @param value
     */
    public void set(int index, T value) {
        values[index] = value;
    }

    /**
     *
     * @return
     */
    public int length() {
        return values.length;
    }

    /**
     *
     * @return
     */
    public Iterator<T> iterator() {
        return new SetIterator();
    }

    /**
     *
     */
    private class SetIterator implements Iterator<T> {
        int current = 0;

        /**
         *
         * @return
         */
        public boolean hasNext() {
            return current < Set.this.values.length;
        }

        /**
         *
         * @return
         * @throws NoSuchElementException
         */
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return values[current++];
        }
    }

    /**
     *
     * @return
     */
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