package com.beans;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.entities.Candidate;

public class FindCandidateBean {

	private int candId;
	private Candidate cand;

	public FindCandidateBean() {
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public Candidate getCand() {
		return cand;
	}

	public void setCand(Candidate cand) {
		this.cand = cand;
	}

	public void findCandidate() {

		try (CandidateDao candDao = new CandidateDaoImpl()) {
			this.cand = candDao.findBYId(candId);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

}
