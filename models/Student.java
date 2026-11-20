package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String fullName;
    private int totalRegisteredCreditHours;
    private List<Course> registeredCourses;
    private List<String> completedCourseCodes;

    public Student(String studentId, String fullName) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.totalRegisteredCreditHours = 0;
        this.registeredCourses = new ArrayList<>();
        this.completedCourseCodes = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getTotalRegisteredCreditHours() {
        return totalRegisteredCreditHours;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void addCompletedCourse(String courseCode) {
        if (!completedCourseCodes.contains(courseCode)) {
            completedCourseCodes.add(courseCode);
        }
    }

    public boolean hasCompletedCourse(String courseCode) {
        return completedCourseCodes.contains(courseCode);
    }

    // التحقق من أن تسجيل المادة الجديدة لن يتجاوز 18 ساعة (FR-11)
    public boolean canRegister(int courseCreditHours) {
        return (this.totalRegisteredCreditHours + courseCreditHours) <= 18;
    }

    public boolean isRegisteredIn(Course course) {
        return registeredCourses.contains(course);
    }

    public void addCourse(Course course) {
        registeredCourses.add(course);
        totalRegisteredCreditHours += course.getCreditHours();
    }

    public void removeCourse(Course course) {
        if (registeredCourses.remove(course)) {
            totalRegisteredCreditHours -= course.getCreditHours();
        }
    }
}