package realization;

import interfaces.models.GroupModel;
import interfaces.models.StudentModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Group implements GroupModel {
    private String name;
    private Integer courseNumber;
    private List<StudentModel> students;
    private LinkedList<GroupModel> courseGroups;


    public Group(String name, Integer courseNumber) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.students = new ArrayList<>();
        this.courseGroups = new LinkedList<>();
    }

    public Group(String name, Integer courseNumber, List<StudentModel> students, LinkedList<GroupModel> courseGroups) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.students = students;
        for (StudentModel student : students)
            student.setStudying(true);

        this.courseGroups = courseGroups;
        courseGroups.add(this);
    }


    @Override
    public Boolean isSurnameFree(String studentSurname) {
        for (StudentModel student : students){
            if (student.getSurname().equals(studentSurname))
                return true;
        }
        return false;
    }

    @Override
    public String getGroupName() {
        return name;
    }

    @Override
    public Integer getCourseNumber() {
        return courseNumber;
    }

    @Override
    public synchronized List<StudentModel> getStudentList() {
        return students;
    }

    @Override
    public synchronized LinkedList<GroupModel> getGroupsOfOneCourse() {
        return courseGroups;
    }

    @Override
    public void addStudent(StudentModel student) {
        if (isSurnameFree(student.getSurname()))
            students.add(student);
        student.setStudying(true);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public void setGroupsOfOneCourse(LinkedList<GroupModel> groupsOfOneCourse) {
        this.courseGroups = groupsOfOneCourse;
    }
}
