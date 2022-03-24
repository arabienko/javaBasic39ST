package by.arabienko.dao.mysql.old;

import by.arabienko.dao.Dao;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.oldScheme.Teacher;

import java.util.List;

public interface TeacherDao extends Dao<Long, Teacher> {
    List<Teacher> findTeacherBySurname(String patternName) throws DaoException;
    List<Teacher> findTeacherBySubject(String patternName) throws DaoException;
    List<Teacher> findTeacherByDegree(String patternName) throws DaoException;
}
