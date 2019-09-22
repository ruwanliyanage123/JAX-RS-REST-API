package services;

import connection.DatabaseConnection;
import models.Student;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentService {

    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    Connection connection = databaseConnection.getConnection();

    StudentService() throws SQLException {

    }

    /**
     * This method used to add a new student into database
     * @param student
     * @return
     */
    public Student addStudent(@NotNull Student student){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO classroom(studentId,studentName, studentAge) VALUES (?,?,?)"
            );
            preparedStatement.setString(1,student.getStudentId());
            preparedStatement.setString(2,student.getStudentName());
            preparedStatement.setInt(3,student.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * This method used for retrieve the all students
     * @param studentList
     * @return
     */
    public List<Student> getAllStudent(List<Student> studentList){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM classroom");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setStudentId(resultSet.getString(1));
                student.setStudentName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                studentList.add(student);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    /**
     * this method used to retrieve a student by giving the ID
     * @param studentId
     * @return
     */
    public Student getStudent(String studentId){
        Student student =null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM classroom WHERE sdudentId=?");
            preparedStatement.setString(1,studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getString(1));
                student.setStudentName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public void deleteStudent(String studentId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM classroom WHERE studentId=?");
            preparedStatement.setString(1,studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * this used for update the database table
     * @param student
     * @param studentId
     */
    public void updateStudent(@NotNull Student student, String studentId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE classroom SET  studentName=?,studentAge=? WHERE studentId=?");
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

























