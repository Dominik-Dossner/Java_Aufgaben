package task1;

import java.util.Enumeration;

public interface Set<E> {
    boolean add(E obj);
    boolean test(E obj);
    boolean remove(E obj);
    Enumeration<E> elements();
}
