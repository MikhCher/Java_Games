package doodle;

import javax.swing.*;
import java.awt.*;

public class MGUI extends JPanel {
    private Image menuBG = new ImageIcon("BSTU/src/main/resources/DoodleMenuBG.png").getImage();
    private Image button = new ImageIcon("BSTU/src/main/resources/DoodleButton.png").getImage();
    private Image herb = new ImageIcon("BSTU/src/main/resources/BGTU.png").getImage();

    public void paintComponent(Graphics g) {
        g.drawImage(menuBG, 0, 0, 400, 800, null);
        g.drawImage(button, 100, 500, 200, 50, null);
        g.drawImage(button, 100, 575, 200, 50, null);
        g.drawImage(herb, 100, 110, 185, 300, null);
        g.drawImage(button, 100, 650, 200, 50, null);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("  Начать", 145, 535);
        g.drawString("Информация", 125, 535 + 75);
        g.drawString("  Выход", 150, 535 + 150);
    }
}
