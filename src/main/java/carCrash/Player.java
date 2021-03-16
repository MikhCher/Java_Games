package carCrash;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player {
    private JFrame frame;
    private Timer timer;

    private int x = 375;
    private int y = 300;
    private int dx = 0;
    private int dy = 0;

    public Player(JFrame frame, Timer timer) {
        this.frame = frame;
        this.timer = timer;
    }

    public int getX() {
        int value = x;
        if (value + dx >= 730 || value + dx <= 20) {
            return value;
        }
        return x += dx;
    }

    public int getY() {
        int value = y;
        if (value + dy >= 500 || value + dy <= 0) {
            return value;
        }
        return y += dy;
    }

    public int getCoordX() {
        return x;
    }

    public int getCoordY() {
        return y;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            dy = -5;
        } else if (key == KeyEvent.VK_S) {
            dy = 5;
        } else if (key == KeyEvent.VK_A) {
            dx = -8;
        } else if (key == KeyEvent.VK_D) {
            dx = 8;
        } else if (key == KeyEvent.VK_ESCAPE) {
            timer.stop();
            frame.dispose();
            Menu menu = new Menu();
            menu.showMenu();
        }
    }

    public void keyReleased(KeyEvent e) {
        dy = 0;
        dx = 0;
    }
}
