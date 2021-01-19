import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AlarmBox {
    public  void Display(Stage Window, Scene scene){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        window.setMinHeight(200);
        window.setX(730);
        window.setY(300);
        Label Massage=new Label("");
        Massage.setText("GAME OVER");
        Button closebtn=new Button("Close");
        closebtn.setOnAction(e -> {
            window.close();
            Window.setScene(scene);

        });
        VBox vlay=new VBox(10);
        vlay.getChildren().addAll(Massage,closebtn);
        vlay.setAlignment(Pos.CENTER);
        Scene vScene=new Scene(vlay);
        vScene.getStylesheets().add("st.css");

        window.setScene(vScene);
        window.show();
    }
}
