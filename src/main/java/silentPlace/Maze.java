package silentPlace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Maze extends JPanel implements ActionListener {
    private Timer timer = new Timer(50, this);

    private Image block = new ImageIcon("BSTU/src/main/resources/Block3.png").getImage();
    private Image background = new ImageIcon("BSTU/src/main/resources/MazeBG.png").getImage();
    private Image hero = new ImageIcon("BSTU/src/main/resources/Hero.png").getImage();
    private Image coin = new ImageIcon("BSTU/src/main/resources/Coin.png").getImage();

    private int counter = 0;

    private int score = 0;
    private int time = 15;

    private int[][] field = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 2, 0, 2, 9, 2, 2, 0, 2, 9, 2, 2, 0, 2, 9, 2, 2, 2, 2, 9, 2, 0, 2, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 2, 0, 2, 9, 2, 2, 2, 2, 9, 2, 2, 2, 2, 9, 2, 2, 0, 2, 9, 2, 0, 2, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 2, 2, 2, 9, 2, 0, 2, 2, 9, 2, 2, 2, 2, 9, 2, 0, 2, 2, 9, 2, 2, 2, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 2, 0, 2, 9, 2, 2, 2, 2, 9, 2, 0, 2, 2, 9, 2, 2, 2, 2, 9, 2, 0, 2, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 2, 0, 2, 9, 2, 0, 2, 2, 9, 2, 2, 0, 2, 9, 2, 0, 2, 2, 9, 2, 0, 2, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 1, 1, 1, 9, 1, 1, 1, 1, 9, 1, 1, 1, 1, 9, 1, 1, 1, 1, 9, 1, 1, 1, 1}};

    private Player player;
    private Coin c = new Coin(field);

    Maze(JFrame frame) {
        c.setCoinCoordinates();
        player = new Player(timer, c);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (++counter == 20) {
            time--;
            counter = 0;
        }
        if (time == 0) {
            JOptionPane.showMessageDialog(Maze.this, "Время закончилось, вы собрали " + score +" монет");
            timer.stop();
        }
        player.move();
        if (player.takeCoin()) {
            c.setCoinCoordinates();
            time += 15;
            score++;
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        int x = 0;
        int y = 0;
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(Color.ORANGE);
        for (int[] row : field) {
            for (int cell : row) {
                if (cell == 1) {
                    g.drawImage(block, x, y, 50, 50, null);
                } else if (cell == 2) {
                    g.drawImage(block, x, y, 52, 25, null);
                } else if (cell == 3) {
                    g.drawImage(block, x, y - 14, 25, 60, null);
                } else if (cell == 4) {
                    g.drawImage(block, x - 25, y, 75, 25, null);
                } else if (cell == 9) {
                    g.drawImage(block, x, y, 52, 25, null);
                    g.drawImage(block, x, y - 12, 25, 48, null);
                }
                x += 50;
            }
            y += 50;
            x = 0;
        }
        g.drawImage(coin, c.getCoinX(), c.getCoinY(), 50, 50, null);
        g.drawImage(hero, player.getMapX(), player.getMapY(), 50, 50, null);
        g.drawImage(block, 4 * 50, 15 * 50, 50, 50, null);
        g.drawImage(block, 19 * 50, 15 * 50, 50, 50, null);
        g.drawImage(block, 9 * 50, 15 * 50, 50, 50, null);
        g.drawImage(block, 14 * 50, 15 * 50, 50, 50, null);
        g.drawString("Счет: " + score, 800, 50 );
        g.drawString("Времени осталось: " + time, 100, 50 );
    }
}
