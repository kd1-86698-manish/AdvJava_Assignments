package com.beans;

import java.util.ArrayList;
import java.util.List;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.entities.Candidate;

public class CandidateListBean {

	private List<Candidate> candList;

	public CandidateListBean() {

		this.candList = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}

	public void fetchCandidates() {

		try (CandidateDao canDao = new CandidateDaoImpl()) {

			this.candList = canDao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
