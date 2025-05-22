package de.tha.prog2.blatt5.task3.annotations;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class BugLister {
    private List<BugInfo> bugs = new LinkedList<>();

    public List<BugInfo> getBugInfos(Class<?> clazz) {
        bugs.clear();

        // Hauptklasse - enthält Annotation @Bug
        if (clazz.isAnnotationPresent(Bug.class)) {
            Bug bug = clazz.getAnnotation(Bug.class);
            bugs.add(new BugInfo(clazz, null, null, bug.type(), bug.description()));
        }

        // Methoden Hauptklasse
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Bug.class)) {
                Bug bug = method.getAnnotation(Bug.class);
                bugs.add(new BugInfo(clazz, null, method, bug.type(), bug.description()));
            }
        }

        // Innere Klassen
        for (Class<?> innerClass : clazz.getDeclaredClasses()) {
            // Innere Klasse selbst
            if (innerClass.isAnnotationPresent(Bug.class)) {
                Bug bug = innerClass.getAnnotation(Bug.class);
                bugs.add(new BugInfo(innerClass, clazz, null, bug.type(), bug.description()));
            }

            // Methoden der inneren Klasse
            for (Method method : innerClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Bug.class)) {
                    Bug bug = method.getAnnotation(Bug.class);
                    bugs.add(new BugInfo(innerClass, clazz, method, bug.type(), bug.description()));
                }
            }

            // Innere Klassen innerhalb innere Klassen
            for (Class<?> innerInnerClass : innerClass.getDeclaredClasses()) {
                if (innerInnerClass.isAnnotationPresent(Bug.class)) {
                    Bug bug = innerInnerClass.getAnnotation(Bug.class);
                    bugs.add(new BugInfo(innerInnerClass, innerClass, null, bug.type(), bug.description()));
                }
            }
        }

        return bugs;
    }

    @Override
    public String toString() {
        String result = "";
        for (BugInfo bug : bugs) {
            result += bug.toString() + "\n";
        }

        return result;
    }
}
