package doodle;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player {
    private int mapX = 175;
    private int mapY = 620;
    private int dy = 0;
    private int platformY = mapY;

    private Direction dirVer = Direction.UP;
    private Direction dirHor = Direction.NONE;

    private JFrame frame;
    private Timer timer;

    Player(JFrame frame, Timer timer) {
        this.frame = frame;
        this.timer = timer;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public Direction getDirVer() {
        return dirVer;
    }

    public void setPlatformY(int platformY) {
        this.platformY = platformY;
        this.mapY = platformY;
        this.dy = 0;
        this.dirVer = Direction.UP;
    }

    public boolean jump(int left, int right) {
        boolean result = true;
        if (dirVer == Direction.UP) {
            if (dy == 120) {
                dirVer = Direction.DOWN;
            } else {
                dy += 10;
                mapY -= 10;
            }
    }
        if (dirVer == Direction.DOWN) {
            if (dy == 0) {
                dirVer = Direction.UP;
            } else {
                dy -= 10;
                mapY += 10;
            }
        }
        if (dy == 0 && (mapX > right || mapX < left) && (mapX + 25 > right || mapX + 25 < left)) {
            result = false;
            dy = -1;
        }
        return result;
    }

    public void sideMove() {
        if (dirHor == Direction.LEFT) {
            mapX -= 15;
        } else if (dirHor == Direction.RIGHT) {
            mapX += 15;
        }
        if (mapX < -15) {
            mapX = 350;
        } else if (mapX > 365) {
            mapX = -15;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_A) {
            dirHor = Direction.LEFT;
        }
        if(key == KeyEvent.VK_D) {
            dirHor = Direction.RIGHT;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            frame.dispose();
            timer.stop();
            Menu menu = new Menu();
            menu.showMenu();
        }
    }

    public void keyReleased(KeyEvent e) {
        dirHor = Direction.NONE;
    }
}
