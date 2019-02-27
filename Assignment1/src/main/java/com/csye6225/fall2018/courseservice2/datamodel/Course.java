package com.csye6225.fall2018.courseservice2.datamodel;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Course {
  private String courseId;
  private String name;
  private String professorId;
  private String taStudentId;
  private ArrayList<String> enrolledStudents;
  private ArrayList<String> lectures;

  public Course() {
  }

  public Course(String courseId, String name, String professorId, String taStudentId, ArrayList<String> enrolledStudents, 
      ArrayList<String> lectures) {
    this.courseId = courseId;
    this.name = name;
    this.professorId = professorId;
    this.taStudentId = taStudentId;
    this.enrolledStudents = enrolledStudents;
    this.lectures = lectures;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }
  
  public String getCourseId() {
	  return this.courseId;
  }
  
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProfessorId() {
    return this.professorId;
  }

  public void setProfessor(String professorId) {
    this.professorId = professorId;
  }

  public String getTAId() {
    return this.taStudentId;
  }

  public void settaStudentId(String taStudentId) {
    this.taStudentId = taStudentId;
  }

  public void addStudent(String studentId) {
    this.enrolledStudents.add(studentId);
  }

  public String removeStudent(String studentId) {
    this.enrolledStudents.remove(studentId);
    return studentId;
  }
  
  public void addLecture(String lecture) {
    this.lectures.add(lecture);
  }

  public String removeLecture(String lecture) {
    this.lectures.remove(lecture);
    return lecture;
  }
}