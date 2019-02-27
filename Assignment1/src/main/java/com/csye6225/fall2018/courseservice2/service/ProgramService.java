package com.csye6225.fall2018.courseservice2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.fall2018.courseservice2.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice2.datamodel.Program;

public class ProgramService {
  static HashMap<Long, Program> program_Map = InMemoryDatabase.getProgramDB();

  public ProgramService() {

  }

  // Getting a list of all program
  // GET "..webapi/programs"
  public List<Program> getAllPrograms() {
    // Getting the list
    ArrayList<Program> list = new ArrayList<>();
    for (Program program : program_Map.values()) {
      list.add(program);
    }
    return list;
  }

  // GET "..webapi/programs?id=programId"
  // "..webapi/programs/1"
  public Program getOneProgram(String programId) {
    return program_Map.get(Long.parseLong(programId));
  }

  // Adding a program
  // POST "../webapi/programs"
  public void addProgram(String name) {
    long nextAvailableId = program_Map.size() + 1;
    String programId = Long.toString(nextAvailableId);
    Program newProgram = new Program(name, programId);  
    program_Map.put(nextAvailableId, newProgram);
  }

   // GET "..webapi/programs/{program}/courses"
  public ArrayList<String> getAllCourseIDsByProgram(String programId) {
     Program program = getOneProgram(programId);
     return program.getCourseIDsByProgram();
  }

  // Adding a course to a specific program
  // POST "..webapi/programs/{programId}/courses"
  public void addCourseToProgram(String programId, String courseId) {
    Program program = program_Map.get(Long.parseLong(programId));
    program.addCourse(courseId);
  }

  // Delete a course from a specific program
  // DELETE "..webapi/programs/{programId}/courses/{courseId}"
  public void deleteCourseFromProgram(String programId, String courseId) {
    Program program = program_Map.get(Long.parseLong(programId));
    ArrayList<String> courses = program.getCourseIDsByProgram();
    courses.remove(courseId);
  }
}