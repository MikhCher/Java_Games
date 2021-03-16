package silentPlace;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame  implements MouseListener {

    public void showMenu() {
        setTitle("Лабиринт");
        setSize(1200,800);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        addMouseListener(this);

        setContentPane(new MenuGUI());

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
        if (e.getX() >= 350 && e.getX() <= 850
        && e.getY() >= 350 && e.getY() <= 450) {
            setVisible(false);
            JFrame game = new JFrame("Лабиринт");
            game.setSize(1200, 800);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.setUndecorated(true);
            game.add(new Maze(game));
            game.setVisible(true);
        } else if (e.getX() >= 350 && e.getX() <= 850
                && e.getY() >= 500 && e.getY() <= 600) {
            JOptionPane.showMessageDialog(Menu.this, "Программа выполнена на языке Java\nРазработчик: Чередниченко Михаил");
        } else if (e.getX() >= 350 && e.getX() <= 850
                && e.getY() >= 650 && e.getY() <= 750) {
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
