package minesweeper.domain;

public class Mine {
    private int x;
    private int y;
    private boolean visited;
    public Mine() {}
    public Mine(int x, int y) {
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    @Override
    public boolean equals(Object o) {
        Mine mine = (Mine) o;

        return mine.x == this.x && mine.y == this.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
