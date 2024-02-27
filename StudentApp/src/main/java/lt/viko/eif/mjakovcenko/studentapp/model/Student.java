package lt.viko.eif.mjakovcenko.studentapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String firstName;
    private String lastName;
    private String code;
    @OneToOne(targetEntity = Account.class,cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(targetEntity = Subject.class,cascade = CascadeType.ALL)
    private List<Subject> subjectList = new ArrayList<>();


    //Constructor

    public Student(String firstName, String lastName, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
    }
    @Override
    public String toString() {
        return String.format("Student: \n" +
                "\tFirst name: %s\n" +
                "\tLast Name: %s\n" +
                "\tCode: %s\n" +
                "\tAccount: \n" +
                "%s " +
                "\n\tSubjects:  \n%s",
                this.firstName, this.lastName, this.code, account, constructSubjectList() );
    }

    private String constructSubjectList(){
        String result = "";
        for(Subject subject : subjectList){
            result += subject;
        }
        return result;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
