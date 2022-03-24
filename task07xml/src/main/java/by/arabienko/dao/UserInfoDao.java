package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.UserInfo;

import java.util.List;

public interface UserInfoDao extends Dao<Long, UserInfo> {
    List<UserInfo> findUserBySurname(String patternName) throws DaoException, DaoException;
    List<UserInfo> findUserTeacher() throws DaoException;
    List<UserInfo> findUserStudent() throws DaoException;
    UserInfo findUserAdmin() throws DaoException;
}
