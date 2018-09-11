import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent{

    Snake snake = new Snake();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // draw snake
        // change position of snake when key pressed;
        // enlarge snake when he eats "apple"

        //draw snake
        //have points of every part of his body (little squares)
        for(Point p: snake.snakeParts){ // 2 odstepu by widziec odzielone kwadraty
            g2.fillRect(p.x, p.y, 4, 4);
            g2.drawRect(p.x, p.y, 4, 4);
        }
        snake.move();


    }
}
