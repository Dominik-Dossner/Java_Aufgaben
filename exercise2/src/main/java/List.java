public class List extends AbstractContainer {
    protected ListElement head;
    protected int size;

    public List() {
        head = null;
    }

    @Override
    public boolean add(Object ojc) {
        ListElement newElement = new ListElement(ojc);
        newElement.next = head;
        head = newElement;
        size++;
        return true;
    }

    @Override
    public Object get(int i) {
        if(i < 0 || i >= this.size) {
            return null;
        }
        if (i == 0) {
            return head.data;
        }

        ListElement current = head;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.data;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) return false;
        
        if ((o == null && head.data == null) || (o != null && o.equals(head.data))) {
            head = head.next;
            size--;
            return true;
        }

        for (ListElement current = head; current.next != null; current = current.next) {
            if ((o == null && current.next.data == null) || 
                (o != null && o.equals(current.next.data))) {
                current.next = current.next.next;
                size--;
                return true;
            }
        }
        
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (head == null) {
            result.append("[Dulli] Die Liste ist leer.");
        }
        ListElement current = head;
        while (current != null) {
            result.append(current.toString());
            current = current.next;
        }

        return result.toString();
    }
}

class ListElement {
    Object data;
    ListElement next;

    public ListElement(Object data) {
        this.data = data;
        next = null;
    }
}
