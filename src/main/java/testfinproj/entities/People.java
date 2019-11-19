package testfinproj.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Please fill")
    @Length(max = 255, message = "too long")
    private String lastName;
    @NotBlank(message = "Please fill")
    @Length(max = 255, message = "too long")
    private String firstName;
    @NotBlank(message = "Please fill")
    @Length(max = 255, message = "too long")
    private String patronymic;
    @NotBlank(message = "Please fill")
    @Length(max = 255, message = "too long")
    private String login;
    @NotBlank(message = "Please fill")
    @Length(max = 255, message = "too long")
    private String password;
    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public People(String lastName, String firstName, String patronymic, String login, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
    }

    public People() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

}
