package com.csye6225.fall2018.courseservice2.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice2.datamodel.Program;
import com.csye6225.fall2018.courseservice2.service.ProgramService;

//../webapi/programs
@Path("programs")
public class ProgramResource {
  ProgramService programService = new ProgramService();

  @GET // ../webapi/programs
  @Produces(MediaType.APPLICATION_JSON)
  public List<Program> getAllPrograms() {
    return programService.getAllPrograms();
  }

  @GET //../webapi/programs/{programId}
  @Path("/{programId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Program getOneProgram(@PathParam("programId") String programId) {
    return programService.getOneProgram(programId);
  }

  @POST // ../webapi/programs
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes("text/plain")
  public void addProgram(String name) {
    programService.addProgram(name);
  }

  @GET // "..webapi/programs/{programId}/courses"
  @Path("/{programId}/courses")
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<String> getAllCourseIDsByProgram(@PathParam("programId") String programId) {
    return programService.getAllCourseIDsByProgram(programId);
  }

  @POST 
  @Path("/{programId}/courses")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes("text/plain")
  public void addCourseToProgram(@PathParam("programId") String programId, String courseId) {
    programService.addCourseToProgram(programId, courseId);
  }

  @DELETE
  @Path("/{programId}/courses/{courseId}")
  @Produces(MediaType.APPLICATION_JSON)
  public void deleteCourseFromProgram(@PathParam("programId") String programId, @PathParam("courseId") String courseId) {
    programService.deleteCourseFromProgram(programId, courseId);
  }
}