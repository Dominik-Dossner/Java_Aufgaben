package task1;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class OrderedSet<E extends Comparable<E>> extends AbstractSet<E> {

    @Override
    public boolean add(E obj) {
        if (obj == null || test(obj)) {
            return false;
        }

        if (head == null) {
            head = new ListElement<>(obj);
            return true;
        }
        //Neues Objekt kleiner als head
        if (obj.compareTo(head.data) < 0) {
            ListElement<E> newObject = new ListElement<>(obj);
            newObject.next = head;
            head = newObject;
            return true;
        }
        //Sucht richtige Position
        ListElement<E> current = head;
        while (current.next != null && obj.compareTo(current.next.data) > 0) {
            current = current.next;
        }

        ListElement<E> newObject = new ListElement<>(obj);
        newObject.next = current.next;
        current.next = newObject;
        return true;
    }
}
