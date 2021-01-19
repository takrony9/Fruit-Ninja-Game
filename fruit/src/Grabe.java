import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Grabe extends splited implements Shape{

    public Grabe(){
        setImageWidth(60);
        setImg1("grape1.png");
        setImg2("grape2.png");
    }

    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }

    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("grape.png");
        f1.setLayoutX(rand(0, 4));
        f1.setLayoutY(500);
        f1.setFitWidth(60);
        f1.setFitHeight(70);
        return f1;
    }












}
