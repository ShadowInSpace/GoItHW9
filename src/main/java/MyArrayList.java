//import java.util.AbstractList;

import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;

public class MyArrayList<E> {
    private Object storage[];
    private int size;

    public MyArrayList() {
        this(10);

    }

    public MyArrayList(int initialCapacity) {

        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);

        storage = new Object[initialCapacity];
        size = 0;
    }

    public MyArrayList(Object[] o) {
        storage = new Object[o.length];
        size = o.length;
        if (storage.getClass() != Object[].class) {
            storage = Arrays.copyOf(storage, size, Object[].class);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = storage.length;
        int newCapacity = oldCapacity * 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = MAX_ARRAY_SIZE;
        }
        storage = Arrays.copyOf(storage, newCapacity);
    }


    public void add(Object value) {
        if (storage.length < size + 1) {
            grow(size + 1);
        }
        storage[size++] = value;
    }

    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        storage[--size] = null;
    }

    public void clear() {
        storage = new Object[10];
        size = 0;
    }

    public Object get(int index) {
        return storage[index];
    }

    public int size() {
        return size;
    }
}
