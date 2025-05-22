package de.tha.blatt3;

import de.tha.blatt2.DoubleLinkedList;
import de.tha.blatt3.animal.Animal;
import de.tha.blatt3.animal.Carnivore;
import de.tha.blatt3.animal.Herbivore;
import de.tha.blatt3.animal.Omnivore;
import de.tha.blatt3.exceptions.HabitatFullException;
import de.tha.blatt3.exceptions.InvalidAnimalException;

public class ZooHabitat {
    protected int maxCapacity;
    protected DoubleLinkedList animals;

    public ZooHabitat(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.animals = new DoubleLinkedList();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int animals() {
        String type = "Tiere";

        if (animals.size() > 0) {
            Animal firstAnimal = (Animal) animals.get(0);
            if (firstAnimal instanceof Herbivore) type = "Pflanzenfresser";
            else if (firstAnimal instanceof Carnivore) type = "Fleischfresser";
            else if (firstAnimal instanceof Omnivore) type = "Allesfresser";
        }

        System.out.println("Im Habitat leben folgende " + type + ":");

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = (Animal) animals.get(i);
            System.out.println("- " + animal.toString());
        }

        return animals.size();
    }

    public void addAnimal(Animal animal) throws HabitatFullException, InvalidAnimalException {
        // Check if the animal is already in the habitat
        if (animals.contains(animal)) {
            return;
        }

        // Check if habitat is full
        if (animals.size() >= maxCapacity) {
            throw new HabitatFullException("Das Gehege ist voll.");
        }

        // Check if the animal type is compatible with existing animals
        if (animals.size() > 0) {
            Animal firstAnimal = (Animal) animals.get(0);

            // Determine the type of the first animal
            Class<?> firstAnimalType =
                    firstAnimal instanceof Herbivore ? Herbivore.class :
                            firstAnimal instanceof Carnivore ? Carnivore.class :
                                    firstAnimal instanceof Omnivore ? Omnivore.class : null;

            // Determine the type of the new animal
            Class<?> newAnimalType =
                    animal instanceof Herbivore ? Herbivore.class :
                            animal instanceof Carnivore ? Carnivore.class :
                                    animal instanceof Omnivore ? Omnivore.class : null;

            // Throw InvalidAnimalException if types are different
            if (firstAnimalType != newAnimalType) {
                throw new InvalidAnimalException("Dieses Tier kann nicht mit den vorhandenen Tieren zusammenleben.");
            }
        }

        // Add the animal to the habitat
        animals.add(animal);
    }
}