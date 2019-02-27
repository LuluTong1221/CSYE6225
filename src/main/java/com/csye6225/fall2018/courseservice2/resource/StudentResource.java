package com.csye6225.fall2018.courseservice2.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice2.datamodel.Student;
import com.csye6225.fall2018.courseservice2.service.StudentService;

@Path("students")
public class StudentResource {
	StudentService studService = new StudentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		return studService.getAllStudents();
	}

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByProgram(@QueryParam("program") String program) {
		if (program == null) {
			return studService.getAllStudents();
		}
		return studService.getStudentByProgram(program);
	}

	// ... webapi/student/1
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("studentId") String studentId) {
		System.out.println("Student Resource: Looking for: " + studentId);
		return studService.getStudent(studentId);
	}

	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("studentId") String studentId) {
		return studService.deleteStudent(studentId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addStudent(Student student) {
		studService.addStudent(student);
	}

	@PUT
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("text/plain")
	public Student updateStudent(@PathParam("studentId") String studentId, Student student) {
		return studService.updateStudentInfo(studentId, student);
	}

}