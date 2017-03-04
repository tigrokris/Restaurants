package ru.demianko.restaurants.to;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import ru.demianko.restaurants.util.UserUtil;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class UserTo implements Serializable {
    private static final long serialVersionUID = 1L;

    protected int id;

    @NotEmpty
    protected String name;

    @Email
    @NotEmpty
    protected String email;

    @Size(min = 5, max = 64, message = " must between 5 and 64 characters")
    protected String password;

/*    @NotEmpty
    protected Date dateOfVote; */

    public UserTo() {
    }

    public UserTo(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = (id == null ? 0 : id);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*    public Date getDateOfVote() {
        return dateOfVote;
    }

    public void setDateOfVote(Date dateOfVote) {
        this.dateOfVote = dateOfVote;
    }*/

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
