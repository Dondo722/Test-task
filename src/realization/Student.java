package realization;

import interfaces.models.StudentModel;

public class Student implements StudentModel {
    private String name;
    private String surname;
    private String patronymic;
    private String currentCity;
    private Boolean isStudying;


    public Student(String name, String surname, String patronymic, String currentCity, Boolean isStudying) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.currentCity = currentCity;
        this.isStudying = isStudying;
    }

    @Override
    public String getFIO() {
        return name + surname + patronymic;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getCurrentCity() {
        return currentCity;
    }

    @Override
    public Boolean isStudying() {
        return isStudying;
    }

    @Override
    public synchronized void setStudying(Boolean studying) {
        isStudying = studying;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setFIO(String name,String surname,String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

}
