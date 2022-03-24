package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.Schedule;

import java.util.List;

public interface ScheduleDao extends Dao<Long, Schedule> {
    List<Schedule> findStudentCourseBySubject(String namePattern) throws DaoException;
}
