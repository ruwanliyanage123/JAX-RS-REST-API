package services;


import models.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("school")
@Produces(MediaType.APPLICATION_JSON)
public class ApiCalls {

    public StudentService studentService;

    public ApiCalls(){
        try {
            studentService = new StudentService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudent(){
        List<Student> studentList = new ArrayList<>();
        studentService.getAllStudent(studentList);
        for (int i=0; i<studentList.size(); i++){
            System.out.println(studentList.get(i).getStudentName());
        }
        return studentList;
    }
}
