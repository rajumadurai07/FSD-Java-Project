import java.util.Scanner;

public class DeleteStudent {
    public void delete(Scanner sc, StudentService service) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = service.findStudent(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        service.students.remove(s);
        service.saveStudents();
        System.out.println("Student deleted successfully!");
    }
}
