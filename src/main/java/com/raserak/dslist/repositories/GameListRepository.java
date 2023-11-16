package com.raserak.dslist.repositories;

import com.raserak.dslist.entities.Game;
import com.raserak.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
