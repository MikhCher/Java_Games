package carCrash;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {
    private Image menuBG = new ImageIcon("BSTU/src/main/resources/CCMenuBG.jpg").getImage();
    private Image button = new ImageIcon("BSTU/src/main/resources/CCButton.png").getImage();

    public void paint(Graphics g) {
        g.drawImage(menuBG,0,0, 800,600, null);
        g.drawImage(button, 25, 300, 250, 50, null);
        g.drawImage(button, 25, 375, 150, 50, null);
        g.drawImage(button, 525, 300, 250, 50, null);
        g.drawImage(button, 625, 375, 150, 50, null);

        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.setColor(Color.WHITE);
        g.drawString("Начать игру", 80, 330);
        g.drawString("Как играть?", 580, 330);
        g.drawString("Инфо", 70, 405);
        g.drawString("  Выход", 650, 405);
    }
}
