public class ViewStudent {
    public void view(StudentService service) {
        if (service.students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student s : service.students) {
            s.display();
        }
    }
}
