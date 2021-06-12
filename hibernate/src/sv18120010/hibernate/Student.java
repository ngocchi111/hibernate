package sv18120010.hibernate;

import java.sql.Date;
import java.util.Objects;

public class Student {
    private String idStudent;
    private String idclass;
    private String name;
    private String address;
    private String faculty;
    private Date birthday;
    private Integer schoolYear;
    private String phone;

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdclass() {
        return idclass;
    }

    public void setIdclass(String idclass) {
        this.idclass = idclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(idStudent, student.idStudent) && Objects.equals(idclass, student.idclass) && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(faculty, student.faculty) && Objects.equals(birthday, student.birthday) && Objects.equals(schoolYear, student.schoolYear) && Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idclass, name, address, faculty, birthday, schoolYear, phone);
    }
}
