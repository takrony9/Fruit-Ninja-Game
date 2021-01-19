import javafx.animation.AnimationTimer;

public class controoler {
    model m=new model();
    Game game=new Game();
    AnimationTimer timer;
    public void contact(){
        timer   = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                game.getC().setRoot(game.getRoot());
               game.c.gameUpdate(game.lblMissed,game.Window,game.Scene1,game.timeline,game.timeline2,game.timelineR1,game.timelineR2,game.timelineR3,game.timelineR4,game.timelineR5,game.timelineR5,game.timelineR7,timer,game.scoreLabel,game.highScore1,1);
            }

        };

        game.setTimer(timer);

    }



}
