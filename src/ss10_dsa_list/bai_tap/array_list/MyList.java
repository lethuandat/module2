package ss10_dsa_list.bai_tap.array_list;

public class MyList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapacity(elements.length);
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size -= 1;
        }
        return (E) elements;
    }

    public E clone() {
        MyList<E> clone = new MyList<>(elements.length);
        for (Object x : elements) {
            clone.add((E) x);
        }
        return (E) clone;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapacity(size);
            elements[size++] = o;
            return true;
        }
        return false;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= elements.length) {
            Object[] newElements = new Object[minCapacity * 2 + 1];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public E get(int i) {
        if (i >= 0 && i < size) {
            return (E) elements[i];
        }
        return null;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
