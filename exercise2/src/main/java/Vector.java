public class Vector extends AbstractContainer {
    private Object[] elements;
    private int size;

    public Vector() {
        elements = new Object[10];
        size = 0;
    }

    public boolean add(Object o) {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length + 1];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size] = o;
        size++;
        return true;
    }

    public Object get(int i) {
        return elements[i];
    }

    public int size() {
        return size;
    }

    public boolean remove(Object o) {
        for (int a = 0; a < size; a++) {
            for (int b = a; b < size() - 1; b++) {
                elements[b] = elements[b + 1];
            }
            size--;
            elements[size] = null;
            return true;
        }

        return false;
    }
}