import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class player extends JPanel {
    private ImageIcon playerIcon;
    private int playerX;
    private int playerY;

    private boolean isWPressed;
    private boolean isSPressed;
    private boolean isAPressed;
    private boolean isDPressed;
    public player(ImageIcon playerIcon, int initialX, int initialY) {
        this.playerIcon = playerIcon;
        this.playerX = initialX;
        this.playerY = initialY;
        setFocusable(true);  // Сделать JPanel фокусируемым
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int newWidth = playerIcon.getIconWidth() / 4;
        int newHeight = playerIcon.getIconHeight() / 4;
        g.drawImage(playerIcon.getImage(), playerX, playerY, newWidth, newHeight, this);
        g2d.dispose();
    }

    public void draw(Graphics g) {
        int newWidth = playerIcon.getIconWidth() / 10;
        int newHeight = playerIcon.getIconHeight() / 10;
        g.drawImage(playerIcon.getImage(), playerX, playerY, newWidth, newHeight, null);
    }
    public void setCenter() {
        playerX = 300;
        playerY = 300;
    }
    public void setDirection0() {
        isDPressed = false;
        isAPressed = false;
        isWPressed = false;
        isSPressed = false;
    }
    public void movePlayer() {
        //System.out.println("b");
        if (isWPressed) {
            playerY -= 5;
        }
        if (isSPressed) {
            playerY += 5;
        }
        if (isAPressed) {
            playerX -= 5;
        }
        if (isDPressed) {
            playerX += 5;
        }
        repaint();
    }
    public void updateKeyState(int keyCode, boolean pressed) {
        if (keyCode == KeyEvent.VK_W) {
            isWPressed = pressed;
            System.out.println("a");
        }
        else if (keyCode == KeyEvent.VK_S) {
            isSPressed = pressed;
        }
        else if (keyCode == KeyEvent.VK_A) {
            isAPressed = pressed;
        }
        else if (keyCode == KeyEvent.VK_D) {
            isDPressed = pressed;
        }
    }


}
