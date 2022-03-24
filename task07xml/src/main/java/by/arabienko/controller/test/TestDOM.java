package by.arabienko.controller.test;

import by.arabienko.service.xmlparser.DOM.StudentCourseDomBuilder;

public class TestDOM {
    public static void main(String[] args) {
        StudentCourseDomBuilder domBuilder = new StudentCourseDomBuilder();
        domBuilder.buildStudentCurses("src/main/resources/date/curse.xml");
        System.out.println(domBuilder.getStudentCourses());
    }
}
