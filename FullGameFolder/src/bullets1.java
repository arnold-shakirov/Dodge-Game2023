import javax.swing.*;
import java.awt.*;

public class bullets1 extends JPanel {
    public int bulletX;
    public int bulletY;
    private Image bulletIcon;

    public bullets1(ImageIcon bulletIcon, int bulletX, int bulletY) {
        this.bulletIcon = bulletIcon.getImage();
        this.bulletX = bulletX;
        this.bulletY = bulletY;
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        // Рисование пули, если нужно
        g2d.dispose();
        int newWidth = bulletIcon.getWidth(null) / 2;
        int newHeight = bulletIcon.getHeight(null) / 2;
        g.drawImage(bulletIcon, bulletX, bulletY, newWidth, newHeight, this);
    }

    public void moveBullets() {
        bulletY += 5;
        repaint();
    }
}
