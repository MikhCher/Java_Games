package silentPlace;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JPanel {
    private Image button = new ImageIcon("BSTU/src/main/resources/Button.jpg").getImage();
    private Image background = new ImageIcon("BSTU/src/main/resources/MenuBG.png").getImage();

    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, 1200, 1000, null);
        g.drawImage(button, 350, 350, 500, 100, null);
        g.drawImage(button, 350, 500, 500, 100, null);
        g.drawImage(button, 350, 650, 500, 100, null);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(Color.GRAY);
        g.drawString("Начать", 535, 410);
        g.drawString("Информация", 490, 560);
        g.drawString("Выход", 550, 710);
    }
}
