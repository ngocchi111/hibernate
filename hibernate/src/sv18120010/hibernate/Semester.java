package sv18120010.hibernate;

import java.sql.Date;
import java.util.Objects;

public class Semester {
    private String idSemester;
    private Date timeStart;
    private Date timeEnd;
    private String nameSemester;
    private int yearStudy;
    private Integer state;

    public String getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getNameSemester() {
        return nameSemester;
    }

    public void setNameSemester(String nameSemester) {
        this.nameSemester = nameSemester;
    }

    public int getYearStudy() {
        return yearStudy;
    }

    public void setYearStudy(int yearStudy) {
        this.yearStudy = yearStudy;
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
        Semester semester = (Semester) o;
        return Objects.equals(idSemester, semester.idSemester) && Objects.equals(timeStart, semester.timeStart) && Objects.equals(timeEnd, semester.timeEnd) && Objects.equals(nameSemester, semester.nameSemester) && Objects.equals(yearStudy, semester.yearStudy) && Objects.equals(state, semester.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemester, timeStart, timeEnd, nameSemester, yearStudy, state);
    }
}
