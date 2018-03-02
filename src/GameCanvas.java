import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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

    public void createSquares() {
        Random rand = new Random();
        squareList.clear();
        for (int i = 0; i < 3; i++) {
            squareList.add(new Square());
            squareList.get(i).setX(rand.nextInt(200));
            //squareList.get(i).setY(498);
        }
    }

    public void run(){
        this.squareY ++;
    }
    ArrayList<Square> squareList = new ArrayList<Square>();

    public void renderAll() {
        int done = 0;
        for (Square square: squareList) {
            if (square.getY() > 600) {
                done++;
            }
        }
//         Draw images
        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.player, this.positionPlayerX - 20, this.getPositionPlayerY - 40, null);

        if (done == 3) {
            createSquares();
        }
        for (int i = 0; i < squareList.size(); i++) {
            this.squareList.get(i).draw(square, graphics);
//            this.graphics.drawImage(this.square, squareList.get(i).getX(), this.squareY, null);
        }
        for (int i = 0; i < squareList.size(); i++) {
            if (squareList.get(i).isCollided() == false) {
                if (this.squareList.get(i).getX() < 0) {
                    this.squareList.get(i).setCollided(true);
                }
                this.squareList.get(i).setX(this.squareList.get(i).getX() - 2);
            }
            else {
                if (this.squareList.get(i).getX() > 360) {
                    this.squareList.get(i).setCollided(false);
                }
                this.squareList.get(i).setX(this.squareList.get(i).getX() + 2);
            }
            Random rand  = new Random();
            this.squareList.get(i).setY(this.squareList.get(i).getY() + rand.nextInt(5));
//            System.out.println(String.format("%d", this.squareList.get(i).getY()));
        }

        for (int i = 0; i < squareList.size(); i++) {
//            System.out.println(String.format("%d / %d", this.squareList.get(i).getX(), this.squareList.get(i).getY()));
        }

        this.repaint();
    }

}
