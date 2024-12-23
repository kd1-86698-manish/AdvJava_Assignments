package com.ipl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.pojos.Teams;

public interface TeamsDao extends JpaRepository<Teams, Long> {

}
