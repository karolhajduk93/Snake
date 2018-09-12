import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 68 && keyPressed != 2) // D - right
                    keyPressed = 1;
                else if (e.getKeyCode() == 65 && keyPressed != 1) // A - left
                    keyPressed = 2;
                else if (e.getKeyCode() == 83 && keyPressed != 4) // S - down
                    keyPressed = 3;
                else if (e.getKeyCode() == 87 && keyPressed != 3) // W - up
                    keyPressed = 4;
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.scheduleAtFixedRate(new Repaint(this), 0L, 100L, TimeUnit.MILLISECONDS);

        this.setVisible(true);
    }
}
