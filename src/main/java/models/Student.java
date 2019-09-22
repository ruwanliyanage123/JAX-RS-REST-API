package models;

public class Student {
    private String studentId;
    private String studentName;
    private int    studentAge;

    public Student(String studentId, String studentName, int studentAge){
        this.studentId   = studentId;
        this.studentName = studentName;
        this.studentAge  = studentAge;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return studentAge;
    }

    public void setAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
