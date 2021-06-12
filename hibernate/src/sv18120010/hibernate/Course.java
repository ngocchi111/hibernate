package sv18120010.hibernate;

import java.util.Objects;

public class Course {
    private String idCourse;
    private String idSubject;
    private String idTeacher;
    private String idClassroom;
    private Integer day;
    private Integer time;
    private Integer state;

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(String idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(idCourse, course.idCourse) && Objects.equals(idSubject, course.idSubject) && Objects.equals(idTeacher, course.idTeacher) && Objects.equals(idClassroom, course.idClassroom) && Objects.equals(day, course.day) && Objects.equals(time, course.time) && Objects.equals(state, course.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, idSubject, idTeacher, idClassroom, day, time, state);
    }
}
