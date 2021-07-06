package sv18120010.hibernate;

import java.util.Objects;

public class DKHP {
    private String idDkhp;
    private String idStudent;
    private String idCourse;
    private String idSemester;

    public String getIdDkhp() {
        return idDkhp;
    }

    public void setIdDkhp(String idDkhp) {
        this.idDkhp = idDkhp;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DKHP dkhp = (DKHP) o;
        return Objects.equals(idDkhp, dkhp.idDkhp) && Objects.equals(idStudent, dkhp.idStudent) && Objects.equals(idCourse, dkhp.idCourse) && Objects.equals(idSemester, dkhp.idSemester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDkhp, idStudent, idCourse, idSemester);
    }
}
