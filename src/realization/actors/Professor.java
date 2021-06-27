package realization.actors;

import interfaces.models.GroupModel;
import interfaces.controllers.ProfessorController;
import interfaces.models.StudentModel;
import interfaces.models.UniversityModel;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Professor implements ProfessorController {
    private UniversityModel universityModel;

    public Professor(UniversityModel universityModel) {
        this.universityModel = universityModel;
    }

    @Override
    public List<StudentModel> getStudentListInGroup(GroupModel group) {
        return  group.getStudentList();
    }

    @Override
    public List<Pair<StudentModel, GroupModel>> getStudentAndGroupsBySurname(String surname) {
        List<Pair<StudentModel, GroupModel>> foundedStudents = new ArrayList<>();
        StudentModel tempStudent;
        for (GroupModel group : universityModel.getAllGroups()){
            if(group.isSurnameFree(surname))
                continue;

            getStudentListInGroup(group);
            try{
                tempStudent = getStudentBySurname(group.getStudentList(),surname);
                foundedStudents.add(new Pair<>(tempStudent,group));
            }
            catch (Exception ex){
                return foundedStudents;
            }
        }
        return foundedStudents;
    }

    private StudentModel getStudentBySurname(List<StudentModel> groupStudents,String surname) throws  Exception{
            for (StudentModel student : groupStudents) {
                if (student.getSurname().equals(surname))
                    return student;
            }
            throw new Exception("Student's not Founded");
    }
}
