import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame{
    GameCanvas gameCanvas;
    public GameWindow (){
        this.setSize(400, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
//                System.out.println(e.getX() + " / " + e.getY());
                gameCanvas.positionPlayerX = e.getX();
                gameCanvas.getPositionPlayerY = e.getY();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
//        System.exit(1);
        this.setVisible(true);
    }
    private long lastTime = 0;
    public void GameLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
//                gameCanvas.squareY++;
                this.gameCanvas.run();
                this.gameCanvas.renderAll();
                lastTime = currentTime;
            }
        }
    }
}
