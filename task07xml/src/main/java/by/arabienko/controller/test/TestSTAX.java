package by.arabienko.controller.test;

import by.arabienko.service.xmlparser.StAX.StudentCourseStaxBuilder;

public class TestSTAX {
    public static void main(String[] args) {
        StudentCourseStaxBuilder staxBuilder = new StudentCourseStaxBuilder();
        staxBuilder.buildStudentCurses("date/curse.xml");
        System.out.println(staxBuilder.getStudentCourses());
    }
}
//src/main/resources/date/curse.xml