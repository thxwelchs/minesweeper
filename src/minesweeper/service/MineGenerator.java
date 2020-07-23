package minesweeper.service;

import minesweeper.domain.Mine;

public interface MineGenerator<T extends Mine> {

    T[] generateMines(int mineCount);

    void layMines(int[][] table, T[] mines);

    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
