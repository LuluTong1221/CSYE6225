package com.csye6225.fall2018.courseservice2.datamodel;

import java.util.HashMap;

public class InMemoryDatabase {

	private static HashMap<Long, Professor> professorDB = new HashMap<> ();
	private static HashMap<Long, Student> studentDB = new HashMap<>();
	private static HashMap<Long, Program> programDB = new HashMap<>();
	private static HashMap<Long, Course> courseDB = new HashMap<>();

	public static HashMap<Long, Professor> getProfessorDB() {
		professorDB.put((long) 1, new Professor("a", "b", "c", "d", "e"));
		return professorDB;
	}

	public static HashMap<Long, Student> getStudentDB() {
		studentDB.put((long)1, new Student("a","b","c","f",null,"e"));
		return studentDB;
	}

	public static HashMap<Long, Program> getProgramDB() {
		programDB.put((long)1, new Program("IS", "IS"));
		return programDB;
	}

	public static HashMap<Long, Course> getCourseDB() {
		courseDB.put((long)1, new Course("a","b","c","f",null,null));
		return courseDB;
	}
}