package carCrash;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame  implements MouseListener {

    public void showMenu() {
        setTitle("Car Crash");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        addMouseListener(this);

        setContentPane(new GUI());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Menu menu = new Menu();
                menu.showMenu();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 32 && e.getX() <= 282
                && e.getY() >= 327 && e.getY() <= 377) {
            setVisible(false);
            JFrame game = new JFrame("Car Crash");
            game.setUndecorated(true);
            game.setSize(800, 600);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.add(new CarCrash(game));
            game.setVisible(true);
        } else if (e.getX() >= 32 && e.getX() <= 182
                && e.getY() >= 402 && e.getY() <= 452) {
            JOptionPane.showMessageDialog(Menu.this,
                    "Программа выполнена на языке Java\n" +
                            "Разработчик: Чередниченко Михаил");
        } else if (e.getX() >= 631 && e.getX() <= 781
                && e.getY() >= 402 && e.getY() <= 452) {
            System.exit(0);
        } else if (e.getX() >= 531 && e.getX() <= 781
                && e.getY() >= 327 && e.getY() <= 377) {
            JOptionPane.showMessageDialog(Menu.this,
                    "Для перемещения машиной используйте следующие клавиши:\n" +
                            "W - увеличить скорость\n" +
                            "A - смещение влево\n" +
                            "S - уменьшить скорость\n" +
                            "D - смещение вправо\n" +
                            "\nESC - выход в меню");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

