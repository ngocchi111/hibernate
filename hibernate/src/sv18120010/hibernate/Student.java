package sv18120010.hibernate;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private String classroom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(classroom, student.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, classroom);
    }

    @Override
    public String toString(){
        return "Student{" + id + " | " + name + " | " + classroom +"}";
    }
}
