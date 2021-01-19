import javafx.scene.image.ImageView;

public class SpecialTimer extends splited implements Shape  {
    @Override
    public ImageView draw() {
        ImageView f1 = new ImageView("specialTimer.png");
        f1.setLayoutX(rand(0, 350));
        f1.setLayoutY(500);
        f1.setFitWidth(100);
        f1.setFitHeight(110);
        return f1;
    }

    @Override
    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }


}
