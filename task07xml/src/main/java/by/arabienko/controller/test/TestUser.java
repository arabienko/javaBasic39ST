package by.arabienko.controller.test;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.dao.mysql.UserInfoDaoImpl;

public class TestUser {
    public static void main(String[] args) throws DaoException {
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        System.out.println(userInfoDao.findUserBySurname("Green"));
    }
}
