package com.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.dto.ApiResponse;
import com.ipl.dto.TeamsReqDTO;
import com.ipl.dto.TeamsRespDTO;
import com.ipl.pojos.Teams;
import com.ipl.service.TeamsService;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

	@Autowired
	private TeamsService teamService;

	public TeamController() {
		System.out.println("in ctor" + getClass());
	}

	@GetMapping
	public ResponseEntity<?> getTeams() {
		System.out.println("get all");
		List<TeamsRespDTO> team = teamService.getAllTeams();
		if (team.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(team);
	}

	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody TeamsReqDTO team) {
		System.out.println("in add team" + team);// transient category
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addNewTeam(team));
	}

	@GetMapping("/{teamId}")
	public ResponseEntity<?> getTeamDetails(@PathVariable Long teamId) {

		System.out.println("in get team details" + teamId);

		try {

			TeamsRespDTO team = teamService.getTeamDetails(teamId);

			return ResponseEntity.ok(team);

		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}

	@PutMapping("/{teamId}")
	public ResponseEntity<?> updateteamDetails(@PathVariable Long teamId, @RequestBody Teams team) {

		return ResponseEntity.ok(teamService.updateTeam(teamId, team));
	}

	@DeleteMapping
	public ResponseEntity<?> deleteTeamDetails(@RequestParam() Long teamId) {
		System.out.println("in delete " + teamId);
		try {
			// invoke service layer method
			return ResponseEntity.ok(teamService.deleteTeam(teamId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
