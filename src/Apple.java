import java.awt.*;
import java.util.Random;

public class Apple {
    Point a;
    Random random;
    public static int score;
    public Apple(){
        setApple();
        score = 0;
    }

    public void setApple() {
        score++;
        random = new Random();
        int rand = random.nextInt((Snake_Game.WIDTH/2) + 1);
        int rest = rand % 6;
        int  x = rand - rest;

        rand = random.nextInt((Snake_Game.HEIGHT/2) + 1);
        rest = rand % 6;
        int y = rand - rest;

        this.a = new Point(x, y);
    }


}
