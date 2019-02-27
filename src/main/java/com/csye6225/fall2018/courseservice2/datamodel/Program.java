package com.csye6225.fall2018.courseservice2.datamodel;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;


@XmlRootElement
public class Program {
  private ArrayList<String> courseIDs;
  private String programName;
  private String programId;

  public Program() {
  }

  public Program(String programName, String programId) {
    this.programName = programName;
    this.programId = programId;
    this.courseIDs = new ArrayList<>();
  }

  public String getProgramId() {
    return this.programId;
  }

  public void setProgramId(String programId) {
    this.programId = programId;
  }

  public ArrayList<String> getCourseIDsByProgram() {
    return this.courseIDs;
  }

  public String getProgramName() {
    return this.programName;
  }

  public void addCourse(String courseID){
    this.courseIDs.add(courseID);
  }
}