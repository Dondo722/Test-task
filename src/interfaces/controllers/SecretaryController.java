package interfaces.controllers;

import interfaces.models.GroupModel;
import interfaces.models.StudentModel;

import java.util.LinkedList;
import java.util.List;

public interface SecretaryController {
    GroupModel createGroup(String name, Integer course, List<StudentModel> students, LinkedList<GroupModel> courseGroups);
    void removeGroup(GroupModel group);
    List<StudentModel> getStudentListInGroup(GroupModel group);
    List<StudentModel> getStudentListInCourse(Integer course);
    void addStudentToGroup(GroupModel group, StudentModel student);
}
