import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class music {
    private static music ourInstance = new music();

    public static music getInstance() {
        return ourInstance;
    }
    private music() {

    }
    public static MediaPlayer Player;

    public static void play()
    {
        String uriString = new File("src\\fruit ninja.mp3").toURI().toString();
        Player = new MediaPlayer( new Media(uriString));
        Player.play();
    }
    public static   void stop()
    {
        Player.stop();
    }
    public static void playslide()
    {
        String uriString = new File("src\\69477__aboe__knifesha1.wav").toURI().toString();
        MediaPlayer Player = new MediaPlayer( new Media(uriString));
        Player.play();
    }
    public static void playbomb()
    {
        String uriString = new File("src\\435416__v-ktor__explosion13.wav").toURI().toString();
        MediaPlayer Player = new MediaPlayer( new Media(uriString));
        Player.play();
    }

    public static void playgameover()
    {
        String uriString = new File("src\\253886__themusicalnomad__negative-beeps.wav").toURI().toString();
        MediaPlayer Player = new MediaPlayer( new Media(uriString));
        Player.play();
    }
}
