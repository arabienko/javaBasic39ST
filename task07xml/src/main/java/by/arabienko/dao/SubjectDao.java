package by.arabienko.dao;

import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.Subject;

public interface SubjectDao extends Dao<Long, Subject> {
    Subject findSubjectByName(String patternName) throws DaoException;
}
