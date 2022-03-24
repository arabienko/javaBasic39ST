package by.arabienko.controller;

import by.arabienko.entity.StudentCourse;
import by.arabienko.service.xmlparser.AbstractStudentCoursesBuilder;
import by.arabienko.service.xmlparser.StudentCoursesBuilderFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static by.arabienko.controller.Constants.*;


@WebServlet(urlPatterns = {"/my"})
@MultipartConfig(
        fileSizeThreshold = MEMORY_THRESHOLD,
        maxFileSize = MAX_FILE_SIZE,
        maxRequestSize = MAX_REQUEST_SIZE)
public class ServletParseXml extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER =
            LogManager.getLogger(ServletParseXml.class);

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.debug("Start servlet.");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf8");
        String filePath = "";
        String parse = null;
        DiskFileItemFactory factory =
                new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(
                System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload =
                new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        String uploadPath = getServletContext().
                getRealPath("")
                + UPLOAD_DIRECTORY;
        LOGGER.debug("Upload path is {}", uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        List<FileItem> formItems = null;

        try {
            formItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (formItems!=null && formItems.size() > 0) {
            for (FileItem item : formItems) {
                if (item.getFieldName().equals("selectParse")) {
                    parse = item.getString();
                    LOGGER.debug("Select method parse: {}", parse);
                }
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);
                    try {
                        item.write(storeFile);
                    } catch (Exception e) {
                        LOGGER.debug(
                                "Document is not selected.");
                    }
                }
            }
        }
        AbstractStudentCoursesBuilder builder =
                StudentCoursesBuilderFactory.
                        createStudentBuilder(parse);
        LOGGER.debug("Start parsing - {}", parse);
        builder.buildStudentCurses(filePath);
        Set<StudentCourse> set = builder.getStudentCourses();
        request.setAttribute("courseStudent", set);
        request.setAttribute("parse", parse);
        LOGGER.debug("The output of the parsing result - {}", parse);
        request.getRequestDispatcher("/jsp/outResult.jsp").
                forward(request, response);
    }
}