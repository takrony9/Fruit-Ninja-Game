import javafx.scene.image.ImageView;

import javax.naming.Context;

public class FatalBomb extends splited implements Ibomb, Shape{
public FatalBomb()
{
    setImageWidth(52);
}

    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }


    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("bomb1.png");
        f1.setLayoutX(rand(0, 2));
        f1.setLayoutY(500);
        f1.setFitWidth(52);
        f1.setFitHeight(70);
        return f1;
    }



    @Override
    public int doAction(Types type , int lives) {
    lives=0;
        type.setState(this);
        return lives;
    }
}

