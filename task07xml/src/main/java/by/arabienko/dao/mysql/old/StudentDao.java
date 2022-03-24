package by.arabienko.dao.mysql.old;

import by.arabienko.dao.Dao;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.oldScheme.Student;

import java.util.List;

public interface StudentDao extends Dao<Long, Student> {
    List<Student> findUserBySurname(String patternName) throws DaoException;
    List<Student> findUserByPhone(String patternName) throws DaoException;
    List<Student> findUserByStatus(String patternName) throws DaoException;
    List<Student> findUserByLevel(String patternName) throws DaoException;

}
