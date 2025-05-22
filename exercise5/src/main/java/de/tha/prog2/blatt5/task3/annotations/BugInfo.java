package de.tha.prog2.blatt5.task3.annotations;
import java.lang.reflect.Method;

public class BugInfo {
    private Class<?> clazz;
    private Class<?> outer;
    private Method method;
    private Bug.Type type;
    private String description;

    public BugInfo(Class<?> clazz, Class<?> outer, Method method, Bug.Type type, String description) {
        this.clazz = clazz;
        this.outer = outer;
        this.method = method;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        // /t ist ein Tabulatorzeichen
        return (clazz == null ? "null" : clazz.getName()) + "\t" +
                (outer == null ? "null" : outer.getName()) + "\t" +
                (method == null ? "null" : method.toString()) + "\t" +
                type.toString() + "\t" +
                description;
    }
}
