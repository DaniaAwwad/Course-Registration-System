package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String fullName;
    private int totalRegisteredCreditHours;
    private List<Course> registeredCourses;

    public Student(String studentId, String fullName) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.totalRegisteredCreditHours = 0; // الساعات المسجلة بتكون صفر بالبداية
        this.registeredCourses = new ArrayList<>();
    }

    // دالة للتحقق من أن تسجيل المادة الجديدة لن يتجاوز 18 ساعة (FR-11)
    public boolean canRegister(int courseCreditHours) {
        return (this.totalRegisteredCreditHours + courseCreditHours) <= 18;
    }

    // TODO: إضافة دوال الـ get والـ set لاحقاً
}