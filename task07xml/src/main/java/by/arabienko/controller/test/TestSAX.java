package by.arabienko.controller.test;

import by.arabienko.service.xmlparser.SAX.StudentCoursesSAXBuilder;

public class TestSAX {
    public static void main(String[] args){
        StudentCoursesSAXBuilder saxBuilder = new StudentCoursesSAXBuilder();
        saxBuilder.buildStudentCurses("date/test1.xml");
        System.out.println(saxBuilder.getStudentCourses());
    }
}
