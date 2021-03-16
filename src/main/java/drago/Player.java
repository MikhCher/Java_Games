package drago;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player {
    private int mapY = 480;
    private int mapX = 100;

    private int position = 1;

    private JFrame frame;
    private Timer timer;

    public Player(Timer timer, JFrame frame) {
        this.timer = timer;
        this.frame = frame;
    }

    public int getMapY() {
        return mapY;
    }

    public int getMapX() {
        return mapX;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }

    public int getPosition() {
        int pos = this.position;
        if (position == 1) {
            position = 2;
        } else if (position == 2) {
            position = 1;
        }
        return pos;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            position = 3;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            timer.stop();
            frame.dispose();
            Menu menu = new Menu();
            menu.showMenu();
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
