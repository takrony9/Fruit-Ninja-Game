import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BombScore extends splited implements Shape {

    public BombScore() {
        setImageWidth(47);
        setImg1("bomb1-1.png");
        setImg2("bomb1-2.png");
    }

    @Override
    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("BombScore.png");
        f1.setLayoutX(rand(0, 4));
        f1.setLayoutY(500);
        f1.setFitWidth(47);
        f1.setFitHeight(70);
        return f1;

    }
}
