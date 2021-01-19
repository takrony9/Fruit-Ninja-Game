import javafx.scene.image.ImageView;

public class Special2 extends splited implements Shape {
    public Special2(){
        setImageWidth(49);
        setImg1("special2-1.png");
        setImg2("special2-2.png");
    }
    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }

    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("special2.png");
        f1.setLayoutX(rand(0, 3));
        f1.setLayoutY(500);
        f1.setFitWidth(49);
        f1.setFitHeight(70);
        return f1;
    }
}
