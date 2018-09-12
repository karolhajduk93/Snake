import java.awt.*;
import java.util.LinkedList;

public class Snake {
    LinkedList<Point> snakeParts; //FIFO
    public int snakeSpeed;
    public int direction;

    public Snake(){
        snakeParts = new LinkedList<>();
        snakeParts.offer(new Point(200, 200));
        snakeParts.offer(new Point(206, 200));
        snakeParts.offer(new Point(212, 200));
        snakeSpeed = 6;
    }

    public void move(){
        // musi poruszac sie z okreslana predkoscia - snake speed
        // ale w jakim kierunku ?? i jak pozostale przetransportowac skoro one ide po kolei
        Point tmp = new Point();
        direction = Snake_Game.keyPressed;
        //System.out.println(snakeParts.getLast().toString());

 // 1-2-3  -> 2-3-4 ||||| 1->2, 2->3, 1->delete, 4->create
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

        for (int i = 0; i < snakeParts.size(); i++){
            System.out.println(snakeParts.get(i));
        }
    }
}
