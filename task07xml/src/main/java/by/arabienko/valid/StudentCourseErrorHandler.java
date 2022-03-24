package by.arabienko.valid;


import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class StudentCourseErrorHandler extends DefaultHandler {
    private Logger LOGGER =
            Logger.getLogger("by.arabienko.valid");

    public StudentCourseErrorHandler(String logErr) throws IOException {
        LOGGER.addAppender(
                (Appender) new FileAppender(new SimpleLayout(),logErr));
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        LOGGER.warn(getLineAddress(e)+"-"+e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber()+" : "+ e.getColumnNumber();
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        LOGGER.error(getLineAddress(e)+"-"+e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        LOGGER.fatal(getLineAddress(e)+"-"+e.getMessage());
    }
}
