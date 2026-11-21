
package models;

import java.util.List;

public class Administrator {

    private String adminId;
    private String fullName;

    public Administrator(String adminId, String fullName) {
        this.adminId = adminId;
        this.fullName = fullName;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getFullName() {
        return fullName;
    }

    public void addCourse(List<Course> courseCatalog, Course newCourse) {
        courseCatalog.add(newCourse);
        System.out.println("Admin " + fullName + " added course: " + newCourse.getCourseCode());
    }

    public void removeCourse(List<Course> courseCatalog, Course course) {
        if (courseCatalog.remove(course)) {
            System.out.println("Admin " + fullName + " removed course: " + course.getCourseCode());
        } else {
            System.out.println("Course not found in catalog.");
        }
    }
}
