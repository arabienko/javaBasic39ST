package by.arabienko.dao.mysql.old;

import by.arabienko.connect.ConnectToDB;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.oldScheme.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private static final String SQL_SELECT_ALL_TEACHER =
            "SELECT id, surname, name, idSubject, "
                    + "phoneTeacher, degree, pathImage FROM teachers";
    private static final String SQL_SELECT_TEACHER_BY_SURNAME =
            "SELECT id, surname, name, idSubject, "
                    + "phoneTeacher, degree, pathImage "
                    + "FROM teachers WHERE surname=?";
    private static final String SQL_SELECT_TEACHER_BY_ID =
            "SELECT id, surname, name, idSubject, phoneTeacher, degree,"
                    + " pathImage FROM teachers WHERE id=?";
    private static final String SQL_UPDATE_TEACHER =
            "UPDATE teachers SET surname = ? , name = ?, "
                    + "idSubject = ?, phoneTeacher = ?, "
                    + "degree = ?, pathImage = ? WHERE id = ?";
    private static final String SQL_CREATE_TEACHER = "INSERT INTO teachers "
            + "(surname, name, idSubject, phoneTeacher, degree, pathImage)"
            + "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_TEACHER =
            "DELETE FROM teachers WHERE id=?"
                    + "AND surname=? AND name=? AND phoneTeacher=?";
    private static final String SQL_DELETE_TEACHER_BY_ID =
            "DELETE FROM teachers WHERE id=?";
    private static final String SQL_SELECT_TEACHER_BY_SUBJECT =
            "SELECT teachers.id, teachers.surname, teachers.name, "
                    + "teachers.idSubject, teachers.phoneTeacher, "
                    + "teachers.degree, teachers.pathImage "
                    + "FROM teachers, subjects WHERE teachers.idSubject = "
                    + "(SELECT id FROM subjects WHERE nameSubject = ?)";
    private static final String SQL_SELECT_TEACHER_BY_DEGREE =
            "SELECT id, surname, name, idSubject, "
                    + "phoneTeacher, degree, pathImage "
                    + "FROM teachers WHERE degree = ?";

    @Override
    public List<Teacher> findAll() throws DaoException {
        List<Teacher> teachers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery(SQL_SELECT_ALL_TEACHER);
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setIdSubject(resultSet.getInt(4));
                teacher.setPhoneTeacher(resultSet.getString(5));
                teacher.setDegree(resultSet.getString(6));
                teacher.setPathImage(resultSet.getString(7));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return teachers;
    }

    @Override
    public Teacher findEntityById(final Long id) throws DaoException {
        Teacher teacher = new Teacher();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_TEACHER_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                teacher.setId(resultSet.getInt(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setIdSubject(resultSet.getInt(4));
                teacher.setPhoneTeacher(resultSet.getString(5));
                teacher.setDegree(resultSet.getString(6));
                teacher.setPathImage(resultSet.getString(7));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return teacher;
    }

    @Override
    public boolean delete(final Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_DELETE_TEACHER);
            statement.setString(1, String.valueOf(teacher.getId()));
            statement.setString(2, String.valueOf(teacher.getSurname()));
            statement.setString(3, String.valueOf(teacher.getName()));
            statement.setString(4, String.valueOf(teacher.getPhoneTeacher()));
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
    public boolean delete(final Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_DELETE_TEACHER_BY_ID);
            statement.setString(1, String.valueOf(id));
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
    public boolean create(final Teacher teacher) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_CREATE_TEACHER);
            statement.setString(1, teacher.getSurname());
            statement.setString(2, teacher.getName());
            statement.setInt(3, teacher.getIdSubject());
            statement.setString(4, teacher.getPhoneTeacher());
            statement.setString(5, teacher.getDegree());
            statement.setString(6, teacher.getPathImage());
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
    public void update(
            final Teacher teacher) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_TEACHER);
            statement.setString(1, teacher.getSurname());
            statement.setString(2, teacher.getName());
            statement.setInt(3, teacher.getIdSubject());
            statement.setString(4, teacher.getPhoneTeacher());
            statement.setString(5, teacher.getDegree());
            statement.setString(6, teacher.getPathImage());
            statement.setString(7, String.valueOf(teacher.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public List<Teacher> findTeacherBySurname(
            final String patternName) throws DaoException {
        List<Teacher> teachers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_TEACHER_BY_SURNAME);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setIdSubject(resultSet.getInt(4));
                teacher.setPhoneTeacher(resultSet.getString(5));
                teacher.setDegree(resultSet.getString(6));
                teacher.setPathImage(resultSet.getString(7));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return teachers;
    }

    @Override
    public List<Teacher> findTeacherBySubject(
            final String patternName) throws DaoException {
        List<Teacher> teachers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_TEACHER_BY_SUBJECT);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setIdSubject(resultSet.getInt(4));
                teacher.setPhoneTeacher(resultSet.getString(5));
                teacher.setDegree(resultSet.getString(6));
                teacher.setPathImage(resultSet.getString(7));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return teachers;
    }

    @Override
    public List<Teacher> findTeacherByDegree(
            final String patternName) throws DaoException {
        List<Teacher> teachers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_TEACHER_BY_DEGREE);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setSurname(resultSet.getString(2));
                teacher.setName(resultSet.getString(3));
                teacher.setIdSubject(resultSet.getInt(4));
                teacher.setPhoneTeacher(resultSet.getString(5));
                teacher.setDegree(resultSet.getString(6));
                teacher.setPathImage(resultSet.getString(7));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return teachers;
    }
}
