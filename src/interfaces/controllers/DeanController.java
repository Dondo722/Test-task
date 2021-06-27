package interfaces.controllers;

import interfaces.models.GroupModel;
import interfaces.models.StudentModel;
import javafx.util.Pair;
import java.util.List;

public interface DeanController {
    void changeStudyingStatus(StudentModel student, Boolean status);
    List<Pair<StudentModel, GroupModel>> getStudentsAndGroupsByCity(String city);
    void moveStudentToGroup(StudentModel student,GroupModel previousGroup,GroupModel futureGroup);
}
