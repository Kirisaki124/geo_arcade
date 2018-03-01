import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage square;
    BufferedImage backBuffered;

    Graphics graphics;

    int positionPlayerX;
    int getPositionPlayerY;

    public GameCanvas() {
        this.setSize(400,600);
        this.setVisible(true);
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        // load images
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
//   Load image
    protected void paintComponent(Graphics g) {
//        g.setColor(Color.cyan);
//        g.fillRect(0,0,30,30);
        g.drawImage(this.backBuffered,0,0,null);

    }
    int squareY = 0;
    int squareX = 0;
    int collide = 0;
    public void run(){
        this.squareY ++;
        this.squareX ++;
    }
    public void renderAll(){
//         Draw images
        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.player,this.positionPlayerX - 20,this.getPositionPlayerY - 40,null);
//        for (int i = 0; i < 1000; i+=30) {

        if (this.collide == 1){
            if (this.squareX < 0){
                this.collide = 0;
            }
            this.squareX -= 4;
        }

        else if (this.collide == 0) {
            if (this.squareX > 400 - 20){
                this.collide = 1;
            }
            this.squareX += 2;
        }

        this.graphics.drawImage(this.square, this.squareX, this.squareY, null);
        System.out.println(String.format("%d", this.squareX));
        System.out.println(String.format("%d", this.collide));
        this.repaint();
    }

}
