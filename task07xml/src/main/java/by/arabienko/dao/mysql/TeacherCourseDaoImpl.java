package by.arabienko.dao.mysql;

import by.arabienko.dao.TeacherCourseDao;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.TeacherCourse;

import java.util.List;

public class TeacherCourseDaoImpl implements TeacherCourseDao {
    @Override
    public List<TeacherCourse> findAll() throws DaoException {
        return null;
    }

    @Override
    public TeacherCourse findEntityById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(TeacherCourse teacherCourse) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(TeacherCourse teacherCourse) throws DaoException {
        return false;
    }

    @Override
    public void update(TeacherCourse teacherCourse) throws DaoException {

    }

    @Override
    public List<TeacherCourse> findCourseByStartDate(String namePattern) throws DaoException {
        return null;
    }

    @Override
    public List<TeacherCourse> findCourseBySubject(String namePattern) throws DaoException {
        return null;
    }
}
