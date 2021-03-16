package carCrash;

import java.util.Random;

public class EnemyCar {
    private int dy;
    private int y;
    private int x;
    private int heightModifier;

    public EnemyCar() {
        Random rand = new Random();
        int roadNumber = rand.nextInt(8);
        dy = roadNumber <= 3 ? 10 + rand.nextInt(2) : -5 - rand.nextInt(2);
        y = roadNumber <= 3 ? 0 : 600;
        x = 20 + 100 * roadNumber + 5;
        heightModifier = roadNumber <= 3 ? -1 : 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y += dy;
    }

    public int getCoordY() {
        return y + dy;
    }

    public int getHeightModifier() {
        return heightModifier;
    }

    public boolean crash(int playerX, int playerY) {
        int counter = 0;
        if (Math.abs(playerX - x) <= 50) {
            counter++;
        }
        if (heightModifier == -1 && playerY <= y && playerY >= y - 150) {
            counter++;
        }
        if (heightModifier == 1 && playerY + 100 >= y && playerY <= y + 100) {
            counter++;
        }
        return counter >= 2;
    }
}
