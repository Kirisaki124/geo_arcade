import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class EnemySqawner extends GameObject {
    private int count = 0;
    private Random random;

    public EnemySqawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        if (this.count >= 40) {
            Enemy enemy = new Enemy();
            enemy.x = this.random.nextInt(400);
            enemy.dx = this.random.nextInt(2) - random.nextInt(3);
            enemy.dy = random.nextInt(3) + 2;
            GameObject.add(enemy);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}