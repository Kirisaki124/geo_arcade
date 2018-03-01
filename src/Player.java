import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel{
    BufferedImage player;

    @Override
    protected void paintComponent(Graphics g) {
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        g.drawImage(this.player,0,0,null);
    }
}
