import javafx.scene.image.ImageView;

import java.awt.*;

public interface Shape {
    ImageView draw();

    int rand ( int min, int max);
}