import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

interface Drawable {
    void draw(Graphics g);
}

public class MainPanel extends JPanel {
    private player player;
    private bullets1 bullet;

    public MainPanel() {
        player = new player(new ImageIcon("player.png"), 300, 300);
        bullet = new bullets1(new ImageIcon("bullet.png"), 300, 300);

        setFocusable(true);

        new Timer(16, new TimerListener()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        //bullet.draw(g);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            player.movePlayer();
            bullet.moveBullets();
            repaint();
        }
    }
    }