public class List {

    // Points to the first node in this list
    private Node first;

    // The number of elements in this list
    private int size;

    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
        return size;
    }

    /** Returns the first element in the list */
    public CharData getFirst() {
        if (first == null) {
            return null; // return null if the list is empty.
        }
        return first.cp;
    }

    /**
     * Adds a CharData object with the given character to the beginning of this
     * list.
     */
    public void addFirst(char chr) {
        Node newNode = new Node(new CharData(chr));
        newNode.next = first;
        first = newNode;
        size++;
    }

    /** Textual representation of this list. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        sb.append("(");
        while (current != null) {
            sb.append(current.cp.toString());
            current = current.next;
            if (current != null) {
                sb.append(" ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Returns the index of the first CharData object in this list
     * that has the same chr value as the given char,
     * or -1 if there is no such object in this list.
     */
    public int indexOf(char chr) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.cp.getChr() == chr) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * If the given character exists in one of the CharData objects in this list,
     * increments its counter. Otherwise, adds a new CharData object with the
     * given chr to the beginning of this list.
     */
    public void update(char chr) {
        Node current = first;
        while (current != null) {
            if (current.cp.chr == chr) {
                current.cp.count++;
                return;
            }
            current = current.next;
        }
        // If character not found, add it to the beginning
        addFirst(chr);
    }

    /**
     * If the given character exists in one of the CharData objects
     * in this list, removes this CharData object from the list and returns
     * true. Otherwise, returns false.
     */
    public boolean remove(char chr) {
        Node prev = null;
        Node current = first;
        while (current != null) {
            if (current.cp.getChr() == chr) {
                if (prev == null) {
                    first = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the CharData object at the specified index in this list.
     * If the index is negative or is greater than the size of this list,
     * throws an IndexOutOfBoundsException.
     */
    public CharData get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.cp;
    }

    /**
     * Returns an array of CharData objects, containing all the CharData objects in
     * this list.
     */
    public CharData[] toArray() {
        CharData[] arr = new CharData[size];
        Node current = first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.cp;
            current = current.next;
        }
        return arr;
    }

    /**
     * Returns an iterator over the elements in this list, starting at the given
     * index.
     */
    public ListIterator listIterator(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // If the list is empty, there is nothing to iterate
        if (size == 0)
            return null;
        // Gets the element in position index of this list
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // Returns an iterator that starts in that element
        return new ListIterator(current);
    }
    // public static void main(String[] args) {
    // List x = new List();
    // x.addFirst('x');
    // x.addFirst('a');
    // System.out.println(x);

    // }

}
