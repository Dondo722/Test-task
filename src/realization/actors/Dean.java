package realization.actors;

import interfaces.controllers.DeanController;
import interfaces.models.GroupModel;
import interfaces.models.StudentModel;
import interfaces.models.UniversityModel;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Dean implements DeanController {
    private UniversityModel universityModel;

    public Dean(UniversityModel universityModel) {
        this.universityModel = universityModel;
    }

    @Override
    public void changeStudyingStatus(StudentModel student, Boolean status) {
        student.setStudying(status);
    }

    @Override
    public List<Pair<StudentModel, GroupModel>> getStudentsAndGroupsByCity(String city) {
        List<GroupModel> groups = universityModel.getAllGroups();
        List<Pair<StudentModel, GroupModel>> studentsCity = new ArrayList<>();
        for (GroupModel group : groups) {
            for (StudentModel student : group.getStudentList()) {
                if (student.getCurrentCity().equals(city))
                    studentsCity.add(new Pair<>(student, group));
            }
        }
        return studentsCity;
    }

    @Override
    public void moveStudentToGroup(StudentModel student, GroupModel previousGroup, GroupModel futureGroup) {
        previousGroup.getStudentList().remove(student);
        futureGroup.getStudentList().add(student);
    }
}
