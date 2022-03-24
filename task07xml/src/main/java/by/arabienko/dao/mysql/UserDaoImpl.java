package by.arabienko.dao.mysql;

import by.arabienko.connect.ConnectToDB;
import by.arabienko.dao.UserDao;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER =
            LogManager.getLogger(UserDaoImpl.class);

    private static final String SQL_SELECT_ALL_USERS =
            "SELECT id, login, password, role FROM users";
    private static final String SQL_SELECT_USER_BY_LOGIN =
            "SELECT id, login, password, role FROM users WHERE login=?";
    private static final String SQL_SELECT_USER_BY_ID =
            "SELECT id, login, password, role FROM users WHERE id=?";
    private static final String SQL_UPDATE_USER =
            "UPDATE users SET login=? , password=? WHERE id = ?";
    private static final String SQL_CREATE_USER = "INSERT INTO users "
            + "(login, password, role) VALUES(?, ?, ?)";

    public UserDaoImpl() throws SQLException {
    }

    @Override
    public List<User> findAll() throws DaoException {
        LOGGER.debug("Start find all user.");
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setId(
                        resultSet.getInt(1));
                user.setLogin(
                        resultSet.getString(2));
                user.setPassword(
                        resultSet.getString(3));
                user.setRole(
                        resultSet.getInt(4));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.debug("SQLException (findAllUsers) " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public User findEntityById(
            final Long id) throws DaoException {
        LOGGER.debug("Start find user by ID.");
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_USER_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet =
                    statement.executeQuery();
            while (resultSet.next()) {
                user.setId(
                        resultSet.getInt("id"));
                user.setLogin(
                        resultSet.getString("login"));
                user.setPassword(
                        resultSet.getString("password"));
                user.setRole(
                        resultSet.getInt("role"));
            }
        } catch (SQLException e) {
            LOGGER.debug("SQLException " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return user;
    }

    @Override
    public boolean delete(final User user)
            throws DaoException {
        LOGGER.debug("Delete is not supported the operation.");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(final Long id)
            throws DaoException {
        LOGGER.debug("Delete is not supported the operation.");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(final User user) {
        LOGGER.debug("Create user.");
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_CREATE_USER);
            statement.setString(
                    1, user.getLogin());
            statement.setString(
                    2, user.getPassword());
            statement.setInt(
                    3, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("SQLException " + e);
            return false;
        } finally {
            close(statement);
            close(connection);
        }
        return true;
    }

    @Override
    public void update(final User user) {
        LOGGER.debug("Update user.");
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_UPDATE_USER);
            statement.setString(
                    4, String.valueOf(user.getId()));
            statement.setString(
                    1, user.getLogin());
            statement.setString(
                    2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("SQLException " + e);
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public User findUserByLogin(
            final String patternName) throws DaoException {
        LOGGER.debug("Find user by login.");
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectToDB.getConnection();
            statement = connection.
                    prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(
                    1, patternName);
            ResultSet resultSet =
                    statement.executeQuery();
            while (resultSet.next()) {
                user.setId(
                        resultSet.getInt("id"));
                user.setLogin(
                        resultSet.getString("login"));
                user.setPassword(
                        resultSet.getString("password"));
                user.setRole(
                        resultSet.getInt("role"));
            }
        } catch (SQLException e) {
            LOGGER.debug("SQLException " + e);
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return user;
    }
}
