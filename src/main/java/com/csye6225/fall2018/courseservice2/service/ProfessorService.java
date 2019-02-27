package com.csye6225.fall2018.courseservice2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.csye6225.fall2018.courseservice2.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice2.datamodel.Professor;

public class ProfessorService {
	
	static HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();
	
	public ProfessorService() {
	}
	
	// Getting a list of all professor 
	// GET "..webapi/professors"
	public List<Professor> getAllProfessors() {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			list.add(prof);
		}
		return list ;
	}

	// Adding a professor
	public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
		// Next Id 
		long nextAvailableId = prof_Map.size() + 1;
		
		//Create a Professor Object
		Professor prof = new Professor(firstName+lastName, firstName , lastName, 
				department, joiningDate.toString());
		
		prof.setProfessorId(Long.toString(nextAvailableId));
		
		prof_Map.put(nextAvailableId, prof);
	}

	// Adding a professor
	public void addProfessor(Professor prof) {
		long nextAvailableId = prof_Map.size() + 1;
		prof_Map.put(nextAvailableId, prof);
	}
	
	
	// Getting One Professor
	public Professor getProfessor(String profId) {	
		 //Simple HashKey Load
		 Professor prof2 = prof_Map.get(Long.parseLong(profId));
	     System.out.println("Item retrieved:");
	     System.out.println(prof2.toString());
		
		return prof2;
	}
	
	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		Professor deletedProfDetails = prof_Map.get(Long.parseLong(profId));
		prof_Map.remove(Long.parseLong(profId));
		return deletedProfDetails;
	}
	
	// Updating Professor Info
	public void updateProfessorInformation(String profId, Professor prof) {	
		prof_Map.put(Long.parseLong(profId), prof);
	}
	
	// Get professors in a department 
	public List<Professor> getProfessorsByDepartment(String department) {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			if (prof.getDepartment().equals(department)) {
				list.add(prof);
			}
		}
		return list ;
	}
	
	// Get professors for a year with a size limit
	
}