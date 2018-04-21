import java.util.Vector;

/**
 * @overview Set are mutable, unbounded sets of Strings.
 *
 * @attributes
 *   elements   Set<String>  Vector<String>
 *
 * @object A typical Set object is c={x1,...,xn}, where x1,...,xn are
 *   elements.
 *
 * @abstract_properties
 *  optional(elements) = false /\
 *  for each element in elements. element is String
 *
 * @author huynq
 */
public class Set {
    @DomainConstraint(type = "Vector", optional = false)
    private Vector elements;

    /**
     * @effects initialise <tt>this</tt> to be empty
     */
    public Set(){
        elements = new Vector();
    }

    /**
     * @modifies <tt>this</tt>
     * @effects
     *      if element is already in this
     *          do nothing
     *      else
     *          add element to this
     */
    public void add(String element){
        if (getIndex(element) < 0)
            elements.add(element);
    }

    /**
     * @modifies <tt>this</tt>
     * @effects
     *      if element is not in this
     *          do nothing
     *      else
     *          remove element from this
     */
    public void remove(String element) {
        int index = getIndex(element);
        if (index < 0)
            return;
        elements.set(index, elements.lastElement());
        elements.remove(elements.size() - 1);
    }


    /**
     * @effects <pre>
     *  if this contains element
     *    return true
     *  else
     *    return false
     */
    public boolean contains(String element) {
        return elements.contains(element);
    }


    /**
     * @effects return the size of set.
     */
    public int size(){
        return elements.size();
    }

    /**
     * @effects
     *  if this
     *    return the trying where element appears
     *  else
     *    return -1
     */
    private int getIndex(String element) {
        for (int i = 0; i < elements.size(); i++) {
            if (element.equals(elements.get(i)))
                return i;
        }

        return -1;
    }

    /**
     * @effects
     *      if element size is 0
     *          return true
     *      else
     *          return false
     */
    public boolean isEmpty(){
        if(elements.size() == 0)
            return true;
        else
            return false;
    }

    /**
     * @effects
     *      if this is empty
     *          return Set{ }
     *      else
     *          return Set{a, b, c, ...}
     */
    @Override
    public String toString() {
        if (this.isEmpty())
            return "[No component is defined.]";

        String s = "[\"" + elements.elementAt(0).toString();
        for (int i = 1; i < size(); i++) {
            s = s + "\" , \"" + elements.elementAt(i).toString();
        }

        return s + "\"]";
    }
}