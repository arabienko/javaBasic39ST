package by.arabienko.service.parser;

import by.arabienko.creator.entity.CreatorConeShape;
import by.arabienko.creator.entity.CreatorShape;
import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;
import by.arabienko.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class returns list with cone shapes.
 */
public class ParseDateToObjects implements IParserDate {

    private static final Logger LOGGER = LogManager.getLogger(Validation.class);

    /**
     * @param list string.
     * @return list with cone objects.
     */
    @Override
    public List<ConeShape> parserDate(List<String> list) {
        List<ConeShape> shapes = new ArrayList<>();
        double dataX;
        double dataY;
        double dataZ;
        double dataRadius;
        double dataHigh;
        Validation validation = new Validation();
        for (String str : list) {
            String[] data = str.trim().split(" ");
            if (validation.lengthSix(data)) {
                String name = data[0];
                if (validation.isNumber(data[1],
                        data[2], data[3],
                        data[4], data[5])) {
                    dataX = Double.parseDouble(data[1]);
                    dataY = Double.parseDouble(data[2]);
                    dataZ = Double.parseDouble(data[3]);
                    dataRadius = Double.parseDouble(data[4]);
                    dataHigh = Double.parseDouble(data[5]);
                    if (validation.dataAboveZero(dataRadius, dataHigh)) {
                        CreatorShape creator = new CreatorConeShape();
                        Shape shape = creator.factoryMethod(name, dataX, dataY,
                                dataZ, dataHigh, dataRadius);
                        shapes.add((ConeShape) shape);
                    }
                }
            } else {
                LOGGER.debug("It is not possible to create a Cone object from a data line. Line - " + str);
            }
        }
        LOGGER.info("Parser and write to an object.");
        return shapes;
    }
}
