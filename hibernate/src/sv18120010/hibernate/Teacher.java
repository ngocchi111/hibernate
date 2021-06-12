package sv18120010.hibernate;

import java.sql.Date;
import java.util.Objects;

public class Teacher {
    private String idTeacher;
    private String name;
    private Date birthday;
    private String faculty;
    private String address;
    private String phone;

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        Teacher teacher = (Teacher) o;
        return Objects.equals(idTeacher, teacher.idTeacher) && Objects.equals(name, teacher.name) && Objects.equals(birthday, teacher.birthday) && Objects.equals(faculty, teacher.faculty) && Objects.equals(address, teacher.address) && Objects.equals(phone, teacher.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, name, birthday, faculty, address, phone);
    }
}
