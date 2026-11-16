import java.util.Scanner;

public class AddStudent {
    public void add(Scanner sc, StudentService service) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (service.findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        if (name.trim().isEmpty() || course.trim().isEmpty() || age <= 0
                || name.contains(",") || course.contains(",")) {
            System.out.println("Please enter valid details!");
            return;
        }

        service.students.add(new Student(id, name, age, course));
        service.saveStudents();
        System.out.println("Student added successfully!");
    }
}
