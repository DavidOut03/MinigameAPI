package com.davidout.api.minecraft.minigame;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GameManager<T extends Game> {

    private final List<T> gameList = new ArrayList<>();

    public void startNewGame(T game) {
        gameList.add(game);
    }

    public void stopGame(T game) {
        game.setGameState(GameState.STOPPING);
    }

    public T getGame(UUID uuid) {
       return gameList.stream().filter(game -> game.getGameDetails().getGameId().equals(uuid)).findFirst().orElse(null);
    }

    public List<T> getGames() {return gameList;}

    public T getPlayerGame(Player player) {
        return gameList.stream().filter(game -> game.getGameDetails().getPlayersAndSpectators().contains(player)).findFirst().orElse(null);
    }

    public boolean playerIsInGame(Player p) {
        return gameList.stream().anyMatch(game -> game.getGameDetails().getPlayersAndSpectators().contains(p));
    }

}
