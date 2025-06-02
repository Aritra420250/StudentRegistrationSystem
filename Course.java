class Course {
    String code;
    String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

class CourseRegistrationManager {
    List<Course> courses = new ArrayList<>();

    public CourseRegistrationManager() {
        courses.add(new Course("CSE101", "Intro to Programming"));
        courses.add(new Course("MAT102", "Calculus I"));
        courses.add(new Course("ENG103", "English Composition"));
    }

    public void showCourses() {
        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).title + " (" + courses.get(i).code + ")");
        }
    }

    public Course getCourseByIndex(int index) {
        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        }
        return null;
    }
}
