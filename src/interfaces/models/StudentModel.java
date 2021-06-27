package interfaces.models;

public interface StudentModel {
    String getFIO();
    String getSurname();
    String getCurrentCity();
    Boolean isStudying();
    void setStudying(Boolean studying);
}
