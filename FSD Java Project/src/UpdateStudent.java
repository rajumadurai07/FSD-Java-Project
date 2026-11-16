import java.util.Scanner;

public class UpdateStudent {
    public void update(Scanner sc, StudentService service) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = service.findStudent(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        if (name.trim().isEmpty() || course.trim().isEmpty() || age <= 0
                || name.contains(",") || course.contains(",")) {
            System.out.println("Please enter valid details!");
            return;
        }

        s.name = name;
        s.age = age;
        s.course = course;
        service.saveStudents();
        System.out.println("Student updated successfully!");
    }
}
