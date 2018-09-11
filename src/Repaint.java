

public class Repaint implements Runnable {

    Snake_Game game;
    public Repaint(Snake_Game game){
        this.game = game;
    }
    @Override
    public void run() {
        game.repaint();
    }
}
