package com.raserak.dslist.controllers;

import com.raserak.dslist.dto.GameListDTO;
import com.raserak.dslist.dto.GameMinDTO;
import com.raserak.dslist.dto.ReplacementDTO;
import com.raserak.dslist.services.GameListService;
import com.raserak.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games") //concatenando o /lists/ id da lista/ e os games
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    //Metodo criado para receber o corpo da requisição do reposicionamento
    @PostMapping(value = "/{listId}/replacement")
    public void move(
            @PathVariable Long listId,
            @RequestBody ReplacementDTO body
    ) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
