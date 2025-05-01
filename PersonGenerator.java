import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        boolean done = false;

        System.out.println("Welcome to Person Data Entry");

        do {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (e.g. Mr., Ms., Dr.)");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1940, 2010);

            // 🔁 Create Person object and add to list
            Person person = new Person(firstName, lastName, id, title, yearOfBirth);
            people.add(person);

            done = !SafeInput.getYNConfirm(in, "Do you want to enter another person?");
        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save (e.g. PersonTestData.csv)");

        // 🔁 Write using toCSV from Person object
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Person p : people) {
                writer.println(p.toCSV());
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
