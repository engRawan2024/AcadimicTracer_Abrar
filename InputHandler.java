import java.util.Scanner;

/**
 * A utility class to handle all user input and validation for the application.
 * This separates the input logic from the main application flow.
 */
public class InputHandler {
    // A single scanner for the entire application.
    private static final Scanner consoleReader = new Scanner(System.in);

    /**
     * Reads and validates the student's KKU ID.
     * Must be 9 digits and start with '4'.
     * @return The validated student ID.
     */
    public static String getStudentId() {
        String id;
        while (true) {
            System.out.print("Enter Student KKU ID: ");
            id = consoleReader.nextLine();
            if (id.matches("4\\d{8}")) { // Regex for '4' followed by 8 digits.
                return id;
            } else {
                System.out.println("  -> Error: ID must be 9 digits and start with '4'. Try again.");
            }
        }
    }

    /**
     * Reads the student's name and converts it to Title Case.
     * @return The formatted student name.
     */
    public static String getStudentName() {
        System.out.print("Enter Student Full Name: ");
        String name = consoleReader.nextLine().trim().toLowerCase();
        
        if (name.isEmpty()) {
            return "Unnamed";
        }

        // Alternative implementation for Title Case conversion.
        char[] nameChars = name.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < nameChars.length; i++) {
            if (Character.isWhitespace(nameChars[i])) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                nameChars[i] = Character.toTitleCase(nameChars[i]);
                capitalizeNext = false;
            }
        }
        return new String(nameChars);
    }
    
    /**
     * Reads and validates the number of courses.
     * Must be an integer between 1 and 5.
     * @return The validated number of courses.
     */
    public static int getCourseCount() {
        while (true) {
            System.out.print("Enter number of courses [1-5]: ");
            String line = consoleReader.nextLine();
            try {
                int count = Integer.parseInt(line);
                if (count >= 1 && count <= 5) {
                    return count;
                } else {
                    System.out.println("  -> Error: Number must be between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("  -> Error: Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Reads and validates a single mark for a course.
     * Must be an integer between 0 and 100.
     * @param courseNumber The number of the course to display in the prompt.
     * @return The validated mark.
     */
    public static int getMark(int courseNumber) {
        while (true) {
            System.out.printf("Enter mark for course #%d [0-100]: ", courseNumber);
            String line = consoleReader.nextLine();
            try {
                int mark = Integer.parseInt(line);
                if (mark >= 0 && mark <= 100) {
                    return mark;
                } else {
                    System.out.println("  -> Error: Mark must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("  -> Error: Invalid input. Please enter a number.");
            }
        }
    }
    
    /**
     * Reads the user's menu selection.
     * @return An integer representing the chosen option.
     */
    public static int getMenuSelection() {
        System.out.print("Enter your choice [1-5]: ");
        String line = consoleReader.nextLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1; // Return an invalid choice indicator
        }
    }
    
    /**
     * Closes the static scanner to release system resources.
     */
    public static void closeScanner() {
        consoleReader.close();
    }
}
