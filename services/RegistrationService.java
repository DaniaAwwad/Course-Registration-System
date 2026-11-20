package services;

import models.Course;
import models.Student;

public class RegistrationService {

    public boolean registerCourse(Student student, Course course) {
        // 1. فحص إذا المادة مسجلة مسبقاً
        if (student.isRegisteredIn(course)) {
            System.out.println("Error: Already registered in " + course.getCourseCode());
            return false;
        }

        // 2. فحص المتطلب السابق (Prerequisite)
        String prereq = course.getPrerequisiteCourseCode();
        if (prereq != null && !prereq.isEmpty() && !student.hasCompletedCourse(prereq)) {
            System.out.println("Error: Missing prerequisite (" + prereq + ") for " + course.getCourseCode());
            return false;
        }

        // 3. فحص وجود مقاعد متاحة
        if (!course.hasAvailableSeats()) {
            System.out.println("Error: No available seats in " + course.getCourseCode());
            return false;
        }

        // 4. فحص الحد الأقصى للساعات (18 ساعة)
        if (!student.canRegister(course.getCreditHours())) {
            System.out.println("Error: Exceeds maximum allowed credit hours (18 hrs).");
            return false;
        }

        // تنفيذ التسجيل
        student.addCourse(course);
        course.decreaseAvailableSeats();
        System.out.println("Success: Registered in " + course.getCourseCode() + " - " + course.getCourseName());
        return true;
    }

    public boolean dropCourse(Student student, Course course) {
        if (!student.isRegisteredIn(course)) {
            System.out.println("Error: You are not registered in " + course.getCourseCode());
            return false;
        }

        student.removeCourse(course);
        course.increaseAvailableSeats();
        System.out.println("Success: Dropped " + course.getCourseCode());
        return true;
    }

    public void printStudentSchedule(Student student) {
        System.out.println("\n--- Schedule for " + student.getFullName() + " (" + student.getStudentId() + ") ---");
        if (student.getRegisteredCourses().isEmpty()) {
            System.out.println("No courses registered yet.");
        } else {
            for (Course c : student.getRegisteredCourses()) {
                System.out.println("- " + c.getCourseCode() + ": " + c.getCourseName() + " (" + c.getCreditHours() + " hrs)");
            }
        }
        System.out.println("Total Registered Credit Hours: " + student.getTotalRegisteredCreditHours() + "/18\n");
    }
}
