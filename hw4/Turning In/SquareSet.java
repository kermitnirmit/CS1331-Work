import java.util.Set;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.Iterator;
/**
 * Manipulates sets pf squares. It overrrides the methods in Set.
 *
 * @author nshah372
 * @version 1.0
 */
public class SquareSet implements Set<Square> {
    private Square[] elements;
    private int lastIndex;
    /**
     * Basic No Args constructor
     */
    public SquareSet() {
        this.elements = new Square[0];
    }
    /**
     * Takes in a Collection of Squares
     * @param  c             [Collection of Squares]
     */
    public SquareSet(Collection<Square> c) {
        this.elements = new Square[0];
        lastIndex = -1;
        addAll(c);
    }
    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i].hashCode();
        }
        return sum;
    }
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (null == other) {
            return false;
        }
        if (!(other instanceof Set)) {
            return false;
        }
        Set set = (Set) other;
        return this.hashCode() == set.hashCode();
    }
    @Override
    public boolean contains(Object other) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(other)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<Square> iterator() {
        Iterator<Square> iter = new Iterator<Square>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public Square next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iter;
    }
    /**
     * Checks if a square is valid
     * @param  s             [the square that you are adding]
     * @return        [true if the square is valid, false otherwise.]
     */
    public boolean validSquare(Square s) {
        if (s.getFile() > 'h' || s.getFile() < 'a') {
            return false;
        }
        if (s.getRank() < '1' || s.getRank() > '8') {
            return false;
        }
        return true;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object s : c) {
            if (!contains(s)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends Square> c) {
        if (!containsAll(c)) {
            for (Square s : c) {
                add(s);
            }
            return true;
        } else {
            return false;
        }
    }
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < elements.length) {
            T[] newArr = (T[]) new Object[elements.length];
            for (int i = 0; i < elements.length; i++) {
                newArr[i] = (T) elements[i];
            }
            return newArr;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (i < elements.length) {
                    a[i] = (T) elements[i];
                } else {
                    a[i] = null;
                }
            }
            return a;
        }
    }
    @Override
    public boolean remove(Object that) {
        int location = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(that)) {
                location = i;
                i = elements.length;
            }
        }
        if (location != -1) {
            Square[] newArr = new Square[elements.length - 1];
            for (int i = location; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
                newArr[i] = elements[i];
            }
            elements = newArr;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean add(Square item) throws NullPointerException {
        if (!validSquare(item)) {
            throw new InvalidSquareException("Invalid Square");
        }
        if (item == null) {
            throw new NullPointerException();
        }
        if (contains(item)) {
            return false;
        } else {
            Square[] array1 = new Square[elements.length + 1];
            for (int i = 0; i < elements.length; i++) {
                array1[i] = elements[i];
            }
            array1[elements.length] = item;
            elements = array1;
            return true;
        }
    }

    @Override
    public Object[] toArray() {
        return elements;
    }
    @Override
    public void clear() {

    }
    @Override
    public int size() {
        return elements.length;
    }
}
