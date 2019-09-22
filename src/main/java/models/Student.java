package models;

public class Student {
    private String studentId;
    private String studentName;
    private int age;

    public Student(String studentId, String studentName, int age){
        this.studentId   = studentId;
        this.studentName = studentName;
        this.age         = age;
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
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
