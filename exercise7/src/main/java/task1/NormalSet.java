package task1;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class NormalSet<E> extends AbstractSet<E> {
    @Override
    public boolean add(E obj) {
        if(obj == null || test(obj)) {
            return false;
        }

        if(head == null) {
            head = new ListElement<>(obj);
        } else {
            ListElement zeiger = head;
            while(zeiger.next != null) {
                zeiger = zeiger.next;
            }
            zeiger.next = new ListElement<>(obj);
        }
        return true;
    }

}
