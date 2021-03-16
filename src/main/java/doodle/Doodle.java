package doodle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Doodle extends JPanel implements ActionListener {
    private JFrame frame;

    private Timer timer = new Timer(50, this);
    private Player player;

    private int dy = 0;
    private int score = 0;
    private int time = 0;

    private int height = 500;

    private Ledge firstLedge = new Ledge(height);
    private Ledge secondLedge = new Ledge(height);

    private boolean firstLendge = true;

    private Image BG = new ImageIcon("BSTU/src/main/resources/DoodleBG.png").getImage();
    private Image ABG = new ImageIcon("BSTU/src/main/resources/AdamtBG.png").getImage();
    private Image hero = new ImageIcon("BSTU/src/main/resources/DoodleHero.png").getImage();
    private Image ledge = new ImageIcon("BSTU/src/main/resources/DoodleButton.png").getImage();

    Doodle(JFrame frame) {
        this.frame = frame;
        timer.start();
        player = new Player(frame, timer);
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
        int left;
        int right;
        if (score == 0) {
            left = -15;
            right = 415;
        } else if (firstLendge) {
            left = firstLedge.getMapX() - 15;
            right = firstLedge.getMapX() + 35;
        } else {
            left = secondLedge.getMapX() - 15;
            right = secondLedge.getMapX() + 35;
        }
        if(!player.jump(left, right)) {
            while (time++ < 200) {
                dy = 20;
                repaint();
            }
            timer.stop();
            JOptionPane.showMessageDialog( Doodle.this,"Вы проиграли, ваш счет: " + score * 50);
        }
        if (player.getDirVer() == Direction.DOWN
                && player.getMapY() - 25 > firstLedge.getMapY()
                && player.getMapY() - 25 <= firstLedge.getMapY() + 15
                && player.getMapX() >= firstLedge.getMapX() - 25
                && player.getMapX() <= firstLedge.getMapX() + 25) {
            player.setPlatformY(firstLedge.getMapY() + 15);
            firstLendge = true;
            secondLedge.setMapY(height - 100);
            height -= 100;
            score++;
        }
        if (player.getDirVer() == Direction.DOWN
                && player.getMapY() - 25 > secondLedge.getMapY()
                && player.getMapY() - 25 <= secondLedge.getMapY() + 15
                && player.getMapX() >= secondLedge.getMapX() - 25
                && player.getMapX() <= secondLedge.getMapX() + 25) {
            player.setPlatformY(secondLedge.getMapY() + 20);
            firstLedge.setMapY(height - 100);
            height -= 100;
            firstLendge = false;
            score++;
        }
        player.sideMove();
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(BG, 0, 620 - player.getMapY(), 400, 800, null);
        if (height < 0)
        g.drawImage(ABG, -25, 0, 4500, 900, null);

        g.drawImage(hero, player.getMapX(), 620 + dy, 50, 50, null);

        g.drawImage(ledge, firstLedge.getMapX(), firstLedge.getMapY() + 55 + 620 - player.getMapY(), 50, 15, null);
        if (height != 500) {
            g.drawImage(ledge, secondLedge.getMapX(), secondLedge.getMapY() + 55 + 620 - player.getMapY(), 50, 15, null);
        }
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.setColor(new Color(243, 129, 153));
        g.drawString("Счет: " + score * 50, 240, 750);
    }
}
