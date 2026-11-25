
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Find Student
    public Student findStudent(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Get Students
    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    // Remove Student
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Save Students
    public void saveStudents() {

        try (PrintWriter pw = new PrintWriter("students.txt")) {

            for (Student s : students) {
                pw.println(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse()
                );
            }

            System.out.println("Students saved successfully!");

        } catch (IOException e) {
            System.out.println("File save error: " + e.getMessage());
        }
    }

    // Load Students
    public void loadStudents() {

        File f = new File("students.txt");

        if (!f.exists()) {
            return;
        }

        students.clear();

        try (Scanner file = new Scanner(f)) {

            while (file.hasNextLine()) {

                String[] data = file.nextLine().split(",", -1);

                if (data.length == 4) {

                    try {
                        int id = Integer.parseInt(data[0].trim());
                        String name = data[1].trim();
                        int age = Integer.parseInt(data[2].trim());
                        String course = data[3].trim();

                        if (id > 0 && age > 0 &&
                                !name.isEmpty() && !course.isEmpty()) {

                            students.add(
                                    new Student(id, name, age, course)
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid record skipped!");
                    }

                } else {
                    System.out.println("Invalid record skipped!");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Student file not found!");
        }
    }
}
