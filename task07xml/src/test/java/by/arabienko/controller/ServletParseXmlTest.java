package by.arabienko.controller;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.testng.Assert.assertTrue;

public class ServletParseXmlTest extends Mockito {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //when(request.getParameter("currentPage")).thenReturn("1");
        //when(request.getParameter("password")).thenReturn("secret");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new ServletParseXml().doPost(request, response);
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("My expected string"));
    }
}