package com.studentmanagement.app;

import java.util.Scanner;

import com.studentmanagement.model.Person;
import com.studentmanagement.model.Student;
import com.studentmanagement.model.Teacher;
import com.studentmanagement.service.GradeService;
import com.studentmanagement.exception.InvalidMarksException;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Student Management System ===");

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter student ID: ");
            String id = scanner.nextLine().trim();

            if (id.isEmpty()) {
                System.out.println("Student ID cannot be empty.");
                return;
            }

            int[] marks = new int[5];

            for (int i = 0; i < marks.length; i++) {
                System.out.print(
                    "Enter marks for subject " + (i + 1) + ": "
                );

                if (!scanner.hasNextInt()) {
                    System.out.println("Error: Enter a whole number.");
                    return;
                }

                marks[i] = scanner.nextInt();
            }

            GradeService service = new GradeService();

            try {
                service.validateMarks(marks);

                Student student = new Student(name, id, marks);

                System.out.println("\n=== Student Result ===");
                student.displayStudentDetails();

                System.out.println(
                    "Total Marks: " + service.calculateTotal(
                        student.getMarks()
                    )
                );

                double average =
                    service.calculateAverage(student.getMarks());

                System.out.printf("Average: %.2f%n", average);
                System.out.println(
                    "Grade: " + service.calculateGrade(average)
                );
                System.out.println(
                    "Result: " + service.calculateResult(
                        student.getMarks()
                    )
                );

                System.out.println("\n=== Polymorphism Demo ===");

                Person person = student;
                person.displayRole();

                Teacher teacher =
                    new Teacher("Ravi", "T101", "Java");

                person = teacher;
                person.displayRole();

            } catch (InvalidMarksException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("\nApplication execution completed.");
        }
    }
}