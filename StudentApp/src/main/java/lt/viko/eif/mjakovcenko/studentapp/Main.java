package lt.viko.eif.mjakovcenko.studentapp;

import lt.viko.eif.mjakovcenko.studentapp.model.Account;
import lt.viko.eif.mjakovcenko.studentapp.model.Student;
import lt.viko.eif.mjakovcenko.studentapp.model.Subject;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Name1", "LastName1","1001");
        Account account1 = new Account("Username1", "Password1");

        Subject subject1 = new Subject("Subject1", 20);
        Subject subject2 = new Subject("Subject2",20);

        student1.getSubjectList().add(subject1);
        student1.getSubjectList().add(subject2);

        student1.setAccount(account1);
        System.out.println(student1);

        org.h2.tools.Server server = null;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            server = Server.createTcpServer("-tcpPort","9893").start();
            transaction = session.beginTransaction();
            session.save(student1);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();

        }
        finally {
            server.shutdown();
        }
    }
}