package com.beans;

import java.util.ArrayList;
import java.util.List;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.entities.Candidate;

public class ResultBean {

	List<Candidate> candList;

	public ResultBean() {

		this.candList = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}

	public void fetchCandidate() {

		try (CandidateDao candDao = new CandidateDaoImpl()) {

			this.candList = candDao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
