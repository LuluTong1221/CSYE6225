package com.csye6225.fall2018.courseservice2.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice2.datamodel.Professor;
import com.csye6225.fall2018.courseservice2.service.ProfessorService;

// .. /webapi/professors
@Path("professors")
public class ProfessorResource {

	ProfessorService profService = new ProfessorService();

	@GET // .. /webapi/professors
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessors() {
		return profService.getAllProfessors();
	}	
	
	@GET 	// .. /webapi/professors/query?department=IS 
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessorsByDeparment(@QueryParam("department") String department) {	
		if (department == null) {
			return profService.getAllProfessors();
		}
		return profService.getProfessorsByDepartment(department);
	}
	
	@GET // ... webapi/professors/{1} 
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getOneProfessor(@PathParam("professorId") String profId) {
		System.out.println("Professor Resource: Looking for: " + profId);
		return profService.getProfessor(profId);
	}
	
	@DELETE
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor deleteProfessor(@PathParam("professorId") String profId) {
		return profService.deleteProfessor(profId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProfessor(Professor prof) {
			prof.setProfessorId(prof.getFirstName()+prof.getLastName());
			prof.setJoiningDate(new Date().toString());
			//prof.setId(prof.getProfessorId());
			profService.addProfessor(prof);
	}
	
	@PUT
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateProfessor(@PathParam("professorId") String profId, 
			Professor prof) {
		profService.updateProfessorInformation(profId, prof);
	}
 }