package com.ipl.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = { "teamId" })
@EqualsAndHashCode(of = "title", callSuper = false)
public class Players extends BaseEntity {

	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;

	private LocalDate dob;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wickets_taken")
	private int wicketsTaken;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Teams teamId;

	public Players(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

}
