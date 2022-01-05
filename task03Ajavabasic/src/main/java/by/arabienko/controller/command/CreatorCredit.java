package by.arabienko.controller.command;

import by.arabienko.entity.ICredit;

import java.util.List;

/**
 * An abstract class for creating request.
 */
public abstract class CreatorCredit {

    public abstract ICredit methodCreate(List list);
}
