package packman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame implements ActionListener, MouseListener {

    private final JButton start = new JButton("Запуск!");
    private final JButton info = new JButton("О программе");
    private final JButton exit = new JButton("Выход");
    private final JButton firstLevel = new JButton("1");
    private final JButton secondLevel = new JButton("2");
    private final JButton thirdLevel = new JButton("3");
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void menuFrame() {
        setTitle("Пакман");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(965, 790);
        setLocationRelativeTo(null);
        setContentPane(new MenuPanel(0));
        setResizable(false);

        Container cont = getContentPane();
        cont.setLayout(new GridBagLayout());

        GridBagConstraints a = new GridBagConstraints();
        a.gridx = 0;
        a.gridy = 0;
        a.gridheight = 1;
        a.gridwidth = 1;
        a.weightx = 0;
        a.weighty = 1;
        a.anchor = GridBagConstraints.NORTHEAST;
        a.fill = GridBagConstraints.HORIZONTAL;
        a.insets = new Insets(400, -450, 50, 25);
        a.ipadx = 300;
        a.ipady = 50;
        cont.add(start, a);

        GridBagConstraints b = new GridBagConstraints();
        b.gridx = 0;
        b.gridy = 0;
        b.gridheight = 1;
        b.gridwidth = 1;
        b.weightx = 0;
        b.weighty = 1;
        b.anchor = GridBagConstraints.NORTHEAST;
        b.fill = GridBagConstraints.HORIZONTAL;
        b.insets = new Insets(500, -450, 50, 25);
        b.ipadx = 300;
        b.ipady = 50;
        cont.add(info, b);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(600, -450, 50, 25);
        c.ipadx = 300;
        c.ipady = 50;
        cont.add(exit, c);
        setVisible(true);

        start.addActionListener(e -> {
            cont.remove(start);
            cont.remove(info);
            cont.remove(exit);

            addMouseListener(this);
            showLevels();

            firstLevel.addActionListener(event -> {
            setVisible(false);
            JFrame game = new JFrame("Пакман");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(965, 790);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.add(new FirstLevel(game));
            game.setVisible(true);
            });

            secondLevel.addActionListener(event -> {
                setVisible(false);
                JFrame game = new JFrame("Пакман");
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setSize(965, 790);
                game.setResizable(false);
                game.setLocationRelativeTo(null);
                game.add(new SecondLevel(game));
                game.setVisible(true);
            });

            thirdLevel.addActionListener(event -> {
                setVisible(false);
                JFrame game = new JFrame("Пакман");
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setSize(965, 790);
                game.setResizable(false);
                game.setLocationRelativeTo(null);
                game.add(new ThirdLevel(game));
                game.setVisible(true);
            });
        });

        info.addActionListener(e -> JOptionPane.showMessageDialog(Menu.this, "Программа выполнена на языке Java\n" +
                "Разработчик: Чередниченко Михаил\n" +
                "Группа: И881"));

        exit.addActionListener(e -> System.exit(1));
    }

    private void showLevels() {
        setContentPane(new MenuPanel(1));
        setVisible(true);
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               Menu menu = new Menu();
               menu.menuFrame();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 10 && e.getX() <= 310 && e.getY() >= 400 && e.getY() <= 730) {
            setVisible(false);
            JFrame game = new JFrame("Пакман");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(965, 790);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.add(new FirstLevel(game));
            game.setVisible(true);
        } else if (e.getX() >= 325 && e.getX() <= 625 && e.getY() >= 400 && e.getY() <= 730) {
            setVisible(false);
            JFrame game = new JFrame("Пакман");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(965, 790);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.add(new SecondLevel(game));
            game.setVisible(true);
        } else if (e.getX() >= 640 && e.getX() <= 940 && e.getY() >= 400 && e.getY() <= 730) {
            setVisible(false);
            JFrame game = new JFrame("Пакман");
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(965, 790);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            game.add(new ThirdLevel(game));
            game.setVisible(true);
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
