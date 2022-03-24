package by.arabienko.controller.test;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.dao.mysql.TeacherSubjectDaoImpl;

public class TestTeacherSubject {
    public static void main(String[] args) throws DaoException {
        TeacherSubjectDaoImpl teacherSubjectDao = new TeacherSubjectDaoImpl();
        System.out.println(teacherSubjectDao.findTeacherSubjectBySubject("java"));
    }
}
