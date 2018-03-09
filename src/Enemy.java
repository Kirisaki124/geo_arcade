import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Enemy extends GameObject {
    public int dx;
    public int dy;
    private Vector<BulletEnemy> bulletEnemies;
    private int count = 0;


    public Enemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.bulletEnemies = new Vector<>();
    }

    @Override
    public void run() {
        super.run();
        this.x += this.dx;
        this.y += this.dy;
//        System.out.println(this.x);
        this.shoot();
    }

    private void shoot() {
        if (this.count >= 10) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.x = this.x;
            bulletEnemy.y = this.y;
            bulletEnemy.dy = 7;
            this.bulletEnemies.add(bulletEnemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
