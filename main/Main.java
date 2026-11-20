package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Course;
import models.Student;
import services.RegistrationService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationService service = new RegistrationService();

        // بيانات تجريبية لطالب ومواد
        Student student = new Student("20231001", "Dania");
        student.addCompletedCourse("CS101"); // الطالب قاطع مادة CS101

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS201", "Data Structures", 3, 2, "CS101"));
        courses.add(new Course("SE301", "Software Engineering Tools", 3, 30, null));
        courses.add(new Course("SE302", "Advanced Software Design", 3, 25, "SE301")); // متطلبها مش مقطوع
        courses.add(new Course("DB201", "Database Systems", 3, 1, null));

        boolean running = true;
        while (running) {
            System.out.println("=== Course Registration System ===");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View My Schedule");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // لتفريغ السطر

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Courses ---");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i));
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter course number to register: ");
                    int regIndex = scanner.nextInt() - 1;
                    if (regIndex >= 0 && regIndex < courses.size()) {
                        service.registerCourse(student, courses.get(regIndex));
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter course number to drop: ");
                    int dropIndex = scanner.nextInt() - 1;
                    if (dropIndex >= 0 && dropIndex < courses.size()) {
                        service.dropCourse(student, courses.get(dropIndex));
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;
                case 4:
                    service.printStudentSchedule(student);
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}