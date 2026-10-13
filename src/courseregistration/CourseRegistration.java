/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseregistration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sıla
 */
public class CourseRegistration {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        int numCourses = 0;
        while (numCourses < 3) {
            System.out.print("How many courses do you want to create? (At least 3): ");
            if (scanner.hasNextInt()) {
                numCourses = scanner.nextInt();
                if (numCourses < 3) {
                    System.out.println("Please enter at least 3.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        scanner.nextLine(); 

        for (int i = 0; i < numCourses; i++) {
            System.out.print((i + 1) + ". Course Name: ");
            String cName = scanner.nextLine();
            System.out.print((i + 1) + ". Course Capacity: ");
            int cap = scanner.nextInt();
            scanner.nextLine();
            courses.add(new Course(cName, cap));
        }

        System.out.println("\nAvailable courses for registration:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }

        while (true) {
            System.out.println("\n--- ACTION MENU ---");
            System.out.println("1. Register Student");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Student ID: ");
                String sId = scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String sName = scanner.nextLine();
                System.out.print("Enter the exact name of the course to register for: ");
                String targetCourseName = scanner.nextLine();

                Course foundCourse = null;
                for (Course c : courses) {
                    if (c.getCourseName().equalsIgnoreCase(targetCourseName)) {
                        foundCourse = c;
                        break;
                    }
                }

                if (foundCourse == null) {
                    System.out.println("No course found with that name.");
                } else {
                    if (foundCourse.getEnrolledStudents().size() >= foundCourse.getCapacity()) {
                        System.out.println("This course is full. Registration failed.");
                    } else {
                        boolean alreadyRegistered = false;
                        for (Student s : foundCourse.getEnrolledStudents()) {
                            if (s.getStudentID().equals(sId)) {
                                alreadyRegistered = true;
                                break;
                            }
                        }
                        
                        if (alreadyRegistered) {
                            System.out.println("This student is already registered for this course.");
                        } else {
                            foundCourse.getEnrolledStudents().add(new Student(sId, sName));
                            System.out.println("Registration successful.");
                        }
                    }
                }

            } else if (choice.equals("2")) {
                System.out.println("\n--- ALL COURSES ---");
                for (Course c : courses) {
                    c.displayInfo();
                    System.out.println("---------------------------");
                }
            } else if (choice.equals("3")) {
                System.out.println("Exiting the system...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}

