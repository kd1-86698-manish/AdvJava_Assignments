package com.entities;

public class Candidate {

	private int id;
	private String name;
	private String Party;
	private int votes;

	public Candidate() {
	}

	public Candidate(int id, String name, String party, int votes) {
		this.id = id;
		this.name = name;
		Party = party;
		this.votes = votes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return Party;
	}

	public void setParty(String party) {
		Party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", Party=" + Party + ", votes=" + votes + "]";
	}

}
