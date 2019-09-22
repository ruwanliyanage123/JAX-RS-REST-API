package services;

import connection.DatabaseConnection;
import models.Student;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}

























