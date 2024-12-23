package com.ipl.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.dao.TeamsDao;
import com.ipl.dto.ApiResponse;
import com.ipl.dto.TeamsReqDTO;
import com.ipl.dto.TeamsRespDTO;
import com.ipl.exception.ResourceNotFoundException;
import com.ipl.pojos.Teams;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamServiceImpl implements TeamsService {

	@Autowired
	private TeamsDao teamDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TeamsRespDTO> getAllTeams() {
		return teamDao.findAll().stream().map(team -> modelMapper.map(team, TeamsRespDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse addNewTeam(TeamsReqDTO dto) {

		Teams teamEntity = modelMapper.map(dto, Teams.class);
		Teams persistentTeam = teamDao.save(teamEntity);

		return new ApiResponse("Added new team with ID : " + persistentTeam.getId());
	}

	@Override
	public TeamsRespDTO getTeamDetails(Long teamId) {
		
		Teams teamEntity = teamDao.findById(teamId).orElseThrow(()->new ResourceNotFoundException("Invalid Team Id.."));
		
		return modelMapper.map(teamEntity, TeamsRespDTO.class);
	}

	@Override
	public ApiResponse updateTeam(Long teamId, Teams team) {
		if (teamDao.existsById(teamId)) {

			teamDao.save(team);

			return new ApiResponse("Team Updated");
		}
		return new ApiResponse("Invalid TeamId...!");
	}

	@Override
	public ApiResponse deleteTeam(Long teamId) {

		if (teamDao.existsById(teamId)) {
			teamDao.deleteById(teamId);
			return new ApiResponse("Deleted Succesfully");
		}

		throw new ResourceNotFoundException("Invalid Team Id ....");
	}

}
