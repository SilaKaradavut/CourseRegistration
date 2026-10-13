/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseregistration;

/**
 *
 * @author Sıla
 */
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>(); 
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void displayInfo() {
        System.out.println("Course Name: " + courseName + " | Capacity: " + capacity + 
                           " | Current Number of Enrolled Students: " + enrolledStudents.size());
        System.out.println("Enrolled Students:");
        if (enrolledStudents.isEmpty()) {
            System.out.println("  - No students enrolled yet.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.print("  - ");
                student.printInfo();
            }
        }
    }
}
