import javafx.scene.image.ImageView;

public class Strawberry extends splited implements Shape {
    public  Strawberry(){
        setImageWidth(51);
        setImg1("strawberry1.png");
        setImg2("strawberry2.png");
    }
    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }

    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("strawberry.png");
        f1.setLayoutX(rand(0, 1));
        f1.setLayoutY(500);
        f1.setFitWidth(51);
        f1.setFitHeight(70);
        return f1;
    }
}
