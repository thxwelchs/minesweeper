package minesweeper.service;

public interface LandRenderer {
    static final char MINE_FLAG = '-';
    void render(boolean mineFlagMode);
}
