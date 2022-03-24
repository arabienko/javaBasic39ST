package by.arabienko.controller.test;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.dao.mysql.old.ScheduleSubjectsDaoImpl;
import by.arabienko.entity.Schedule;

import java.util.List;

public class Test4 {
    public static void main(String[] args) throws DaoException {
        ScheduleSubjectsDaoImpl subjectsDao = new ScheduleSubjectsDaoImpl();
        List<Schedule> list = subjectsDao.findScheduleSubjectsByTeacher("Lozkina");
        for (Schedule subject : list){
            System.out.println(subject);
        }

    }
}
