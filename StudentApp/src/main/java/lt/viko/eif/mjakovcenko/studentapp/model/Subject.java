package lt.viko.eif.mjakovcenko.studentapp.model;

import javax.persistence.*;

@Entity
@Table(name="subject")
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String name;
    private int credits;

    //Constructor
    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return String.format("\t\tSubject: \n" +
                "\t\t\tName: %s\n " +
                "\t\t\tCredits: %d\n", this.name, this.credits);
    }
//Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}


