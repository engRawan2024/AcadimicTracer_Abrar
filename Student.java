import java.util.Arrays;

/**
 * Represents a single student, holding their personal details and academic marks.
 * This class encapsulates the data and provides methods to calculate statistics.
 */
public class Student {
    // --- Fields ---
    private final String studentId;
    private final String fullName;
    private final int courseCount;
    private int[] courseMarks;
    private boolean marksAreSet = false; // Flag to track if marks have been entered.

    /**
     * Constructs a new Student object.
     * @param id The student's 9-digit KKU ID.
     * @param name The student's full name.
     * @param numCourses The number of courses they are registered for.
     */
    public Student(String id, String name, int numCourses) {
        this.studentId = id;
        this.fullName = name;
        this.courseCount = numCourses;
        this.courseMarks = new int[numCourses];
    }

    // --- Getters and Setters ---
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public boolean areMarksSet() {
        return marksAreSet;
    }

    /**
     * Assigns the marks for all courses and updates the status flag.
     * @param marks An array of integers representing course marks.
     */
    public void setCourseMarks(int[] marks) {
        this.courseMarks = marks;
        this.marksAreSet = true;
    }

    // --- Calculation Methods ---
    public double calculateAverage() {
        if (!marksAreSet || courseMarks.length == 0) {
            return 0.0;
        }
        // Use Java Streams for a different calculation approach.
        return Arrays.stream(courseMarks).average().orElse(0.0);
    }

    public int findMaxMark() {
        if (!marksAreSet || courseMarks.length == 0) {
            return 0;
        }
        return Arrays.stream(courseMarks).max().getAsInt();
    }

    public int findMinMark() {
        if (!marksAreSet || courseMarks.length == 0) {
            return 0;
        }
        return Arrays.stream(courseMarks).min().getAsInt();
    }
    
    // --- Display Methods ---
    /**
     * Prints a formatted summary of the student's marks and statistics.
     */
    public void displayMarksInfo() {
        System.out.println("\n--- Academic Marks Summary ---");
        for (int i = 0; i < courseMarks.length; i++) {
            String status;
            if (courseMarks[i] >= 60) {
                status = "(Pass)";
            } else {
                status = "(Fail)";
            }
            System.out.printf("  Course #%d: %d %s\n", (i + 1), courseMarks[i], status);
        }
        System.out.println("---------------------------------");
        System.out.printf("ًں“ٹ Average: %.2f\n", calculateAverage());
        System.out.println("ًں“ˆ Maximum Mark: " + findMaxMark());
        System.out.println("ًں“‰ Minimum Mark: " + findMinMark());
    }

    /**
     * Prints a comprehensive report including personal details and marks summary.
     */
    public void displayFullReport() {
        System.out.println("\n--- Complete Student Details ---");
        System.out.println("ًں‘¤ Name: " + this.fullName);
        System.out.println("ًں†” KKU ID: " + this.studentId);
        System.out.println("ًں“ڑ Registered Courses: " + this.courseCount);
        // Reuse the marks info display method
        displayMarksInfo();
    }
}
