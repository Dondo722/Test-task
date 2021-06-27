package interfaces.controllers;

import interfaces.models.GroupModel;
import interfaces.models.StudentModel;
import javafx.util.Pair;
import java.util.List;

public interface ProfessorController {
    List<StudentModel> getStudentListInGroup(GroupModel group);
    List<Pair<StudentModel,GroupModel>> getStudentAndGroupsBySurname(String surname);
}
