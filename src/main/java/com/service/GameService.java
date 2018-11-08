package com.service;

import com.dao.GameDao;
import com.dao.UserDao;
import com.entity.Game;

import java.util.List;

public class GameService {
    public List gameList() {
        return new GameDao().gameList();
    }

    public List gameList(int page) {
        return new GameDao().gameList(page);
    }

    public int addGame(Game game) {
//        if (findGameByName(game.getName()) > 0)
//            return 202;
//        else
            return new GameDao().addGame(game);
    }

//    public int findGameByName(String name) {
//        return new GameDao().findGameByName(name);
//    }

}
