package com.davidout.api.minecraft.minigame;

import java.util.UUID;

public abstract class Game implements IGame {

    private final GameDetails details;
    private GameState gameState;

    public Game() {
        this.details = new GameDetails();
        this.gameState = GameState.LOBBY;
    }

    public void setGameState(GameState newGameState) {
        this.gameState = newGameState;
        this.toNextGameState();
    }

    private void toNextGameState() {
        switch (gameState) {
            case LOBBY:
                handleLobbyState();
                break;
            case STARTING:
                handleStartingState();
                break;
            case STARTED:
                handleStartedState();
                break;
            case STOPPING:
                handleStoppingState();
                break;
            case STOPPED:
                handleStoppedState();
                break;
        }
    }


    public GameState getGameState() {
        return this.gameState;
    }

    public GameDetails getGameDetails() {
        return details;
    }
}
