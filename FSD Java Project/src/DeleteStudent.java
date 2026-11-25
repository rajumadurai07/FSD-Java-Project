
import java.util.Scanner;

public class DeleteStudent {

    public void delete(Scanner sc, StudentService service) {

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

        service.removeStudent(s);
        service.saveStudents();

        System.out.println("Student deleted successfully!");
    }
}
