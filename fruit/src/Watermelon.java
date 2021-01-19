import javafx.scene.image.ImageView;

public class Watermelon extends splited implements Shape{
    public Watermelon(){
        setImageWidth(53);
        setImg1("watermelon1.png");
        setImg2("watermelon2.png");

    }
    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }

    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("watermelon.png");
        f1.setLayoutX(rand(0, 3));
        f1.setLayoutY(500);
        f1.setFitWidth(53);
        f1.setFitHeight(70);
        return f1;
    }
}
