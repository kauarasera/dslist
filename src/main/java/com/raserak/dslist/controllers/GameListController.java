package com.raserak.dslist.controllers;

import com.raserak.dslist.dto.GameDTO;
import com.raserak.dslist.dto.GameListDTO;
import com.raserak.dslist.dto.GameMinDTO;
import com.raserak.dslist.services.GameListService;
import com.raserak.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
