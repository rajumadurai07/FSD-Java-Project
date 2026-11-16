import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    public void saveStudents() {
        try {
            PrintWriter pw = new PrintWriter("students.txt");
            for (Student s : students) {
                pw.println(s.id + "," + s.name + "," + s.age + "," + s.course);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("File save error!");
        }
    }

    public void loadStudents() {
        try {
            Scanner file = new Scanner(new File("students.txt"));
            while (file.hasNextLine()) {
                String[] data = file.nextLine().split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];
                    students.add(new Student(id, name, age, course));
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            // File is created when the first student record is saved.
        } catch (NumberFormatException e) {
            System.out.println("Invalid data found in students.txt");
        }
    }
}
