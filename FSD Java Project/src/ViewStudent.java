
public class ViewStudent {

    public void view(StudentService service) {

        if (service.getStudents().isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student s : service.getStudents()) {
            s.display();
        }
    }
}
