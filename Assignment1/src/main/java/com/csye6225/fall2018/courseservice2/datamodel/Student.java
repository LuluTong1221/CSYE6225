package com.csye6225.fall2018.courseservice2.datamodel;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;


@XmlRootElement
public class Student {
  private String firstName;
  private String lastName;
  private String studentId;
  private String image;
  private ArrayList<String> enrolledCourseIDs;
  private String programName;

  public Student() {

  }

  public Student(String firstName, String lastName, String studentId, String image, ArrayList<String> enrolledCourseIDs,
                String programName) {
    this.enrolledCourseIDs = enrolledCourseIDs;
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentId = studentId;
    this.image = image;
    this.programName = programName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getstudentId() {
    return this.studentId;
  }

  public void setstudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getProgramName() {
    return this.programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public String getStudentImage() {
    return this.image;
  }

  public void setStudentImage(String image) {
    this.image = image;
  }

  public ArrayList<String> getEnrolledCourseIDs() {
    return this.enrolledCourseIDs;
  }

  public void addEnrolledCourses(Long courseId) {
    this.enrolledCourseIDs.add(Long.toString(courseId));
  }

  @Override
  public String toString() {
    return "studentId=" + getstudentId() + ", firstName=" + getFirstName() + ", lastname=" + getLastName() + 
    ",program=" + getProgramName();
  }

}