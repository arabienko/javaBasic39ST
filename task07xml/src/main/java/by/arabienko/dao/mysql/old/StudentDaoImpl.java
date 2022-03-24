package by.arabienko.dao.mysql.old;

import by.arabienko.connect.ConnectToDB;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.oldScheme.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static final String SQL_SELECT_ALL_STUDENT =
            "SELECT id, surname, name, phoneStudent, "
                    + "level, status FROM students";
    private static final String SQL_SELECT_STUDENT_BY_SURNAME =
            "SELECT id, surname, name, phoneStudent, level, "
                    + "status FROM students WHERE surname=?";
    private static final String SQL_SELECT_STUDENT_BY_ID =
            "SELECT id, surname, name, phoneStudent,"
                    + "level, status FROM students WHERE id=?";
    private static final String SQL_UPDATE_STUDENT =
            "UPDATE students SET surname=? , name=? , "
                    + "phoneStudent = ?, level = ?, status = ? WHERE id = ?";
    private static final String SQL_CREATE_STUDENT =
            "INSERT INTO students (surname, name, phoneStudent, "
                    + "level, status) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_STUDENT = "DELETE FROM students "
            + "WHERE id=? AND surname=? AND name=? AND phoneStudent=?";
    private static final String SQL_DELETE_STUDENT_BY_ID =
            "DELETE FROM students WHERE id=?";
    private static final String SQL_SELECT_STUDENT_BY_PHONE =
            "SELECT id, surname, name, phoneStudent, "
                    + "level, status FROM students WHERE phoneStudent=?";
    private static final String SQL_SELECT_STUDENT_BY_STATUS =
            "SELECT id, surname, name, phoneStudent, "
                    + "level, status FROM students WHERE status=?";
    private static final String SQL_SELECT_STUDENT_BY_LEVEL =
            "SELECT id, surname, name, phoneStudent,"
                    + "level, status FROM students WHERE level=?";

    public StudentDaoImpl() throws SQLException {
    }


    @Override
    public List<Student> findAll() throws DaoException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery(SQL_SELECT_ALL_STUDENT);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setSurname(resultSet.getString(2));
                student.setName(resultSet.getString(3));
                student.setPhoneStudent(resultSet.getString(4));
                student.setLevel(resultSet.getString(5));
                student.setStatus(resultSet.getString(6));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    @Override
    public Student findEntityById(final Long id) throws DaoException {
        Student student = new Student();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_STUDENT_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setSurname(resultSet.getString("surname"));
                student.setName(resultSet.getString("name"));
                student.setPhoneStudent(resultSet.getString("phoneStudent"));
                student.setLevel(resultSet.getString("level"));
                student.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return student;
    }

    @Override
    public boolean delete(final Student student) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_STUDENT);
            statement.setString(1, String.valueOf(student.getId()));
            statement.setString(2, String.valueOf(student.getSurname()));
            statement.setString(3, String.valueOf(student.getName()));
            statement.setString(4, String.valueOf(student.getPhoneStudent()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Deletion error. "
                   + "The entry does not exist.");
            throw new DaoException("Deletion error. "
                    + "The entry does not exist." + e);
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
            statement = connection.prepareStatement(SQL_DELETE_STUDENT_BY_ID);
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
    public boolean create(final Student student) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_CREATE_STUDENT);
            statement.setString(1, student.getSurname());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPhoneStudent());
            statement.setString(4, student.getLevel());
            statement.setString(5, student.getStatus());
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
    public void update(final Student student) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_STUDENT);
            statement.setString(1, student.getSurname());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPhoneStudent());
            statement.setString(4, student.getLevel());
            statement.setString(5, student.getStatus());
            statement.setString(6, String.valueOf(student.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public List<Student> findUserBySurname(
            final String patternName) throws DaoException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_STUDENT_BY_SURNAME);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setSurname(resultSet.getString(2));
                student.setName(resultSet.getString(3));
                student.setPhoneStudent(resultSet.getString(4));
                student.setLevel(resultSet.getString(5));
                student.setStatus(resultSet.getString(6));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    @Override
    public List<Student> findUserByPhone(
           final String patternName) throws DaoException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_STUDENT_BY_PHONE);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setSurname(resultSet.getString(2));
                student.setName(resultSet.getString(3));
                student.setPhoneStudent(resultSet.getString(4));
                student.setLevel(resultSet.getString(5));
                student.setStatus(resultSet.getString(6));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    @Override
    public List<Student> findUserByStatus(
            final String patternName) throws DaoException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_STUDENT_BY_STATUS);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setSurname(resultSet.getString(2));
                student.setName(resultSet.getString(3));
                student.setPhoneStudent(resultSet.getString(4));
                student.setLevel(resultSet.getString(5));
                student.setStatus(resultSet.getString(6));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    @Override
    public List<Student> findUserByLevel(
            final String patternName) throws DaoException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_STUDENT_BY_LEVEL);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setSurname(resultSet.getString(2));
                student.setName(resultSet.getString(3));
                student.setPhoneStudent(resultSet.getString(4));
                student.setLevel(resultSet.getString(5));
                student.setStatus(resultSet.getString(6));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return students;
    }
}
