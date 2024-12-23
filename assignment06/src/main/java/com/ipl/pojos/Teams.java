package com.ipl.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "player")
public class Teams extends BaseEntity {

	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 10, unique = true)
	private String abbreviation;

	@Column(length = 20, nullable = false)
	private String owner;

	@Column(name = "max_player_age")
	private int maxPlayerAge;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wickets_taken")
	private int wicketsTaken;

	@OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Players> player = new ArrayList<>();

	public Teams(String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,
			int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

}
