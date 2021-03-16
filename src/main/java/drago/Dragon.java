package drago;

import ru.bstu.doodle.Doodle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dragon extends JPanel implements ActionListener {

    private Timer timer = new Timer(100, this);
    private Player player;

    private Element el = new Element();

    private Element.Cloud firstCloud = el.new Cloud(330);
    private Element.Cloud secondCloud = el.new Cloud(720);
    private Element.Cloud thirdCloud = el.new Cloud(1085);

    private Element.Cactus firstCactus = el.new Cactus();
    private Element.Cactus secondCactus = el.new Cactus(firstCactus.getPosX() + 500);

    private int position = 1;

    private int dir = 1;
    private int dy = 0;
    private int score = 0;

    private Image BG = new ImageIcon("BSTU/src/main/resources/DragoBG.png").getImage();
    private Image cloud = new ImageIcon("BSTU/src/main/resources/DragoCloud.png").getImage();
    private Image heroPos1 = new ImageIcon("BSTU/src/main/resources/DragoHeroRunPos1.png").getImage();
    private Image heroPos2 = new ImageIcon("BSTU/src/main/resources/DragoHeroRunPos2.png").getImage();
    private Image heroJump = new ImageIcon("BSTU/src/main/resources/DragoHeroJump.png").getImage();
    private Image single = new ImageIcon("BSTU/src/main/resources/DragoCactusSingle.png").getImage();
    private Image doubled = new ImageIcon("BSTU/src/main/resources/DragoCactusDouble.png").getImage();
    private Image triple = new ImageIcon("BSTU/src/main/resources/DragoCactusTriple.png").getImage();

    Dragon(JFrame frame) {
        timer.start();
        player = new Player(timer, frame);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        score++;
        position = player.getPosition();
        if (position == 3) {
            if (dir == 1) {
                dy -= 20;
                if (dy == -140) {
                    dir = 2;
                }
            } else {
                dy += 20;
                if (dy == 0) {
                    dir = 1;
                    player.setPosition(1);
                }
            }
            player.setMapY(480 + dy);
        }

        if (firstCactus.getPosX(0) + firstCactus.getWidth() < 0) {
            firstCactus = el.new Cactus(secondCactus.getPosX(0) + 550);
        }
        if (secondCactus.getPosX(0) + secondCactus.getWidth() < 0) {
            secondCactus = el.new Cactus(firstCactus.getPosX(0) + 550);
        }

        if (firstCloud.getPosX() < -170)
            firstCloud = el.new Cloud();
        if (secondCloud.getPosX() < -170)
            secondCloud = el.new Cloud();
        if (thirdCloud.getPosX() < -170)
            thirdCloud = el.new Cloud();

        if (hasLose()) {
            timer.stop();
            JOptionPane.showMessageDialog( Dragon.this,"Вы проиграли, ваш счет: " + score);
        }

        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(BG, 0,0, 1000, 640, null);

        g.drawImage(cloud, firstCloud.getPosX(), firstCloud.getPosY(), 175, 100, null);
        g.drawImage(cloud, secondCloud.getPosX(), secondCloud.getPosY(), 175, 100, null);
        g.drawImage(cloud, thirdCloud.getPosX(), thirdCloud.getPosY(), 175, 100, null);

        switch (position) {
            case 1: {
                g.drawImage(heroPos1, 100, player.getMapY(), 80, 150, null);
                break;
            }
            case 2: {
                g.drawImage(heroPos2, 100, player.getMapY(), 80, 150, null);
                break;
            }
            case 3: {
                g.drawImage(heroJump, 100, player.getMapY(), 80, 150, null);
                break;
            }
        }

        switch (firstCactus.getCount()) {
            case 1: {
                g.drawImage(doubled, firstCactus.getPosX(), 630, firstCactus.getWidth(), -firstCactus.getHeight(), null);
                break;
            }
            case 2: {
                g.drawImage(triple, firstCactus.getPosX(), 630, firstCactus.getWidth(), -firstCactus.getHeight(), null);
                break;
            }
            default: {
                g.drawImage(single, firstCactus.getPosX(), 630, firstCactus.getWidth(), -firstCactus.getHeight(), null);
                break;
            }
        }

        switch (secondCactus.getCount()) {
            case 1: {
                g.drawImage(doubled, secondCactus.getPosX(), 630, secondCactus.getWidth(), -secondCactus.getHeight(), null);
                break;
            }
            case 2: {
                g.drawImage(triple, secondCactus.getPosX(), 630, secondCactus.getWidth(), -secondCactus.getHeight(), null);
                break;
            }
            default: {
                g.drawImage(single, secondCactus.getPosX(), 630 , secondCactus.getWidth(), -secondCactus.getHeight(), null);
                break;
            }
        }

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.setColor(new Color(145, 117, 32));
        g.drawString("Счет: " + score, 800, 70);
    }

    private boolean hasLose() {
        boolean rightX = false;
        boolean leftX = false;
        boolean bothY = false;
        Element.Cactus cactus = firstCactus.getPosX(0) < secondCactus.getPosX(0) ? firstCactus : secondCactus;
        if (player.getMapX() + 70 >= cactus.getPosX(0) && player.getMapX() + 70 <= cactus.getPosX(0) + cactus.getWidth()) {

            rightX = true;
        }
        if (player.getMapX() + 40 >= cactus.getPosX(0) && player.getMapX() + 40  <= cactus.getPosX(0) + cactus.getWidth()) {
            leftX = true;
    }
        if (player.getMapY() + 150 <= 650 && player.getMapY() + 150 >= 650 - cactus.getHeight()) {
            bothY = true;
        }
        return (rightX || leftX) && bothY;
    }
}
