package com.raserak.dslist.services;

import com.raserak.dslist.dto.GameListDTO;
import com.raserak.dslist.entities.GameList;
import com.raserak.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    //passando id da lista, posição de origem e a posição de destino com esses argumentos consigo atualizar minha lista
    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        //1-Buscar na memoria a minha lista.
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        //2- Removendo objeto da lista.
        GameMinProjection obj = list.remove(sourceIndex);
        //3- add objeto na posição de destino
        list.add(destinationIndex, obj);

        //3- min e max de sourceIndex de destinationIndex
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        //reposicionando game
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
