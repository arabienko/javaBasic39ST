package by.arabienko.entity;

import java.util.Objects;

public class TeacherSubject extends Entity {
    private int id;
    private Subject subject;
    private UserInfo userInfo;

    public TeacherSubject() {
    }

    private TeacherSubject(TeacherSubjectBuilder builder) {
        this.id = builder.teacherSubject.id;
        this.subject = builder.teacherSubject.subject;
        this.userInfo = builder.teacherSubject.userInfo;
    }

    public Subject getSubject() {
        return subject;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public String toString() {
        return "TeacherSubject{" +
                "ID= " + this.getId() +
                " subject= " + this.getSubject() +
                " user= " + this.getUserInfo() +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof TeacherSubject)) return false;
        TeacherSubject that = (TeacherSubject) o;
        return id==that.id &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(userInfo, that.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, userInfo);
    }

    public static class TeacherSubjectBuilder {
        TeacherSubject teacherSubject;

        public TeacherSubjectBuilder() {
            teacherSubject = new TeacherSubject();
        }

        public TeacherSubjectBuilder setSubject(Subject subject) {
            teacherSubject.subject = subject;
            return this;
        }

        public TeacherSubjectBuilder setUserInfo(UserInfo userInfo) {
            teacherSubject.userInfo = userInfo;
            return this;
        }

        //Return the finally consrcuted TeacherSubject object
        public TeacherSubject build() {
            return teacherSubject;
        }
    }
}
