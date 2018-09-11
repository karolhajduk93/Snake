import javax.swing.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Snake_Game extends JFrame{

    public static int keyPressed;

    public static void main(String[] args) {
        new Snake_Game();
    }

    public Snake_Game(){
        this.setTitle("Snake");
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Draw draw = new Draw();
        this.add(draw);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        // Method to execute, initial delay, subsequent delay, time unit

        executor.scheduleAtFixedRate(new Repaint(this), 0L, 100L, TimeUnit.MILLISECONDS);
        this.setVisible(true);
    }
}
