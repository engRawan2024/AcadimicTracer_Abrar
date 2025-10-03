/**
 * Main application class for the Students Academic Performance Tracker.
 * This class handles the user menu and the main application loop.
 */
public class AcademicTracker {

    public static void main(String[] args) {
        // The student object will hold all the data. It starts as null.
        Student currentStudent = null;

        System.out.println("Welcome to the Academic Performance Tracker!");

        // Main application loop. Using `while(true)` and `break` is an alternative to a do-while.
        while (true) {
            displayMenu();
            int menuSelection = InputHandler.getMenuSelection();
            System.out.println(); // For spacing

            // Using if-else-if instead of a switch statement.
            if (menuSelection == 1) {
                System.out.println("--- 1. Enter Student Details ---");
                String id = InputHandler.getStudentId();
                String name = InputHandler.getStudentName();
                int count = InputHandler.getCourseCount();
                // Create a new student object, replacing any old one.
                currentStudent = new Student(id, name, count);
                System.out.println("\nâœ… Student details successfully saved.");

            } else if (menuSelection == 2) {
                System.out.println("--- 2. Enter Course Marks ---");
                if (currentStudent == null) {
                    System.out.println("âڑ ï¸ڈ Please enter student details (Option 1) before entering marks.");
                } else {
                    int[] marks = new int[currentStudent.getCourseCount()];
                    for (int i = 0; i < marks.length; i++) {
                        marks[i] = InputHandler.getMark(i + 1);
                    }
                    currentStudent.setCourseMarks(marks);
                    System.out.println("\nâœ… Marks have been successfully recorded.");
                }

            } else if (menuSelection == 3) {
                if (currentStudent == null || !currentStudent.areMarksSet()) {
                    System.out.println("âڑ ï¸ڈ Please enter student details and marks first (Options 1 & 2).");
                } else {
                    currentStudent.displayMarksInfo();
                }

            } else if (menuSelection == 4) {
                if (currentStudent == null || !currentStudent.areMarksSet()) {
                    System.out.println("âڑ ï¸ڈ Please enter student details and marks first (Options 1 & 2).");
                } else {
                    currentStudent.displayFullReport();
                }

            } else if (menuSelection == 5) {
                System.out.println("ًں‘‹ Exiting the application. Thank you!");
                InputHandler.closeScanner(); // Clean up resources.
                break; // Exit the while loop.
                
            } else {
                System.out.println("â‌Œ Invalid selection. Please choose an option from 1 to 5.");
            }
            
            System.out.println("\n----------------------------------------\n"); // Separator for next loop
        }
    }

    /**
     * Displays the main menu options to the user.
     * Using a text block for a different code style.
     */
    public static void displayMenu() {
        System.out.println("======================================");
        System.out.println(" STUDENT PERFORMANCE MENU");
        System.out.println("======================================");
        System.out.println(" 1. Enter/Update Student Details");
        System.out.println(" 2. Enter Course Marks");
        System.out.println(" 3. Display Marks Information");
        System.out.println(" 4. Display Full Student Report");
        System.out.println("  5. Exit");
        System.out.println("  ======================================");
       
    }
}
