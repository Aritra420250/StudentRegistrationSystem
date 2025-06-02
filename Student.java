class Student {
    int id;
    String name;
    Account account;
    List<Course> registeredCourses = new ArrayList<>();

    public Student(int id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Registered to course: " + course.title);
    }

    public void showRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered yet.");
        } else {
            System.out.println("Registered Courses:");
            for (Course c : registeredCourses) {
                System.out.println("- " + c.title);
            }
        }
    }
}
