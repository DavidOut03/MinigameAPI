package com.davidout.api.minecraft.minigame;

import java.util.UUID;

public abstract class Game {

    private final GameDetails details;
    private GameState gameState;

    public Game() {
        this.details = new GameDetails();
        this.gameState = GameState.LOBBY;
    }

    public void setGameState(GameState newGameState) {
        this.gameState = newGameState;
        this.handleGameState();
    }

    private void handleGameState() {
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

    public abstract void handleLobbyState();
    public abstract void handleStartingState();
    public abstract void handleStartedState();
    public abstract void handleStoppingState();
    public abstract void handleStoppedState();



    public GameState getGameState() {
        return this.gameState;
    }

    public GameDetails getGameDetails() {
        return details;
    }
}
