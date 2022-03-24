package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.TeacherSubject;

import java.util.List;

public interface TeacherSubjectDao extends Dao<Long, TeacherSubject> {
    List<TeacherSubject> findTeacherSubjectBySurnameTeacher(String namePattern) throws DaoException;
    List<TeacherSubject> findTeacherSubjectBySubject (String namePattern) throws DaoException;
}
