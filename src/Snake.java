import java.awt.*;
import java.util.LinkedList;

public class Snake {
    LinkedList<Point> snakeParts; //FIFO
    public int snakeSpeed;
    public int direction;
    Point tail = new Point();

    public Snake(){
        snakeParts = new LinkedList<>();
        snakeParts.offer(new Point(198, 198));
        snakeParts.offer(new Point(204, 198));
        snakeParts.offer(new Point(210, 198));

        snakeSpeed = 6;
    }

    public void move(){

        direction = Snake_Game.keyPressed;
        tail.setLocation(snakeParts.getFirst());

        for (int i = 0; i < snakeParts.size() - 1; i++){
            snakeParts.get(i).x = snakeParts.get(i+1).x;
            snakeParts.get(i).y = snakeParts.get(i+1).y;
        }

        if(direction == 1){ // D - right
            snakeParts.getLast().x += snakeSpeed;
        }
        else if(direction == 2){ // A - left
            snakeParts.getLast().x -= snakeSpeed;
        }
        else if(direction == 3){ // S - down
            snakeParts.getLast().y += snakeSpeed;
        }
        else if(direction == 4){ // W - up
            snakeParts.getLast().y -= snakeSpeed;
        }
    }

    public void snakeAugment(){
        snakeParts.offerFirst(new Point(tail));
    }
}
