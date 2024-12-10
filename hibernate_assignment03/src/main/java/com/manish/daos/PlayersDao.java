package com.manish.daos;

import com.manish.entities.Players;

public interface PlayersDao {

	String addPlayer(Long teamId, Players player);

	String removePlayer(Long teamId, Long playerId);

}
