package sv18120010.hibernate;

import java.util.Objects;

public class Subject {
    private String idSubject;
    private String name;
    private Integer timeStudy;
    private Integer state;

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeStudy() {
        return timeStudy;
    }

    public void setTimeStudy(Integer timeStudy) {
        this.timeStudy = timeStudy;
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
        Subject subject = (Subject) o;
        return Objects.equals(idSubject, subject.idSubject) && Objects.equals(name, subject.name) && Objects.equals(timeStudy, subject.timeStudy) && Objects.equals(state, subject.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, name, timeStudy, state);
    }
}
