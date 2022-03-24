package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.TeacherCourse;

import java.util.List;

public interface TeacherCourseDao extends Dao<Long, TeacherCourse> {
    List<TeacherCourse> findCourseByStartDate(String namePattern) throws DaoException, DaoException;
    List<TeacherCourse> findCourseBySubject(String namePattern) throws DaoException;
}
