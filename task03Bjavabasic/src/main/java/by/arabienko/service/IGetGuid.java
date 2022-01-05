package by.arabienko.service;

import by.arabienko.entity.ProgramGuide;
import java.util.HashMap;
import java.util.List;

public interface IGetGuid {

    HashMap<String, ProgramGuide.Program> execute(List<ProgramGuide> list,
                                                  String str1, String str2) throws ServiceException;
}
