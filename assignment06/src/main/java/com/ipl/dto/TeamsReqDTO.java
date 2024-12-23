package com.ipl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamsReqDTO {

	private String name;

	private String abbreviation;

	private String owner;

	private int maxPlayerAge;

	private double battingAvg;

	private int wicketsTaken;

}
