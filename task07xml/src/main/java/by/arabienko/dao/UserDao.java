package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.User;

public interface UserDao extends Dao<Long, User> {
    User findUserByLogin(String patternName) throws DaoException, DaoException;
}
