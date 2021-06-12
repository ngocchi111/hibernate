package sv18120010.hibernate;

import java.util.Objects;

public class AccountTeacher {
    private String idAccount;
    private String username;
    private String password;
    private Integer state;

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        AccountTeacher that = (AccountTeacher) o;
        return Objects.equals(idAccount, that.idAccount) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, username, password, state);
    }
}
