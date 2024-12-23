package com.ipl.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class TeamsRespDTO {

	private String name;
	private String abbreviation;
	private String owner;
	private int maxPlayerAge;
	private double battingAvg;
	private int wicketsTaken;

}
