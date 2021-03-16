package drago;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {
    private final Image menuBG = new ImageIcon("BSTU/src/main/resources/DragoMBG.png").getImage();
    private final Image button = new ImageIcon("BSTU/src/main/resources/DragoButton.png").getImage();

    public void paintComponent(Graphics g) {
        g.drawImage(menuBG, 0, 0, 1000, 640, null);
        g.drawImage(button, 100, 500, 200, 50, null);
        g.drawImage(button, 400, 500, 200, 50, null);
        g.drawImage(button, 700, 500, 200, 50, null);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("  Начать", 145, 535);
        g.drawString("Информация", 425, 535);
        g.drawString("  Выход", 750, 535);
    }
}