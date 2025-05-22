package de.tha.blatt3;

public class DoubleLinkedList extends AbstractContainer {
    int size;
    ListElement head;
    ListElement tail;

    @Override
    public boolean add(Object o) {
        if(head == null) {
            head = new ListElement(o, null);
            tail = head;
        } else {
            head.prev = new ListElement(o, head);
            head = head.prev;
        }
        size++;
        return true;
    }

    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }
        ListElement current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object o) {
        ListElement current = head;
        for (int i = 0; i < size; i++) {
            if(o.equals(current.data)) {
                if(current == head) {
                    head = head.next;
                    head.prev = null;
                } else if(current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

class ListElement{
    Object data;
    ListElement next;
    ListElement prev = null;

    public ListElement(Object data, ListElement next) {
        this.data = data;
        this.next = next;
    }
}
