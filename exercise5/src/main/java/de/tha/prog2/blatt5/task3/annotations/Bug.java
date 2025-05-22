package de.tha.prog2.blatt5.task3.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// Klasse - Methode - Konstruktor
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface Bug {
    String description();
    Type type();

    enum Type {
        INVALID, ENHANCEMENT, MINOR, SEVERE, CRITICAL
    }
}