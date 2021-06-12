package sv18120010.hibernate;

import java.sql.Date;
import java.util.Objects;

public class Dkhpsesion {
    private String idDkhPsesion;
    private Date timeStart;
    private Date timeEnd;

    public String getIdDkhPsesion() {
        return idDkhPsesion;
    }

    public void setIdDkhPsesion(String idDkhPsesion) {
        this.idDkhPsesion = idDkhPsesion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dkhpsesion that = (Dkhpsesion) o;
        return Objects.equals(idDkhPsesion, that.idDkhPsesion) && Objects.equals(timeStart, that.timeStart) && Objects.equals(timeEnd, that.timeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDkhPsesion, timeStart, timeEnd);
    }
}
