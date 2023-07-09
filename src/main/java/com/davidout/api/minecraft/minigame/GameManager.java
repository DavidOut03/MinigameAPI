package com.davidout.api.minecraft.minigame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GameManager {

    private static final List<Game> gameList = new ArrayList<>();

    public static void startNewGame(Game game) {
        gameList.add(game);
    }

    public static void stopGame(Game game) {
        game.setGameState(GameState.STOPPING);
    }

    public static Game getGame(UUID uuid) {
        Optional<Game> returned = gameList.stream().filter(game -> game.getGameDetails().getGameId().equals(uuid)).findFirst();
       return returned.orElse(null);
    }



}
