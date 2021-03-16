package doodle;

import java.util.Random;

public class Ledge {
    private int mapX;
    private int mapY;

    Ledge (int y) {
        this.mapY = y;
        setX();
    }

    private void setX() {
        Random rand = new Random();
        mapX = rand.nextInt(8) * 50;
    }

    public void setMapY(int mapY) {
        Random rand = new Random();
        mapX = rand.nextInt(8) * 50;
        this.mapY = mapY;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }
}
