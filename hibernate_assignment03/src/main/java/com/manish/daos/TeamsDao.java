package com.manish.daos;

import java.util.List;

import com.manish.entities.*;

;

public interface TeamsDao {

	// add method to register new team
	String addUpTeam(Teams team);

	List<Teams> getAllTeams();

	List<Teams> getAllSelectedTeam(int age, double avg);

	List<Teams> displayOwnerNameAndAbbreviations(int age, double avg);

	String deleteTeamDetails(Long teamId);

	String updateMaxPlayerAge(String tName ,int mAge);

	Teams getTeamAndPlayers(Long teamId);
}
