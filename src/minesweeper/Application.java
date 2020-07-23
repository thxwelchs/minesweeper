package minesweeper;

import minesweeper.domain.Land;
import minesweeper.domain.Mine;

import java.util.Arrays;

public class Application {
    private static final int ROW = 10;
    private static final int COL = 10;
    private static final int MINE_COUNT = 10;

    // 출력시 지뢰에 플래그를 설정하는 모드
    private static final boolean MINE_FLAG_MODE = false;

    public static void main(String[] args) {
//        Land land = new Land(ROW, COL, MINE_COUNT);
//        land.render(MINE_FLAG_MODE);

        // Mines Mocking test
        Land land = new Land(ROW, COL, Arrays.stream(new int[][]{
                {1, 2},
                {4, 5},
                {1, 9},
                {2, 9},
                {7, 8},
                {5, 1},
                {8, 8},
                {3, 2},
                {4, 0},
                {7, 3}
        }).map(mine -> new Mine(mine[0], mine[1])).toArray(Mine[]::new));
        land.render(true);
    }
}
