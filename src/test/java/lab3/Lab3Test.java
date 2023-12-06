package lab3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
public class Lab3Test {
    @Test
    public void testPersonBuilderValid() {
        Person person = new Person.PersonBuilder()
                .setFirstName("John")
                .setSecondName("Doe")
                .setAge(25)
                .setVehicle(new Vehicle("Car", "Red", 123456, "Toyota"))
                .build();

        assertEquals(person.getFirstName(), "John");
        assertEquals(person.getSecondName(), "Doe");
        assertEquals(person.getAge(), 25);
        assertEquals(person.getVehicle().getModel(), "Toyota");
    }

    @Test
    public void testPersonEqualsAndHashCode() {
        Person person1 = new Person.PersonBuilder()
                .setFirstName("John")
                .setSecondName("Doe")
                .setAge(25)
                .setVehicle(new Vehicle("Car", "Red", 123456, "Toyota"))
                .build();

        Person person2 = new Person.PersonBuilder()
                .setFirstName("John")
                .setSecondName("Doe")
                .setAge(25)
                .setVehicle(new Vehicle("Car", "Red", 123456, "Toyota"))
                .build();

        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void testPersonServiceNoStream() {
        List<Person> personList = Arrays.asList(
                new Person("John", "Doe", 25, new Vehicle("Car", "Red", 123456, "Toyota")),
                new Person("Jane", "Smith", 30, new Vehicle("Motorcycle", "Black", 789012, "Harley"))
        );

        PersonServiceNoStream personService = new PersonServiceNoStream(personList);

        List<Person> personsByFirstName = personService.getPersonsByFirstName("John");
        assertEquals(personsByFirstName.size(), 1);

        List<Person> personsBySecondName = personService.getPersonsBySecondName("Doe");
        assertEquals(personsBySecondName.size(), 1);
    }

    @Test
    public void testPersonServiceStream() {
        List<Person> personList = Arrays.asList(
                new Person("John", "Doe", 25, new Vehicle("Car", "Red", 123456, "Toyota")),
                new Person("Jane", "Smith", 30, new Vehicle("Motorcycle", "Black", 789012, "Harley"))
        );

        PersonServiceStream personService = new PersonServiceStream(personList);

        List<Person> personsByFirstName = personService.getPersonsByFirstName("John");
        assertEquals(personsByFirstName.size(), 1);

        List<Person> personsBySecondName = personService.getPersonsBySecondName("Doe");
        assertEquals(personsBySecondName.size(), 1);
    }

}

