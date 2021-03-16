package ru.bstu.packman;

import javax.swing.*;
import java.awt.*;
// Класс, отвечающий за графическую состовляющую меню
public class MenuPanel extends JPanel {
    private int mode;

    private Image bg = new ImageIcon("BSTU/src/main/resources/menu_bg.jpg").getImage();


    MenuPanel(int mode) {
        this.mode = mode;
    }
    // Отрисовка компонентов
    public void paintComponent(Graphics g) {
        if (mode == 0)
            g.drawImage(bg,0,0, 965, 940, null);
        else {
            Image FB = new ImageIcon("BSTU/src/main/resources/BL1.png").getImage();
            Image SB = new ImageIcon("BSTU/src/main/resources/BL2.png").getImage();
            Image TB = new ImageIcon("BSTU/src/main/resources/BL3.png").getImage();


            g.drawImage(bg,0,0, 965, 940, null);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.setColor(Color.WHITE);
            g.drawString("Выберите уровень:",300 ,350);
            g.drawImage(FB, 10,400, 300, 300, null);
            g.drawImage(SB, 325,400, 300, 300, null);
            g.drawImage(TB, 640,400, 300, 300, null);
        }
    }

}
