import java.awt.*;
import java.awt.image.BufferedImage;

public class Square {
    private int x;
    private int y;
    private boolean isCollided;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCollided() {
        return isCollided;
    }

    public void setCollided(boolean collided) {
        isCollided = collided;
    }

    public Square(){
        x = 0;
        y = 0;
        isCollided = false;
    }
    public void draw(BufferedImage img, Graphics g) {
        g.drawImage(img, x, y, null);
    }
}
