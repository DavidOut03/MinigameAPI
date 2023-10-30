package com.davidout.api.minecraft.minigame;

public interface IGame {

    void setGameState(GameState newGameState);
    void handleLobbyState();
    void handleStartingState();
    void handleStartedState();
    void handleStoppingState();
    void handleStoppedState();
}
