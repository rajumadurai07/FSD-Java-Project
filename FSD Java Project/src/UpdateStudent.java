
import java.util.Scanner;

public class UpdateStudent {

    public void update(Scanner sc, StudentService service) {

        System.out.print("Enter Student ID: ");

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid ID!");
            sc.nextLine();
            System.out.print("Enter Student ID: ");
        }

        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("Student ID must be positive!");
            return;
        }

        Student s = service.findStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter New Age: ");

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid age!");
            sc.nextLine();
            System.out.print("Enter New Age: ");
        }

        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty() ||
                age <= 0 || name.contains(",") || course.contains(",")) {

            System.out.println("Please enter valid details!");
            return;
        }

        s.setName(name);
        s.setAge(age);
        s.setCourse(course);

        service.saveStudents();

        System.out.println("Student updated successfully!");
    }
}
