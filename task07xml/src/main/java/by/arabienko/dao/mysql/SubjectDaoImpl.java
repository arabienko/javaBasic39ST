package by.arabienko.dao.mysql;

import by.arabienko.connect.ConnectToDB;
import by.arabienko.dao.SubjectDao;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    private static final String SQL_SELECT_ALL_SUBJECTS =
            "SELECT id, nameSubject FROM subjects";
    private static final String SQL_SELECT_SUBJECT_BY_ID =
            "SELECT id, nameSubject FROM subjects WHERE id = ?";
    private static final String SQL_SELECT_SUBJECT_BY_NAME =
            "SELECT id, nameSubject FROM subjects WHERE nameSubject = ?";
    private static final String SQL_UPDATE_SUBJECT =
            "UPDATE subjects SET nameSubject = ? WHERE id = ?";
    private static final String SQL_CREATE_SUBJECT =
            "INSERT INTO subjects (nameSubject) VALUES(?)";
    private static final String SQL_DELETE_SUBJECT =
            "DELETE FROM subjects WHERE nameSubject=?";
    private static final String SQL_DELETE_SUBJECT_BY_ID =
            "DELETE FROM subjects WHERE id=?";

    @Override
    public List<Subject> findAll() throws DaoException {
        List<Subject> subjects = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery(SQL_SELECT_ALL_SUBJECTS);
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt(1));
                subject.setNameSubject(
                        resultSet.getString(2));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return subjects;
    }

    @Override
    public Subject findEntityById(final Long id) throws DaoException {
        Subject subject = new Subject();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_SUBJECT_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subject.setId(resultSet.getInt(1));
                subject.setNameSubject(resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return subject;
    }

    @Override
    public boolean delete(final Subject subject) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_SUBJECT);
            statement.setString(1, subject.getNameSubject());
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
            statement = connection.prepareStatement(SQL_DELETE_SUBJECT_BY_ID);
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
    public boolean create(final Subject subject) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_CREATE_SUBJECT);
            statement.setString(1, subject.getNameSubject());
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
    public void update(final Subject subject) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_SUBJECT);
            statement.setString(1, subject.getNameSubject());
            statement.setString(2, String.valueOf(subject.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public Subject findSubjectByName(
            final String patternName) throws DaoException {
        Subject subject = new Subject();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_SUBJECT_BY_NAME);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subject.setId(resultSet.getInt(1));
                subject.setNameSubject(resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return subject;
    }
}
