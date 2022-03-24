package by.arabienko.dao.mysql.old;

import by.arabienko.dao.Dao;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.Schedule;

import java.util.List;

public interface ScheduleSubjectsDao extends Dao<Long, Schedule> {
    List<Schedule> findScheduleSubjectsBySubject(String patternName) throws DaoException;
    List<Schedule> findScheduleSubjectsByDateTime(String patternName) throws DaoException;
    List<Schedule> findScheduleSubjectsByTeacher(String patternName) throws DaoException;


}
