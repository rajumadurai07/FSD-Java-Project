import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        service.loadStudents();

        int choice;
        do {
            System.out.println("***** STUDENT MANAGEMENT SYSTEM *****");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    new AddStudent().add(sc, service);
                    break;
                case 2:
                    new ViewStudent().view(service);
                    break;
                case 3:
                    new UpdateStudent().update(sc, service);
                    break;
                case 4:
                    new DeleteStudent().delete(sc, service);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        service.saveStudents();
        sc.close();
    }
}
