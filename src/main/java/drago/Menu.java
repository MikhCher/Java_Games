package drago;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame  implements MouseListener {

    public void showMenu() {
        setTitle("Dinosaur");
        setSize(1000,640);
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
        if (e.getX() >= 107 && e.getX() <= 307
                && e.getY() >= 527 && e.getY() <= 577) {
            setVisible(false);
            JFrame game = new JFrame();
            game.setSize(1000, 640);
            game.setResizable(false);
            game.setUndecorated(true);
            game.setLocationRelativeTo(null);
            game.add(new Dragon(game));
            game.setVisible(true);
        } else if (e.getX() >= 407 && e.getX() <= 607
                && e.getY() >= 527 && e.getY() <= 577) {
            JOptionPane.showMessageDialog(Menu.this, "Для прыжка динозавром нажмите пробел, ц(w)  или стрелку вверх\n" +
                    "После начала игры, герой начнет бежать. \n" +
                    "Чтобы перепрыгнуть кактусы вам нужно еще раз нажать на кнопку прыжка. \n" +
                    "Игра бесконечная. Не пытайтесь пройти её до конца.\n\n\nПрограмма выполнена на языке Java\nРазработчик: Чередниченко Михаил");
        } else if (e.getX() >= 707 && e.getX() <= 907
                && e.getY() >= 527 && e.getY() <= 577) {
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


