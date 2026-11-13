package models;
public class Course {
    private String courseCode;
    private String courseName;
    private int creditHours;
    private int maxSeats;
    private int availableSeats;
    private String prerequisiteCourseCode; 

    public Course(String courseCode, String courseName, int creditHours, int maxSeats, String prerequisiteCourseCode) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.maxSeats = maxSeats;
        this.availableSeats = maxSeats; // المقاعد المتاحة تساوي الحد الأقصى مبدئياً
        this.prerequisiteCourseCode = prerequisiteCourseCode;
    }
}