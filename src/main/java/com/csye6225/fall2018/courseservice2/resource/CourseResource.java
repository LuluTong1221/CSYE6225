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
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice2.service.CourseService;
import com.csye6225.fall2018.courseservice2.datamodel.Course;

//../webapi/courses
@Path("courses")
public class CourseResource {
  CourseService courService = new CourseService();

  @GET //.../webapi/courses
  @Produces(MediaType.APPLICATION_JSON)
  public List<Course> getCourses() {
    return courService.getAllCourses();
  }

  @GET // ...webapi/courses/{courseid}
  @Path("/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  public Course getOneCourse(@PathParam("courseid") String courseId) {
    System.out.println("Course Resource: Looking for: " + courseId);
    return courService.getOneCourse(courseId);
  }

  @POST 
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes("text/plain")
  public void addCourse(String name) {
    courService.addCourse(name);
  }

  @PUT
  @Path("/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void updateCourse(@PathParam("courseid") String courId, Course cour) {
    courService.updateCourseInformation(courId, cour);
  }

  @DELETE
  @Path("/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  public Course deleteCourse(@PathParam("courseid") String courseId) {
    return courService.deleteCourse(courseId);
  }
}
