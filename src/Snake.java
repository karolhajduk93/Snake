import java.awt.*;
import java.util.LinkedList;

public class Snake {
    LinkedList<Point> snakeParts; //FIFO
    public int snakeSpeed;
    public int direction;
    Point tail = new Point();

    public Snake(){
        snakeParts = new LinkedList<>();
        int restWIDTH, restHEIGHT;
        restWIDTH = Snake_Game.WIDTH/2 % 6;
        restHEIGHT = Snake_Game.HEIGHT/2 % 6;
        snakeParts.offer(new Point(Snake_Game.WIDTH/2 - restWIDTH, Snake_Game.WIDTH/2 - restHEIGHT));
        snakeParts.offer(new Point(Snake_Game.WIDTH/2 - restWIDTH + 6, Snake_Game.WIDTH/2 - restHEIGHT));
        snakeParts.offer(new Point(Snake_Game.WIDTH/2 - restWIDTH + 12, Snake_Game.WIDTH/2 - restHEIGHT));

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
            System.out.print("D");
        }
        else if(direction == 2){ // A - left
            snakeParts.getLast().x -= snakeSpeed;
            System.out.print("A");
        }
        else if(direction == 3){ // S - down
            snakeParts.getLast().y += snakeSpeed;
            System.out.print("S");
        }
        else if(direction == 4){ // W - up
            snakeParts.getLast().y -= snakeSpeed;
            System.out.print("W");
        }
    }

    public void snakeAugment(){
        snakeParts.offerFirst(new Point(tail));
    }

    public void setDefault(){
        snakeParts.clear();

        int restWIDTH, restHEIGHT;
        restWIDTH = Snake_Game.WIDTH/2 % 6;
        restHEIGHT = Snake_Game.HEIGHT/2 % 6;
        snakeParts.offer(new Point(Snake_Game.WIDTH/2 - restWIDTH, Snake_Game.WIDTH/2 - restHEIGHT));
        snakeParts.offer(new Point(Snake_Game.WIDTH/2 - restWIDTH + 6, Snake_Game.WIDTH/2 - restHEIGHT));
        snakeParts.offer(new Point(Snake_Game.WIDTH/2 - restWIDTH + 12, Snake_Game.WIDTH/2 - restHEIGHT));

    }
}
