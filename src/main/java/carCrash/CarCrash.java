package carCrash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarCrash extends JPanel implements ActionListener {
    private Player player;
    private EnemyCar enemy1;
    private EnemyCar enemy2;
    private EnemyCar enemy3;
    private EnemyCar enemy4;
    private EnemyCar enemy5;

    private Timer timer = new Timer(20, this);
    private int score = 0;

    private JFrame frame;
    private int firstBGY = 0;
    private int secondBGY = -600;

    private final Image backGround = new ImageIcon("BSTU/src/main/resources/CCHighway.png").getImage();
    private final Image playerCar = new ImageIcon("BSTU/src/main/resources/CCPlayerCar.png").getImage();
    private final Image enemyCar = new ImageIcon("BSTU/src/main/resources/CCCar.png").getImage();

    public CarCrash(JFrame frame) {
        this.frame = frame;

        player = new Player(frame, timer);
        enemy1 = new EnemyCar();
        enemy2 = new EnemyCar();
        enemy3 = new EnemyCar();
        enemy4 = new EnemyCar();
        enemy5 = new EnemyCar();

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

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
        if (enemy1.getCoordY() > 700 || enemy1.getCoordY() < -100) {
            enemy1 = new EnemyCar();
        }
        if (enemy2.getCoordY() > 700 || enemy2.getCoordY() < -100) {
            enemy2 = new EnemyCar();
        }
        if (enemy3.getCoordY() > 700 || enemy3.getCoordY() < -100) {
            enemy3 = new EnemyCar();
        }
        if (enemy4.getCoordY() > 700 || enemy4.getCoordY() < -100) {
            enemy4 = new EnemyCar();
        }
        if (enemy5.getCoordY() > 700 || enemy5.getCoordY() < -100) {
            enemy5 = new EnemyCar();
        }

        if (enemy1.crash(player.getCoordX(), player.getCoordY())
                        || enemy2.crash(player.getCoordX(), player.getCoordY())
                        || enemy3.crash(player.getCoordX(), player.getCoordY())
                        || enemy4.crash(player.getCoordX(), player.getCoordY())
                        || enemy5.crash(player.getCoordX(), player.getCoordY())) {
            timer.stop();
            JOptionPane.showMessageDialog( this,"Вы проиграли, ваш счет: " + score);
        }
        score++;
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(backGround, 0, firstBGY -= -5, 800, 600, null);
        if (firstBGY > 600) {
            firstBGY = 0;
        }
        g.drawImage(backGround, 0, secondBGY -= -5, 800, 600, null);
        if (secondBGY > 0) {
            secondBGY = -600;
        }

        g.drawImage(playerCar, player.getX(), player.getY(),50, 100, null);

        g.drawImage(enemyCar, enemy1.getX(), enemy1.getY(),50, 100 * enemy1.getHeightModifier(), null);
        g.drawImage(enemyCar, enemy2.getX(), enemy2.getY(),50, 100 * enemy2.getHeightModifier(), null);
        g.drawImage(enemyCar, enemy3.getX(), enemy3.getY(),50, 100 * enemy3.getHeightModifier(), null);
        g.drawImage(enemyCar, enemy4.getX(), enemy4.getY(),50, 100 * enemy4.getHeightModifier(), null);
        g.drawImage(enemyCar, enemy5.getX(), enemy5.getY(),50, 100 * enemy5.getHeightModifier(), null);

        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.setColor(Color.PINK);
        g.drawString("Cчет: " + score, 600, 20);
    }
}
