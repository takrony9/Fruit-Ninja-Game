import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.naming.Context;

public class DangerousBomb extends splited implements Ibomb, Shape{
public DangerousBomb(){
    setImageWidth(50);
      setImg1("bomb1-1.png");
      setImg2("bomb1-2.png");
}

    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }


    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("bomb2.png");
        f1.setLayoutX(rand(0, 2));
        f1.setLayoutY(500);
        f1.setFitWidth(50);
        f1.setFitHeight(70);
        return f1;
    }

    @Override
    public int doAction(Types type , int lives) {
    lives--;
        type.setState(this);
return lives;
    }
}
