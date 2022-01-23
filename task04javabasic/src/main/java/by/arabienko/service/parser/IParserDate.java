package by.arabienko.service.parser;

import by.arabienko.bean.entity.ConeShape;
import java.util.List;

/**
 * Parse interface
 */
public interface IParserDate {
    /**
     * parse string to object.
     * @param list string.
     * @return list with cone shape.
     */
    List<ConeShape> parserDate (List<String> list);
}
