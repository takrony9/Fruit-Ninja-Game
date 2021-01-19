import javafx.application.Application;
import javafx.stage.Stage;

public class GameMain extends Application {
    Game game=new Game();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        game.start(primaryStage);
    }
}
