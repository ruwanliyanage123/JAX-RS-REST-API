package services;


import models.Student;

import javax.ws.rs.*;
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

    @GET
    @Path("student/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("param") String StudentId){
        return studentService.getStudent(StudentId);
    }

    @POST
    @Path("student/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student){
        studentService.addStudent(student);
        return student;
    }

    @DELETE
    @Path("student/delete/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(@PathParam("param") String studentId){
        studentService.deleteStudent(studentId);
    }

    @PUT
    @Path("student/update/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student, @PathParam("param")String studentId){
        studentService.updateStudent(student,studentId);
        return student;
    }
}













