package by.arabienko.dao.mysql.old;

import by.arabienko.connect.ConnectToDB;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleSubjectsDaoImpl implements ScheduleSubjectsDao {
    private static final String SQL_SELECT_ALL_SCHEDULE =
            "SELECT id, data_time, idTeacher FROM schedule_subjects";
    private static final String SQL_SELECT_SCHEDULE_BY_ID =
            "SELECT id, data_time, idTeacher FROM schedule_subjects"
                    + "WHERE id=?";
    private static final String SQL_DELETE_SCHEDULE_SUBJECT =
            "DELETE FROM schedule_subjects WHERE data_time=? AND idTeacher=?";
    private static final String SQL_DELETE_SCHEDULE_BY_ID =
            "DELETE FROM schedule_subjects WHERE id=?";
    private static final String SQL_CREATE_SCHEDULE_SUBJECT =
            "INSERT INTO schedule_subjects "
                    + "(data_time, idTeacher) VALUES(?, ?)";
    private static final String SQL_UPDATE_SCHEDULE_SUBJECT =
            "UPDATE schedule_subjects SET data_time = ? "
                    + "AND idTeacher = ? WHERE id = ?";
    private static final String SQL_SELECT_SCHEDULE_SUBJECT_BY_SUBJECT =
            "select schedule_subjects.id, schedule_subjects.data_time, "
                    + "schedule_subjects.idTeacher from schedule_subjects "
                    + "inner join teachers "
                    + "on teachers.id = schedule_subjects.idTeacher "
                    + "inner join subjects "
                    + "on teachers.idSubject = subjects.id where subjects.nameSubject = ?";
    private static final String SQL_SELECT_SCHEDULE_SUBJECT_BY_TEACHER =
            "select schedule_subjects.id, schedule_subjects.data_time, "
                    + "schedule_subjects.idTeacher from schedule_subjects "
                    + "inner join teachers "
                    + "on teachers.id = schedule_subjects.idTeacher "
                    + "where teachers.surname = ?";


    @Override
    public List<Schedule> findAll() throws DaoException {
        List<Schedule> schedules = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery(SQL_SELECT_ALL_SCHEDULE);
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
                //schedule.setDateTime(resultSet.getString(2));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return schedules;
    }

    @Override
    public Schedule findEntityById(final Long id) throws DaoException {
        Schedule schedule = new Schedule();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_SCHEDULE_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                schedule.setId(resultSet.getInt(1));
                //schedule.setDateTime(resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return schedule;
    }

    @Override
    public boolean delete(final Schedule scheduleSubjects) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_SCHEDULE_SUBJECT);
            statement.setString(1, scheduleSubjects.getDateTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return true;
    }

    @Override
    public boolean delete(final Long id) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_SCHEDULE_BY_ID);
            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return true;
    }

    @Override
    public boolean create(
            final Schedule scheduleSubjects) throws DaoException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_CREATE_SCHEDULE_SUBJECT);
            statement.setString(1, scheduleSubjects.getDateTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            return false;
        } finally {
            close(statement);
            close(connection);
        }
        return true;
    }

    @Override
    public void update(Schedule scheduleSubjects) throws DaoException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_SCHEDULE_SUBJECT);
            statement.setString(1, scheduleSubjects.getDateTime());
            statement.setString(3, String.valueOf(scheduleSubjects.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public List<Schedule> findScheduleSubjectsBySubject(
            String patternName) throws DaoException {
        List<Schedule> schedules = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            /*connection = ConnectToDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery(SQL_SELECT_ALL_SCHEDULE);*/
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_SCHEDULE_SUBJECT_BY_SUBJECT);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
                //schedule.setDateTime(resultSet.getString(2));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return schedules;
    }

    @Override
    public List<Schedule> findScheduleSubjectsByDateTime(String patternName) throws DaoException {
        return null;
    }

    @Override
    public List<Schedule> findScheduleSubjectsByTeacher(String patternName) throws DaoException {
        List<Schedule> schedules = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_SCHEDULE_SUBJECT_BY_TEACHER);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
               // schedule.setDateTime(resultSet.getString(2));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return schedules;
    }
}
