package interfaces.models;

import java.util.LinkedList;

public interface UniversityModel {
    LinkedList<GroupModel> getAllGroups() ;
    LinkedList<GroupModel> getCourseGroups(Integer course) throws Exception;
}
