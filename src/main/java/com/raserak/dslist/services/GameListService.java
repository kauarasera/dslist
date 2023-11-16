package com.raserak.dslist.services;

import com.raserak.dslist.dto.GameDTO;
import com.raserak.dslist.dto.GameListDTO;
import com.raserak.dslist.dto.GameMinDTO;
import com.raserak.dslist.entities.Game;
import com.raserak.dslist.entities.GameList;
import com.raserak.dslist.repositories.GameListRepository;
import com.raserak.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
