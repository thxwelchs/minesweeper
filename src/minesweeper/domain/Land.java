package minesweeper.domain;

import minesweeper.service.LandRenderer;
import minesweeper.service.MineGenerator;

import java.util.HashSet;
import java.util.Set;

public class Land implements MineGenerator<Mine>, LandRenderer {
    private int row, col;
    private int[][] table;
    private boolean[][] flag;

    public Land() { }
    public Land(int row, int col, int mineCount) {
        this.row = row;
        this.col = col;
        this.table = new int[row][col];
        this.flag = new boolean[row][col];

        if(row * col < mineCount) throw new IllegalStateException("Invalid mineCount, mineCount must be greater than the total number of cells.");

        Mine[] mines = generateMines(mineCount);
        layMines(table, mines);
    }

    // Use it when you need mines mocking.
    public Land(int row, int col, Mine[] mines) {
        this.row = row;
        this.col = col;
        this.table = new int[row][col];
        this.flag = new boolean[row][col];

        if(row * col < mines.length) throw new IllegalStateException("Invalid mineCount, mineCount must be greater than the total number of cells.");

        layMines(table, mines);
    }

    @Override
    public void render(boolean mineFlagMode) {
        if(table == null) return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j > 0) System.out.print(" | ");

                System.out.print(mineFlagMode && flag[i][j] ? Character.toString(MINE_FLAG) : table[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void layMines(int[][] table, Mine[] mines) {
        if(table == null || mines == null || mines.length < 1) return;

        for (Mine mine : mines) {
            int x = mine.getX();
            int y = mine.getY();

            flag[x][y] = true;

            // 상
            if(x > 0) table[x - 1][y]++;
            // 상우
            if(x > 0 && y < col - 1) table[x - 1][y + 1]++;
            // 상좌
            if(x > 0 && y > 0) table[x - 1][y - 1]++;
            // 하
            if(x < row - 1) table[x + 1][y]++;
            // 하우
            if(x < row - 1 && y < col - 1) table[x + 1][y + 1]++;
            // 하좌
            if(x < row - 1 && y > 0) table[x + 1][y - 1]++;
            // 좌
            if(y > 0) table[x][y - 1]++;
            // 우
            if(y < col - 1) table[x][y + 1]++;
        }

    }

    @Override
    public Mine[] generateMines(int mineCount) {
        if(this.table == null) return null;

        Mine[] mines = new Mine[mineCount];
        Set<Mine> set = new HashSet<>();

        int idx = 0;
        while(set.size() < mineCount) {
            int x = MineGenerator.getRandomNumber(0, row - 1);
            int y = MineGenerator.getRandomNumber(0, col - 1);
            Mine mine = new Mine(x, y);
            if(!set.contains(mine)) {
                set.add(mine);
                mines[idx++] = mine;
            }
        }

        return mines;
    }
}
