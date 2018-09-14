import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent{

    Snake snake = new Snake();
    Apple apple = new Apple();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // draw snake
        // change position of snake when key pressed;
        // augment snake when he eats apple

        //draw snake
        //have points of every part of his body (little squares)
        for(Point p: snake.snakeParts){
            g2.fillRect(p.x, p.y, 4, 4);
            g2.drawRect(p.x, p.y, 4, 4);
        }

        //draw apple
        g2.setColor(Color.red);
        g2.fillRect(apple.a.x, apple.a.y, 4, 4);
        g2.drawRect(apple.a.x, apple.a.y, 4, 4);
        g2.setColor(Color.black);

        //change position of snake when key pressed;
        snake.move();


        if(apple.a.x == snake.snakeParts.getLast().x && apple.a.y == snake.snakeParts.getLast().y) {
            //change position of apple
            apple.setApple();
            //augment snake
            snake.snakeAugment();
        }




    }
}
