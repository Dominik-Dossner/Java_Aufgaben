import de.tha.blatt3.ZooHabitat;
import de.tha.blatt3.animal.*;
import de.tha.blatt3.exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZooHabitatTest {

    static class TestHerbivore implements Herbivore {
        @Override
        public void eatPlant() {}
        @Override
        public int weight() { return 0; }
        @Override
        public String toString() {
            return "Ein Pflanzenfresser";
        }
    }

    static class TestCarnivore implements Carnivore {
        @Override
        public void eatMeat() {}
        @Override
        public int weight() { return 0; }
        @Override
        public String toString() {
            return "Ein Fleischfresser";
        }
    }

    @Test
    void testZooHabitatSize() throws HabitatFullException, InvalidAnimalException {
        ZooHabitat habitat = new ZooHabitat(10);
        habitat.addAnimal(new TestCarnivore());
        habitat.addAnimal(new TestCarnivore());
        habitat.addAnimal(new TestCarnivore());
        habitat.addAnimal(new TestCarnivore());
        assertEquals(4, habitat.animals());
        assertEquals(10, habitat.getMaxCapacity());
    }

    @Test
    void testZooHabitatSameAnimal() throws HabitatFullException, InvalidAnimalException {
        ZooHabitat habitat = new ZooHabitat(2);
        TestHerbivore herbivore = new TestHerbivore();
        assertDoesNotThrow(() -> {
            habitat.addAnimal(herbivore);
            habitat.addAnimal(herbivore);
        });
        assertEquals(1, habitat.animals());
    }

    @Test
    void testInvalidAnimalExceptionThrown() throws HabitatFullException {
        ZooHabitat habitat = new ZooHabitat(3);
        try {
            habitat.addAnimal(new TestCarnivore());
        } catch (InvalidAnimalException e) {
            throw new RuntimeException(e);
        }

        // Correctly handle the expected exception
        assertThrows(InvalidAnimalException.class, () -> {
            habitat.addAnimal(new TestHerbivore());
        });
    }

    @Test
    void testHabitatFullExceptionThrown() throws InvalidAnimalException {
        ZooHabitat habitat = new ZooHabitat(2);
        assertDoesNotThrow(() -> {
            habitat.addAnimal(new TestCarnivore());
            habitat.addAnimal(new TestCarnivore());
        });
        assertThrows(HabitatFullException.class, () -> habitat.addAnimal(new TestCarnivore()));
    }
}
