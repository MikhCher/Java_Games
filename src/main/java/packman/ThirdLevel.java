package packman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThirdLevel extends JPanel implements ActionListener {
    private final Image background = new ImageIcon("BSTU/src/main/resources/bg3.png").getImage();
    private final Image hero = new ImageIcon("BSTU/src/main/resources/Hero.png").getImage();
    private final Image monster = new ImageIcon("BSTU/src/main/resources/Monster.png").getImage();
    private final Image block = new ImageIcon("BSTU/src/main/resources/Block3.png").getImage();
    private final Image coin = new ImageIcon("BSTU/src/main/resources/Coin.png").getImage();
    private final Image title = new ImageIcon("BSTU/src/main/resources/Title.jpg").getImage();

    private int score = 0;
    private int caught = 0;

    private final Player player;
    private final Monster monster1;
    private final Monster monster2;
    private final Monster monster3;

    private final Timer timer = new Timer(250, this);

    private final Integer[][] field = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 0, 1, 4, 5, 6, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 9, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};


    public ThirdLevel(JFrame frame) {
        player = new Player(410, 605, frame);
        monster1 = new Monster(6, 8, 320, 265);
        monster2 = new Monster(6, 9, 370, 265);
        monster3 = new Monster(6, 10, 420, 265);

        field[13][9] = 2;
        field[6][8] = 3;
        field[6][9] = 4;
        field[6][10] = 5;

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
        player.move(field);
        monster1.move(field);
        monster2.move(field);
        monster3.move(field);
        if (monster1.eat(player)) {
            if (score < 50) {
                repaint();
                JOptionPane.showMessageDialog(ThirdLevel.this, "Вы прогирали, нажмите ESC для выхода в меню");
                timer.stop();
            } else {
                score -= 50;
                caught++;
            }
        }
        if (monster2.eat(player)) {
            if (score < 50) {
                repaint();
                JOptionPane.showMessageDialog(ThirdLevel.this, "Вы прогирали, нажмите ESC для выхода в меню");
                timer.stop();
            } else {
                score -= 50;
                caught++;
            }
        }
        if (monster3.eat(player)) {
            if (score < 50) {
                repaint();
                JOptionPane.showMessageDialog(ThirdLevel.this, "Вы прогирали, нажмите ESC для выхода в меню");
                timer.stop();
            } else {
                score -= 50;
                caught++;
            }
        }
        checkCoins();
        repaint();
    }

    private void checkCoins() {
        var coinCounter = Stream.of(field)
                .flatMap(Arrays::stream)
                .filter(val -> val == 0)
                .collect(Collectors.toList());
        int coins = 133;
        score = coins - coinCounter.size() - caught * 50;
        if (coinCounter.size() == 0) {
            repaint();
            timer.stop();
            JOptionPane.showMessageDialog(ThirdLevel.this, "Вы собрали все монеты, уровень пройден!\nЗакройте это окно и нажмите ESC для выхода в главное меню\n\nВаш счет: " + score);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, 1000, 900, null);
        buildField(g);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(new Color(248, 114, 33));
        g.drawString("Счет: " + score, 750, 37);
    }

    private void buildField(Graphics g) {
        int x = 0;
        int y = 0;
        for (Integer[] line : field) {
            for (Integer column : line) {
                switch (column) {
                    case 0 : {
                        g.drawImage(coin, x + 12, y + 12, 25, 25, null);
                        break;
                    }
                    case 1 : {
                        g.drawImage(block, x, y, 50, 50, null);
                        break;
                    }
                    case 2: {
                        g.drawImage(title, x, y, 50, 50, null);
                        g.drawImage(hero, player.getMapX() + 25, player.getMapY() + 25, 75, 75, null);
                        break;
                    }
                    default: break;
                }
                g.drawImage(title, 400, 300, 50, 50, null);
                g.drawImage(title, 450, 300, 50, 50, null);
                g.drawImage(title, 500, 300, 50, 50, null);
                g.drawImage(monster, monster1.getMapX(), monster1.getMapY(), 200, 125, null);
                g.drawImage(monster, monster2.getMapX(), monster2.getMapY(), 200, 125, null);
                g.drawImage(monster, monster3.getMapX(), monster3.getMapY(), 200, 125, null);
                x += 50;

            }
            x = 0;
            y += 50;
        }
    }
}
