package silentPlace;

import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {
    private int mapX = 100;
    private int mapY = 150;
    private int speed = 10;

    private Direction playerDirection = Direction.NONE;

    private Timer timer;
    private Coin coin;

    Player(Timer timer, Coin coin) {
        this.coin = coin;
        this.timer = timer;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }


    public void move() {
        switch(playerDirection) {
            case UP: {
                if (checkNext()) {
                    mapY -= speed;
                }
                break;
            }
            case DOWN:
                if (checkNext()) {
                    mapY += speed;
                }
                break;
            case LEFT:
                if (checkNext()) {
                    mapX -= speed;
                }
                break;
            case RIGHT:
                if (checkNext()) {
                    mapX += speed;
                }
                break;
            default:
                break;
        }
    }

    public boolean takeCoin() {
        boolean result = false;
        if (coin.getCoinX() == mapX && coin.getCoinY() == mapY) {
            result = true;
        }
        return result;
    }

    private boolean checkNext() {
        boolean result = false;
        if (playerDirection == Direction.UP
        && ((mapY - speed > 0 && mapY - speed < 100)
                || (mapY - speed > 300 - 50 && mapY - speed < 325 - 50 && mapX != 100 && mapX != 350 && mapX != 600 && mapX != 1050)
                || (mapY - speed > 400 - 50 && mapY - speed < 425 - 50 && mapX != 100 && mapX != 850 && mapX != 1050)
                || (mapY - speed > 500 - 50 && mapY - speed < 525 - 50 && mapX != 300 && mapX != 800)
                || (mapY - speed > 600 - 50 && mapY - speed < 625 - 50 && mapX != 100 && mapX != 550 && mapX != 1050)
                || (mapY - speed > 700 - 50 && mapY - speed < 725 - 50 && mapX != 100 && mapX != 300 && mapX != 600 && mapX != 800 && mapX != 1050))) {
            result = true;
        }
        if (playerDirection == Direction.DOWN
                && ((mapY + 50 + speed > 250 && mapY + 50 + speed < 275 && mapX != 100 && mapX != 350 && mapX != 600 && mapX != 1050)
                || (mapY + 50 + speed > 350 && mapY + 50 + speed < 375 && mapX != 100 && mapX != 850 && mapX != 1050)
                || (mapY + 50 + speed > 450 && mapY + 50 + speed < 475 && mapX != 300 && mapX != 800)
                || (mapY + 50 + speed > 550 && mapY + 50 + speed < 575 && mapX != 100 && mapX != 550 && mapX != 1050)
                || (mapY + 50 + speed > 650 && mapY + 50 + speed < 675 && mapX != 100 && mapX != 300 &&  mapX != 600 && mapX != 800 && mapX != 1050)
                || (mapY + 50 + speed > 750 && mapY + 50 + speed < 800))) {
            result = true;
        }
        if (playerDirection == Direction.LEFT
                && ((mapX - speed > 0 && mapX - speed < 50)
                || (mapX - speed > 200 && mapX - speed < 225 && mapY != 290 && mapY != 390 && mapY != 590)
                || (mapX - speed > 450 && mapX - speed < 475 && mapY != 490 && mapY != 690)
                || (mapX - speed > 700 && mapX - speed < 725 && mapY != 140 && mapY != 290 && mapY != 390 && mapY != 490 && mapY != 690)
                || (mapX - speed > 950 && mapX - speed < 975 && mapY != 140 && mapY != 590))) {
            result = true;
        }
        if (playerDirection == Direction.RIGHT
                && ((mapX + 50 + speed > 200 && mapX + 50 + speed < 225 && mapY != 290 && mapY != 390 && mapY != 590)
                || (mapX + 50 + speed > 450 && mapX + 50 + speed < 475 && mapY != 490 && mapY != 690)
                || (mapX + 50 + speed > 700 && mapX + 50 + speed < 725 && mapY != 140 && mapY != 290 && mapY != 390 && mapY != 490 && mapY != 690)
                || (mapX + 50 + speed > 950 && mapX + 50 + speed < 975 && mapY != 140 && mapY != 590))) {
            result = true;
        }
        return !result;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            playerDirection = Direction.UP;
        }
        if(key == KeyEvent.VK_S) {
            playerDirection = Direction.DOWN;
        }
        if(key == KeyEvent.VK_A) {
            playerDirection = Direction.LEFT;
        }
        if(key == KeyEvent.VK_D) {
            playerDirection = Direction.RIGHT;
        }
        if (key == KeyEvent.VK_SPACE) {
            playerDirection = Direction.NONE;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            timer.stop();
            Menu menu = new Menu();
            menu.showMenu();
        }
    }

    public void keyReleased(KeyEvent e) {
        playerDirection = Direction.NONE;
    }
}
