package interfaces.models;

import java.util.LinkedList;
import java.util.List;

public interface GroupModel {
    Boolean isSurnameFree(String studentSurname);
    String getGroupName();
    Integer getCourseNumber();
    List<StudentModel> getStudentList();
    LinkedList<GroupModel> getGroupsOfOneCourse();
    void addStudent(StudentModel student);
}
