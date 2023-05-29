package ms.edu.utez.firstapp.models.user;

public class user {
    private long id;
    private String name;
    private String surname;
    private String lastname;
    private String birthaday;
    private String username;
    private String status;

    public user() {

    }

    public user(long id, String name, String surname, String lastname, String birthaday, String username, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthaday = birthaday;
        this.username = username;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthaday() {
        return birthaday;
    }

    public void setBirthaday(String birthaday) {
        this.birthaday = birthaday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
