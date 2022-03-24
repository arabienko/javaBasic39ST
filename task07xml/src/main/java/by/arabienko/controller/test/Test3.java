package by.arabienko.controller.test;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.dao.mysql.SubjectDaoImpl;
import by.arabienko.entity.Subject;

public class Test3 {
    public static void main(String[] args) throws DaoException {
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        String pattern = "mathematics";
        Subject subject = subjectDao.findSubjectByName(pattern);
        System.out.println(subject);

    }
}
