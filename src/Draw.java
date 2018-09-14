import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent{

    Snake snake = new Snake();
    Apple apple = new Apple();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

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
        if(Snake_Game.keyPressed != 0) {
            snake.move();
        }


        if(apple.a.x == snake.snakeParts.getLast().x && apple.a.y == snake.snakeParts.getLast().y) {
            //change position of apple
            apple.setApple();
            //augment snake
            snake.snakeAugment();
        }

        //game over conditions:

        //collision with wall
        if((snake.snakeParts.getLast().x > Snake_Game.WIDTH  - 18|| snake.snakeParts.getLast().x < 0 )
                || (snake.snakeParts.getLast().y > Snake_Game.HEIGHT - 42 || snake.snakeParts.getLast().y < 0)){
            snake.setDefault();
            Snake_Game.keyPressed = 0;
            int tryAgain = JOptionPane.showConfirmDialog(null, "Your score: " + Apple.score + "\nTry Again?" , "GAME OVER!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            Apple.score = 0;
            if(tryAgain == JOptionPane.NO_OPTION)
                System.exit(0);
        }

        //collision with itself
        for(int i = 0; i < snake.snakeParts.size(); i++){
            for(int j = 0; j < snake.snakeParts.size(); j++){
                if((snake.snakeParts.get(i).x == snake.snakeParts.get(j).x &&
                        snake.snakeParts.get(i).y == snake.snakeParts.get(j).y) &&
                        (j != i)){
                    snake.setDefault();
                    Snake_Game.keyPressed = 0;
                    int tryAgain = JOptionPane.showConfirmDialog(null, "Your score: " + Apple.score + "\nTry Again?" , "GAME OVER!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    Apple.score = 0;
                    if(tryAgain == JOptionPane.NO_OPTION)
                        System.exit(0);

                }
            }
        }




    }
}
