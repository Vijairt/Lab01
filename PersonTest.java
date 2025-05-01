import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe", "123", "Mr.", 1990);
    }

    @Test
    void testConstructor() {
        assertEquals("John", person.fullName().split(" ")[0]);
        assertEquals("Doe", person.fullName().split(" ")[1]);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    void testSetFirstName() {
        person.setFirstName("Jane");
        assertEquals("Jane Doe", person.fullName());
    }

    @Test
    void testSetLastName() {
        person.setLastName("Smith");
        assertEquals("John Smith", person.fullName());
    }

    @Test
    void testSetTitle() {
        person.setTitle("Dr.");
        assertEquals("Dr. John Doe", person.formalName());
    }

    @Test
    void testSetYOB() {
        person.setYOB(2000);
        assertEquals("2000", person.getAge(2025)); // 2025 - 2000 = 25
    }

    @Test
    void testEquals() {
        Person same = new Person("Jack", "Black", "123", "Mr.", 1990);
        assertEquals(person, same);
    }

    @Test
    void testToCSV() {
        assertEquals("John,Doe,123,Mr.,1990", person.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"123\",\"title\":\"Mr.\",\"YOB\":1990}";
        assertEquals(expected, person.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Person><firstName>John</firstName><lastName>Doe</lastName><ID>123</ID><title>Mr.</title><YOB>1990</YOB></Person>";
        assertEquals(expected, person.toXML());
    }
}
