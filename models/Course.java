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

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getPrerequisiteCourseCode() {
        return prerequisiteCourseCode;
    }

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public void decreaseAvailableSeats() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void increaseAvailableSeats() {
        if (availableSeats < maxSeats) {
            availableSeats++;
        }
    }

    @Override
    public String toString() {
        String prereq = (prerequisiteCourseCode == null || prerequisiteCourseCode.isEmpty()) ? "None" : prerequisiteCourseCode;
        return courseCode + " - " + courseName + " (" + creditHours + " hrs | Seats: " + availableSeats + "/" + maxSeats + " | Prereq: " + prereq + ")";
    }
}