package com.csye6225.fall2018.courseservice2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.fall2018.courseservice2.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice2.datamodel.Student;

public class StudentService {
  static HashMap<Long, Student> stud_Map = InMemoryDatabase.getStudentDB();

  public StudentService() {

  }

  // GET "..webapi/students"
  public List<Student> getAllStudents() {
    ArrayList<Student> list = new ArrayList<>();
    for (Student stud : stud_Map.values()) {
      list.add(stud);
    }
    return list;
  }

  // Adding a student
  public void addStudent(Student student) {
    long nextAvailableId = stud_Map.size() + 1;
    stud_Map.put(nextAvailableId, student);
  }

  // Getting one student
  public Student getStudent(String studentID) {
    Student stud = stud_Map.get(Long.parseLong(studentID));
      System.out.println("Item retrieved:");
      System.out.println(stud.toString());
    return stud;   
  }

  // Deleting a student
  public Student deleteStudent(String studentID) {  
    return stud_Map.remove(Long.parseLong(studentID));
  } 

  // Updating student info
  public Student updateStudentInfo(String studentID, Student student) {
    student.setstudentId(studentID);
    stud_Map.put(Long.parseLong(studentID), student);
    return student;
  }

  // Get Students in a Program
  public List<Student> getStudentByProgram(String program) {
    ArrayList<Student> list = new ArrayList<>();
    for (Student stud : stud_Map.values()) {
      if(stud.getProgramName().equals(program)) {
        list.add(stud);
      }
    }
    return list;
  }
}