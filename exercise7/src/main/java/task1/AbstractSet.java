package task1;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public abstract class AbstractSet<E> implements Set<E> {
    static class ListElement<E> {
        E data;
        protected ListElement<E> next = null;

        public ListElement(E data) {
            this.data = data;
        }
    }
    protected ListElement<E> head = null;


    @Override
    public boolean test(E obj) {
        if(obj == null) {
            return false;
        }
        ListElement<E> zeiger = head;
        while(zeiger != null) {
            if(zeiger.data.equals(obj)) {
                return true;
            }
            zeiger = zeiger.next;
        }
        return false;
    }

    @Override
    public boolean remove(E obj) {
        if (head.data.equals(obj)) {
            head = head.next;
            return true;
        } else {
            ListElement zeiger = head;
            while(zeiger.next != null) {
                if(obj.equals(zeiger.next.data)) {
                    zeiger.next = zeiger.next.next;
                    return true;
                }
                zeiger = zeiger.next;
            }
        }
        return false;
    }

    @Override
    public Enumeration<E> elements() {
        return new Enumeration<E>() {
            private ListElement<E> current = head;

            @Override
            public boolean hasMoreElements() {
                return current != null;
            }

            @Override
            public E nextElement() {
                if(current == null) {
                    throw new NoSuchElementException("No more elements");
                }
                E daten = current.data;
                current = current.next;
                return daten;
            }
        };
    }
}
