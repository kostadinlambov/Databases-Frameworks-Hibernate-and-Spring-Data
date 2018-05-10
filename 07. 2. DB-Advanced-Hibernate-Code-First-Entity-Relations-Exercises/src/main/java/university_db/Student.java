package university_db;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

//@Entity
@Table(name = "students")
public class Student extends Person{
    private Double averageGrade;
    private Integer attendance;
    private Set<Course> enrolledCourses;

    public Student() {
    }


    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column(name = "attendance")
    public Integer getAttendance() {
        return this.attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    @JoinTable(name = "courses_students",
            joinColumns =
            @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "course_id", referencedColumnName = "id"))
    public Set<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
