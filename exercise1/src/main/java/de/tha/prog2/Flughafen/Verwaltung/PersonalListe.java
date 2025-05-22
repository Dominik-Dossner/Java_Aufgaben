package de.tha.prog2.Flughafen.Verwaltung;

import de.tha.prog2.Flughafen.Personal.Personal;
import de.tha.prog2.Flughafen.Personal.Pilot;

public class PersonalListe {
    private ListElement head;

    public void hinzufuegen(Personal personal) {
        if (head == null) {
            head = new ListElement(personal);
        } else {
            ListElement current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new ListElement(personal);
        }
    }

    public void entfernen(int persNr) {
        if(head == null) {return;}
        if(head.data.getPersNr() == persNr) {
            head = head.next;
        } else {
            ListElement current = head;
            while (current.next != null) {
                if (current.next.data.getPersNr() == persNr) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    }

    public void listPilots() {
        System.out.println("Die Liste von Piloten");

        ListElement current = head;
        while (current != null) {
            if(current.data instanceof Pilot) {
                System.out.println(current.data.toString());
            }
            current = current.next;
        }
    }

    public String toString() {
        if (head == null) {
            return "Liste ist leer";
        }

        StringBuilder sb = new StringBuilder();
        ListElement current = head;
        while (current != null) {
            sb.append(current.data.toString()).append("\n");
            current = current.next;
        }

        return sb.toString();
    }
}

class ListElement {
    public ListElement next;
    public Personal data;

    public ListElement(Personal data) {
        this.data = data;
        next = null;
    }
}
