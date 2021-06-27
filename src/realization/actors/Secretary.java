package realization.actors;

import interfaces.models.GroupModel;
import interfaces.controllers.SecretaryController;
import interfaces.models.StudentModel;
import interfaces.models.UniversityModel;
import realization.Group;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Secretary implements SecretaryController {
    private UniversityModel universityModel;

    public Secretary(UniversityModel universityModel) {
        this.universityModel = universityModel;
    }

    @Override
    public GroupModel createGroup(String name, Integer course, List<StudentModel> students, LinkedList<GroupModel> courseGroups) {
        GroupModel group = new Group(name,course,students,courseGroups);
        universityModel.getAllGroups().add(group);
        return group;
    }

    @Override
    public void removeGroup(GroupModel group) {
        List<StudentModel> studentList = group.getStudentList();
        for (StudentModel student : studentList) {
            student.setStudying(false);
            studentList.remove(student);
        }
        universityModel.getAllGroups().remove(group);
    }

    @Override
    public List<StudentModel> getStudentListInGroup(GroupModel group) {
        return group.getStudentList();
    }

    @Override
    public List<StudentModel> getStudentListInCourse(Integer course) {
        List<StudentModel> groupsStudents = new ArrayList<>();
        try {
            List<GroupModel> groups = universityModel.getCourseGroups(course);
            for (GroupModel group : groups) {
                groupsStudents.addAll(group.getStudentList());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return groupsStudents;
    }

    @Override
    public void addStudentToGroup(GroupModel group, StudentModel student) {
        group.addStudent(student);
    }
}
