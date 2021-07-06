package sv18120010.hibernate;

import java.util.Objects;

public class Classroom {
    private String idClassroom;
    private Integer limit;
    private Integer boy;
    private Integer girl;
    private Integer state;

    public String getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(String idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getBoy() {
        return boy;
    }

    public void setBoy(Integer boy) {
        this.boy = boy;
    }

    public Integer getGirl() {
        return girl;
    }

    public void setGirl(Integer girl) {
        this.girl = girl;
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
        Classroom classroom = (Classroom) o;
        return Objects.equals(idClassroom, classroom.idClassroom) && Objects.equals(limit, classroom.limit) && Objects.equals(boy, classroom.boy) && Objects.equals(girl, classroom.girl) && Objects.equals(state, classroom.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClassroom, limit, boy, girl, state);
    }
}
