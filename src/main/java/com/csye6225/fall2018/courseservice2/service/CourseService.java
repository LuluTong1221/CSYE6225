package com.csye6225.fall2018.courseservice2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.fall2018.courseservice2.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice2.datamodel.Course;

public class CourseService {
  
  static HashMap<Long, Course> cour_Map = InMemoryDatabase.getCourseDB();

  public CourseService() {

  }

  // Getting a list of all courses
  // GET "..webapi/courses"
  public List<Course> getAllCourses() {
    ArrayList<Course> list = new ArrayList<>();
    for(Course course : cour_Map.values()){
      list.add(course);
    } 
    return list;
  }

  // "...webapi/courses/{courseid}"
  public Course getOneCourse(String courseId) {
    return cour_Map.get(Long.parseLong(courseId));
  }

  // Adding a course
  // POST "..webapi/courses"
  public void addCourse(String name) {
    ArrayList<String> enrolledStudents = new ArrayList<>();
    ArrayList<String> lectures = new ArrayList<>();
    long nextAvailabeId = cour_Map.size() + 1;
    String courseId = Long.toString(nextAvailabeId);
    Course newCourse = new Course(courseId, name, null, null, enrolledStudents, lectures);
    cour_Map.put(nextAvailabeId, newCourse);
  }

  // Adding a course
  // POST "..webapi/courses"
  public void addCourse(String name, String professorId, String taStudentId, ArrayList<String> enrolledStudents,
      ArrayList<String> lectures) {
    long nextAvailabeId = cour_Map.size() + 1;
    String courseId = Long.toString(nextAvailabeId);
    Course newCourse = new Course(courseId, name, professorId, taStudentId, enrolledStudents, lectures);
    cour_Map.put(nextAvailabeId, newCourse);
  }

  // Updating Course Info
  public void updateCourseInformation(String courseId, Course course) {
    cour_Map.put(Long.parseLong(courseId), course);
  }

  // Delete a course from courses
  // DELETE "..webapi/courses/{courseId}"
  public Course deleteCourse(String courseId) {
    return cour_Map.remove(Long.parseLong(courseId));
  }
}