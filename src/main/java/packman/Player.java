package ru.bstu.packman;

import javax.swing.*;
import java.awt.event.KeyEvent;
// Класс, отвечающий за поведение игрока
public class Player  {
    private int ver = 13;
    private int hor = 9;
    private int speed = 50;

    private int mapX;
    private int mapY;

    private Direction playerDirection = Direction.NONE;
    JFrame frame;


    public Player(int x, int y, JFrame frame) {
        this.frame = frame;
        this.mapX = x;
        this.mapY = y;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public int getVer() {
        return ver;
    }

    public int getHor() {
        return hor;
    }

    public void move(Integer[][] field) {
        switch(playerDirection) {
            case UP: {
                if (field[ver - 1][hor] == 0 || field[ver - 1][hor] == -1) {
                    field[ver - 1][hor] = -1;
                    ver--;
                    mapY -= speed;
                } else if (field[ver - 1][hor] == 1) {
                    playerDirection = Direction.NONE;
                }
                break;
            }
            case DOWN:
                if (field[ver + 1][hor] == 0 || field[ver + 1][hor] == -1) {
                    field[ver + 1][hor] = -1;
                    ver++;
                    mapY += speed;
                } else if (field[ver + 1][hor] == 1) {
                    playerDirection = Direction.NONE;
                }
                break;
            case LEFT:
                if (field[ver][hor - 1] == 0 || field[ver][hor - 1] == -1) {
                    field[ver][hor - 1] = -1;
                    hor--;
                    mapX -= speed;
                } else if (field[ver][hor - 1] == 1) {
                    playerDirection = Direction.NONE;
                }
                break;
            case RIGHT:
                if (field[ver][hor + 1] == 0 || field[ver][hor + 1] == -1) {
                    field[ver][hor + 1] = -1;
                    hor++;
                    mapX += speed;
                } else if (field[ver][hor + 1] == 1) {
                    playerDirection = Direction.NONE;
                }
                break;
            default:
                break;
        }
    }
    // Считывание и обработка нажатой клавиши
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
            frame.dispose();
            Menu menu = new Menu();
            menu.menuFrame();
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
