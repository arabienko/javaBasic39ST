package by.arabienko.controller.test;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.dao.mysql.old.StudentDaoImpl;
import by.arabienko.dao.mysql.UserDaoImpl;
import by.arabienko.entity.oldScheme.Student;
import by.arabienko.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        UserDaoImpl userDao = null;
        try {
            userDao = new UserDaoImpl();
            User users = userDao.findUserByLogin("teacher3");
        } catch (DaoException | SQLException e) {
            e.printStackTrace();
        }
        //List<User> userAll = userDao.findAll();
       /* System.out.println(users);
        System.out.println("---------------");
        for (User user : userAll){
            System.out.println(user);
        }
        System.out.println("---------------");*/
        StudentDaoImpl studentDao = null;
        try {
            studentDao = new StudentDaoImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //List<Student> students = studentDao.findUserBySurname("Ivanov");
       // List<Student> studentAll = studentDao.findAll();
        /*System.out.println(students);
        System.out.println("---------------");
        for (Student student : studentAll){
            System.out.println(student);
        }*/
        //  4,
        //       "teacher2" ,
        //       "1c8e87b3ef6a6cc33b5444feba8e25fa90ab8c7b09c3a7aef8e968d842b9add7",
        //       1
       /* User newUser = new User(11,"teacherUpdate2",
                "1c8e87b3ef6a6cc33b5444feba8e25fa90ab8c7b09c3a7aef8e968d842b9add7",1 );
        //userDao.create(newUser);
        if (userDao.delete(12l)){
            System.out.println("User was created");
        }else {
            System.out.println("User fail");
        }
        //System.out.println(userDao.findEntityById(3l));
       List<User> userAll = userDao.findAll();
       System.out.println(users);
        System.out.println("---------------");
        for (User user : userAll){
            System.out.println(user);
        }*/
        Student newStudent = new Student("Arabiyenka", "Tatsiana", "+375295772890",
                "start", "wait");
        try {
           // studentDao.create(newStudent);

        List <Student> allStudents = studentDao.findAll();
        for (Student student : allStudents){
            System.out.println(student);
        }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
