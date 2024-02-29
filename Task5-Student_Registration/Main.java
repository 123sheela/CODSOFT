import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int schedule;
    private int registeredCount;

    public Course(String code, String title, String description, int capacity, int schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredCount = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSchedule() {
        return schedule;
    }

    public int getRegisteredCount() {
        return registeredCount;
    }

    public void incrementRegisteredCount() {
        registeredCount++;
    }
}

class Student {
    private String id;
    private String name;
    private List<String> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class Main {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Add sample courses
        courses.add(new Course("CSCI101", "Introduction to Computer Science", "Basic concepts of computer science", 30, 1));
        courses.add(new Course("MATH101", "Calculus I", "Fundamental concepts of calculus", 25, 2));
        courses.add(new Course("EVSE230", "Environmental Science ", "Fundamental concepts of Environmental science", 35, 3));
        courses.add(new Course("BCT0436", "Blockchain Technology", "Basics of Blockchain", 32, 4));
        courses.add(new Course("DSAA403", "Data Structures and Algorithms", "Fundamentals of Data Structures", 40, 5));

        // Students with id 
        students.add(new Student("1", "John"));
        students.add(new Student("2", "Keshav"));
        students.add(new Student("3", "Manoj"));
        students.add(new Student("4", "Nithya"));
        students.add(new Student("5", "Shakthi"));
        students.add(new Student("6", "Aasha"));
        students.add(new Student("7", "Akshaya"));
        students.add(new Student("8", "Priya"));
        students.add(new Student("9", "Abinaya"));
        students.add(new Student("10", "Shiva"));

        Scanner sc = new Scanner(System.in);
        System.out.println(" ______________________________________________");
        System.out.println("|                                              |");
        System.out.println("|-----> STUDENT COURSE REGISTRATION FORM <-----|");
        System.out.println("|______________________________________________|");

        while (true) {
            System.out.println("_______________________________________");
            System.out.println("1. Course Lists");
            System.out.println("2. Course Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.println("_______________________________________");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayCourses();
                    break;
                case 2:
                    registerStudent(sc);
                    break;
                case 3:
                    removeCourse(sc);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.out.println("_______________________________________");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            int availableSlots = course.getCapacity() - students.size();
            System.out.println("Code: " + course.getCode() + ", Title: " + course.getTitle() +
                    ", Description: " + course.getDescription() + ", Available Slots: " + availableSlots +
                    ", Registered Count: " + course.getRegisteredCount());
        }
    }

    private static void registerStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter course code to register: ");
        String courseCode = sc.nextLine();

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student == null) {
            System.out.println("Student with ID " + studentId + " does not exist.");
            return;
        }

        if (course == null) {
            System.out.println("Course with code " + courseCode + " does not exist.");
            return;
        }

        if (student.getRegisteredCourses().contains(courseCode)) {
            System.out.println("Student already registered for this course.");
            return;
        }

        if (course.getCapacity() <= student.getRegisteredCourses().size()) {
            System.out.println("Course is already at full capacity.");
            return;
        }

        student.registerCourse(courseCode);
        course.incrementRegisteredCount();
        System.out.println("Student '" + student.getName() + "' registered for course '" + course.getTitle() + "'");
    }

    private static void removeCourse(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter course code to remove: ");
        String courseCode = sc.nextLine();

        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student with ID " + studentId + " does not exist.");
            return;
        }

        if (!student.getRegisteredCourses().contains(courseCode)) {
            System.out.println("Student is not registered for this course.");
            return;
        }

        student.dropCourse(courseCode);
        Course course = findCourseByCode(courseCode);
        course.incrementRegisteredCount(); // Decrease the registered count
        System.out.println("Student '" + student.getName() + "' dropped course '" + courseCode + "'");
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
