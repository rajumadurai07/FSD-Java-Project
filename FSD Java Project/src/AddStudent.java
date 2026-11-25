
import java.util.Scanner;

public class AddStudent {

    public void add(Scanner sc, StudentService service) {

        System.out.print("Enter ID: ");

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            sc.nextLine();
            System.out.print("Enter ID: ");
        }

        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("Student ID must be positive!");
            return;
        }

        if (service.findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Age: ");

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid age!");
            sc.nextLine();
            System.out.print("Enter Age: ");
        }

        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty() ||
                age <= 0 || name.contains(",") || course.contains(",")) {

            System.out.println("Please enter valid details!");
            return;
        }

        Student student = new Student(id, name, age, course);

        service.addStudent(student);
        service.saveStudents();

        System.out.println("Student added successfully!");
    }
}
