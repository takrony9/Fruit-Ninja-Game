import javafx.scene.image.ImageView;

public class Special1 extends splited implements Shape {
    public Special1(){
        setImageWidth(48);
        setImg1("special1-1.png");
        setImg2("special1-2.png");
    }


    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }


    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("Special1.png");
        f1.setLayoutX(rand(0, 3));
        f1.setLayoutY(500);
        f1.setFitWidth(48);
        f1.setFitHeight(70);
        return f1;
    }
}
