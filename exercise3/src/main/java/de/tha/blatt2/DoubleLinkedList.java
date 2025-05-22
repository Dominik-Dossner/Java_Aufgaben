package de.tha.blatt2;

public class DoubleLinkedList extends AbstractContainer {
    private ListElement head;
    private ListElement tail;
    int size;

    public DoubleLinkedList() {
        this.head = null;
    }

    public boolean add(Object o) {
        if (head == null) {
            head = new ListElement(o);
            tail = head;
        } else {
            head.prev = new ListElement(o);
            head.prev.next = head;
            head = head.prev;
        }

        size++;
        return true;
    }

    public Object get(int i) {
        if (i > size || i < 0) throw new IndexOutOfBoundsException();

        int index = 0;
        ListElement current = head;

        while (current != null) {
            if (index == i) {
                return current.data;
            }
            index++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }


    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        ListElement current = head;
        for (int i = 0; i < size; i++) {
            if ((o == null && current.data == null) ||
                    (o != null && o.equals(current.data))) {

                // Spezialfall: Einziges Element in der Liste
                if (head == tail) {
                    head = null;
                    tail = null;
                }
                // Erstes Element entfernen
                else if (current == head) {
                    head = head.next;
                    head.prev = null;
                }
                // Letztes Element entfernen
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // Element in der Mitte entfernen
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                size--;
                return true; // Element gefunden und entfernt
            }

            // Zum nächsten Element gehen
            current = current.next;

            // Wenn wir am Ende der Liste sind, aber das Element nicht gefunden haben
            if (current == null) {
                break;
            }
        }

        return false; // Element nicht gefunden
    }

    public int size() {
        return size;
    }

    public String toString() {
        return "Ausgabe";
    }
}

class ListElement {
    Object data;
    ListElement next;
    ListElement prev;

    public ListElement(Object data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
