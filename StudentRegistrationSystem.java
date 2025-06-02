public class StudentRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static CourseRegistrationManager courseManager = new CourseRegistrationManager();

    public static void main(String[] args) {
        System.out.println("Welcome to Student Registration System");
        while (true) {
            System.out.println("\n1. Register Student\n2. Login & Register Courses\n3. Exit");
            System.out.print("Enter choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    loginAndRegister();
                    break;
                case 3:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void registerStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Create Username: ");
        String username = scanner.nextLine();
        System.out.print("Create Password: ");
        String password = scanner.nextLine();

        Account account = new Account(username, password);
        Student student = new Student(id, name, account);
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    public static void loginAndRegister() {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Student loggedInStudent = null;
        for (Student s : students) {
            if (s.account.login(user, pass)) {
                loggedInStudent = s;
                break;
            }
        }

        if (loggedInStudent == null) {
            System.out.println("Login failed. Invalid credentials.");
            return;
        }

        System.out.println("Welcome, " + loggedInStudent.name);
        while (true) {
            System.out.println("\n1. View Courses\n2. Register a Course\n3. View Registered Courses\n4. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    courseManager.showCourses();
                    break;
                case 2:
                    courseManager.showCourses();
                    System.out.print("Enter course number to register: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Course course = courseManager.getCourseByIndex(index);
                    if (course != null) {
                        loggedInStudent.registerCourse(course);
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;
                case 3:
                    loggedInStudent.showRegisteredCourses();
                    break;
                case 4:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
