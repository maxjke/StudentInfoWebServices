package lt.viko.eif.mjakovcenko.studentapp.model;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String userName;
    private String password;

    //Constructor
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("\t\tUserName: %s\n" +
                "\t\tPassword: %s",
                this.userName, this.password);
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
