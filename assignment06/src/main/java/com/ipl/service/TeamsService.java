package com.ipl.service;

import java.util.List;

import com.ipl.dto.ApiResponse;
import com.ipl.dto.TeamsReqDTO;
import com.ipl.dto.TeamsRespDTO;
import com.ipl.pojos.Teams;

public interface TeamsService {

	List<TeamsRespDTO> getAllTeams();

	ApiResponse addNewTeam(TeamsReqDTO team);

	TeamsRespDTO getTeamDetails(Long teamId);

	ApiResponse updateTeam(Long teamId, Teams team);

	ApiResponse deleteTeam(Long teamId);
}
