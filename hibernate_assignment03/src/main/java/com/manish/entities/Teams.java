package com.manish.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
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

	@OneToMany(mappedBy = "teamId",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Players> players = new ArrayList<Players>();

	public Teams(String abbreviation, String owner) {

		this.abbreviation = abbreviation;
		this.owner = owner;
	}

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

	public void addNewPlayer(Players player) {

		this.players.add(player);
		player.setTeamId(this);

	}

	public void removePlayer(Players player) {
		this.players.remove(player);
		player.setTeamId(null);
	}

}
