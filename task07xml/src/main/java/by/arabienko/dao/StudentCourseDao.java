package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.StudentCourse;

import java.util.List;

public interface StudentCourseDao extends Dao<Long, StudentCourse> {
    List<StudentCourse> findStudentCourseBySubject(String namePattern) throws DaoException;

}
