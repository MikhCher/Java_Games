package doodle;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame  implements MouseListener {

    public void showMenu() {
        setTitle("Прыгун");
        setSize(400,800);
        setLocationRelativeTo(null);
        setResizable(false);
        addMouseListener(this);

        setContentPane(new MGUI());

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
        if (e.getX() >= 107 && e.getX() <= 307
                && e.getY() >= 527 && e.getY() <= 577) {
            setVisible(false);
            JFrame game = new JFrame("Прыгун");
            game.setSize(415, 800);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.add(new Doodle(game));
            game.setVisible(true);
        } else if (e.getX() >= 107 && e.getX() <= 307
                && e.getY() >= 602 && e.getY() <= 652) {
            JOptionPane.showMessageDialog(Menu.this, "Программа выполнена на языке Java" +
                    "\nРазработчик: Чередниченко Михаил");
        } else if (e.getX() >= 107 && e.getX() <= 307
                && e.getY() >= 677 && e.getY() <= 727) {
            System.exit(0);
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

