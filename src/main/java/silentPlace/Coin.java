package silentPlace;

import java.util.Random;

public class Coin {
    private int coinX;
    private int coinY;

    private int[][] field;

    Coin(int[][] field) {
        this.field = field;
    }

    public int getCoinX() {
        return coinX;
    }

    public int getCoinY() {
        return coinY;
    }

    public void setCoinCoordinates() {
        Random rand = new Random();
        int x;
        int y;
        do {
            x = rand.nextInt(23);
            y = rand.nextInt(15);
        } while (field[y][x] != 0);
        coinX = x * 50;
        coinY = y * 50;
    }
}
