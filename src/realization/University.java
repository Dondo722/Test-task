package realization;

import interfaces.models.GroupModel;
import interfaces.models.UniversityModel;

import java.util.LinkedList;

public class University implements UniversityModel {
    private LinkedList<GroupModel> allGroups;

    public University() {
        this.allGroups = new LinkedList<>();
    }
    public University(LinkedList<GroupModel> allGroups) {
        this.allGroups = allGroups;
    }

    @Override
    public synchronized LinkedList<GroupModel> getAllGroups()  {
        return allGroups;
    }

    @Override
    public synchronized LinkedList<GroupModel> getCourseGroups(Integer course) throws Exception  {
        for (GroupModel group : allGroups) {
            if (group.getCourseNumber().equals(course))
                return group.getGroupsOfOneCourse();
        }
        throw new Exception("Course not found!");
    }

}
