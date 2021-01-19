import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    int i =0;
    Stopwatch stopwatch = new Stopwatch();
    Stopwatch stopwatch1 = new Stopwatch();
    Stopwatch stopwatch2 = new Stopwatch();
    Stopwatch stopwatch3 = new Stopwatch();
    Stopwatch stopwatch4 = new Stopwatch();
    Stopwatch stopwatch5 = new Stopwatch();
    Stopwatch stopwatch6 = new Stopwatch();
    Stopwatch stopwatch7 = new Stopwatch();
    Label highScore1;
    ShapeFactory shapeFactory = new ShapeFactory();
    Shape strawberry = shapeFactory.getShape("STRAWBERRY");
    Shape grabe = shapeFactory.getShape("GRABE");
    Shape watermelon = shapeFactory.getShape("WATERMELON");
    Shape special1 = shapeFactory.getShape("SPECIAL1");
    Shape special2 = shapeFactory.getShape("SPECIAL2");
    Shape dangerousBomb = shapeFactory.getShape("dangerousBomb");
    Shape fetalBomb = shapeFactory.getShape("fetalBomb");
    Shape BombScore = shapeFactory.getShape("BombScore");
    //Shape specialTimer = shapeFactory.getShape("specialTimer");

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    int flag;

    private static final Integer STARTTIME = 60;
    private Timeline timelineDecrease;
    private Integer timeSeconds = STARTTIME;

    Stage Window;
    Scene welcomeScene;
    Scene Scene1;
    Scene scene2;
    Scene scene3;
    String character;
    List characterArray = new ArrayList();

    public AnimationTimer getTimer() {
        return timer;
    }

    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
    }
    Label scoreLabel;
    AnimationTimer timer;
    AnimationTimer timer1;
    AnimationTimer timer2;
    AnimationTimer timer3;
    Pane root = new Pane();
    List drop = new ArrayList();
    double mouseX;
    double mouseY;
    Circle cont;
    double speed;
    double falling;
    Label lblMissed;
    Label StopWatch;
    int missed;
    public Timeline timeline;
    public Timeline timeline2;
    public Timeline timelineR1;
    public Timeline timelineR2;
    public Timeline timelineR3;
    public Timeline timelineR4;
    public Timeline timelineR5;
    public Timeline timelineR6;
    public Timeline timelineR7;

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public model getC() {
        return c;
    }

    public void setC(model c) {
        this.c = c;
    }

    model c=new model();
    public int rand(int min, int max) {

        return (int) (Math.random() * max);
    }


    public Shape getBombScore() {
        return BombScore;
    }

    public void setBombScore(Shape bombScore) {
        BombScore = bombScore;
    }

    public void start(Stage primaryStage) throws Exception {

        Window = primaryStage;

        //Welcome Scene>>>>>>>>>>
        StackPane welcomePane = new StackPane();
        Button play = new Button("Play");
        Button exit = new Button("Exit");

        welcomePane.setMargin(play, new Insets(300, 200, 0, 0));
        welcomePane.setMargin(exit, new Insets(300, 0, 0, 200));


        ObservableList welcomeList = welcomePane.getChildren();
        welcomeList.addAll(play, exit);

        welcomeScene = new Scene(welcomePane, 800, 550);
        welcomeScene.getStylesheets().add("st1.css");
        Window.setScene(welcomeScene);
        Window.show();

        //scene1>>>>>>>>>>>>>>>>>>>>>>>>
        StackPane pane = new StackPane();

        Image imageLevel1 = new Image(getClass().getResourceAsStream("level1.png"), 150, 150, false, false);
        Button level1 = new Button();
        level1.setGraphic(new ImageView(imageLevel1));

        Image imageLevel2 = new Image(getClass().getResourceAsStream("level2.png"), 150, 150, false, false);
        Button level2 = new Button();
        level2.setGraphic(new ImageView(imageLevel2));

        Image imageLevel3 = new Image(getClass().getResourceAsStream("Level3.png"), 150, 150, false, false);
        Button level3 = new Button();
        level3.setGraphic(new ImageView(imageLevel3));

        Image imageArcade = new Image(getClass().getResourceAsStream("arcade.png"), 150, 150, false, false);
        Button arcadeB = new Button();
        arcadeB.setGraphic(new ImageView(imageArcade));

        int HighScore = c.load();

        highScore1 = new Label("High Score: "+ HighScore );


        welcomePane.setMargin(level1, new Insets(300, 620, 0, 0));
        welcomePane.setMargin(level2, new Insets(300, 220, 0, 0));
        welcomePane.setMargin(level3, new Insets(300, 0, 0, 190));
        welcomePane.setMargin(arcadeB, new Insets(300, 0, 0, 590));

        welcomePane.setMargin(highScore1, new Insets(70, 0, 0, 0));

        ObservableList welcomeList2 = pane.getChildren();
        welcomeList2.addAll(level1, level2, level3,arcadeB,highScore1);
        Scene1 = new Scene(pane, 800, 550);
        Scene1.getStylesheets().add("st2.css");


        //scene2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Image imageP=new Image(getClass().getResourceAsStream("pause.png"),50,50,false,false);
        Button PauseB = new Button();
        PauseB.setGraphic(new ImageView(imageP));
        PauseB.setLayoutX(500);
        PauseB.setLayoutY(320);

        Image imageR=new Image(getClass().getResourceAsStream("resume.png"),50,50,false,false);
        Button ResumeB = new Button();
        ResumeB.setGraphic(new ImageView(imageR));
        ResumeB.setLayoutX(500);
        ResumeB.setLayoutY(320);
        ResumeB.setVisible(false);


        Image imageExit=new Image(getClass().getResourceAsStream("exit.png"),50,50,false,false);
        Button Exit = new Button();
        Exit.setGraphic(new ImageView(imageExit));
        Exit.setLayoutX(5);
        Exit.setLayoutY(320);


        Image imageLives=new Image(getClass().getResourceAsStream("RHeart.png"),30,30,false,false);
        Label lives = new Label();
        lives.setGraphic(new ImageView(imageLives));
        lives.setLayoutX(100);
        lives.setLayoutY(50);

        Image imageTimer=new Image(getClass().getResourceAsStream("timer.png"),30,30,false,false);
        Label timerI = new Label();
        timerI.setGraphic(new ImageView(imageTimer));
        timerI.setLayoutX(5);
        timerI.setLayoutY(10);

        Image imageScore=new Image(getClass().getResourceAsStream("score.png"),30,30,false,false);
        Label scoreI = new Label();
        scoreI.setGraphic(new ImageView(imageScore));
        scoreI.setLayoutX(5);
        scoreI.setLayoutY(50);


        StopWatch = new Label ("00:00:000");
        StopWatch.setLayoutX(35);
        StopWatch.setLayoutY(10);

        lblMissed = new Label(" 3");
        lblMissed.setLayoutX(130);
        lblMissed.setLayoutY(50);

        Label timerLabel = new Label();
        timerLabel.setLayoutX(35);
        timerLabel.setLayoutY(10);

        timerLabel.setText(timeSeconds.toString() );

        scoreLabel = new Label(" 0");
        scoreLabel.setLayoutX(35);
        scoreLabel.setLayoutY(50);

        missed = 3;
        speed = 1;
        falling = 500;
        cont = point();
        c.setCont(cont);
        root.getChildren().addAll(cont, lblMissed,StopWatch,PauseB,ResumeB,lives,timerI,Exit,timerLabel,scoreI,scoreLabel);
        scene2 = new Scene(root,600,400);
        scene2.getStylesheets().add("st.css");


        //set on action for scene 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>
        scene2.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY = e.getY();
            c.setMouseX(mouseX);
            c.setMouseY(mouseY);

        });


        PauseB.setOnAction(e->{

            ResumeB.setVisible(true);
            PauseB.setVisible(false);
            timer.stop();
            timer1.stop();
            timeline.stop();

            if (i==2)
                timelineR1.stop();

            else if (i==3)
                timelineR2.stop();
            else if (i==4)
                timelineR3.stop();
            else if (i==5)
                timelineR4.stop();
            else if (i==6)
                timelineR5.stop();
            else if (i==7)
                timelineR6.stop();
            else if (i==8)
                timelineR7.stop();
            else
                timeline2.stop();

        });

        ResumeB.setOnAction(e->{

            ResumeB.setVisible(false);
            PauseB.setVisible(true);
            timer.start();
            timeline.play();

            if (i==2)
                timelineR1.play();
            else if (i==3)
                timelineR2.play();

            else if (i==4)
                timelineR3.play();
            else if (i==5)
                timelineR4.play();
            else if (i==6)
                timelineR5.play();
            else if (i==7)
                timelineR6.play();
            else if (i==8)
                timelineR7.play();

            else
                timeline2.play();

        });

        Exit.setOnAction(e->{
            Window.setScene(Scene1);
            timer.stop();
            timer1.stop();
            timeline.stop();
            music.stop();

            if (i==2)
                timelineR1.stop();
            else if (i==3)
                timelineR2.stop();
            else if (i==4)
                timelineR3.stop();
            else if (i==5)
                timelineR4.stop();
            else if (i==6)
                timelineR5.stop();
            else if (i==7)
                timelineR6.stop();
            else if (i==8)
                timelineR7.stop();
            else
                timeline2.stop();

             highScore1.setText("High Score: "+ HighScore );

        });


        //Fruits TIMELINES...............................................................
        timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
            speed += falling / 3000;
            drop.add(drawObject());
            c.setFlagr(flag);

            characterArray.add(character);
            c.setDrop(drop);
            root.getChildren().add(((Node) drop.get(drop.size() - 1)));
        }));
        timeline.setCycleCount(500);




        //STOPWATCH timelines......................................................................
        timeline2 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch.change(StopWatch);
            }
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.setAutoReverse(false);


        timelineR1 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch1.change(StopWatch);
            }
        }));
        timelineR1.setCycleCount(Timeline.INDEFINITE);
        timelineR1.setAutoReverse(false);


        timelineR2 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch2.change(StopWatch);
            }
        }));
        timelineR2.setCycleCount(Timeline.INDEFINITE);
        timelineR2.setAutoReverse(false);


        timelineR3 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch3.change(StopWatch);
            }
        }));
        timelineR3.setCycleCount(Timeline.INDEFINITE);
        timelineR3.setAutoReverse(false);


        timelineR4= new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch4.change(StopWatch);
            }
        }));
        timelineR4.setCycleCount(Timeline.INDEFINITE);
        timelineR4.setAutoReverse(false);

        timelineR5 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch5.change(StopWatch);
            }
        }));
        timelineR5.setCycleCount(Timeline.INDEFINITE);
        timelineR5.setAutoReverse(false);

        timelineR6 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch6.change(StopWatch);
            }
        }));
        timelineR6.setCycleCount(Timeline.INDEFINITE);
        timelineR6.setAutoReverse(false);

        timelineR7 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                stopwatch7.change(StopWatch);
            }
        }));
        timelineR7.setCycleCount(Timeline.INDEFINITE);
        timelineR7.setAutoReverse(false);


        timer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                c.setFlagr(flag);
                c.setRoot(root);
                c.gameUpdate(lblMissed,Window,Scene1,timeline,timeline2,timelineR1,timelineR2,timelineR3,timelineR4,timelineR5,timelineR5,timelineR7,timer,scoreLabel,highScore1,1);
            }

        };
        timer1 = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                c.setFlagr(flag);
                c.setRoot(root);
                c.gameUpdate(lblMissed,Window,Scene1,timeline,timeline2,timelineR1,timelineR2,timelineR3,timelineR4,timelineR5,timelineR5,timelineR7,timer1,scoreLabel,highScore1,speed);
            }

        };


        //set on action for scene 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>
        play.setOnAction(event -> {
            Window.setScene(Scene1);

        });
        exit.setOnAction(event -> {
            Window.close();
        });
        level1.setOnAction(event -> {
            flag=0;
            music.play();
            timerLabel.setVisible(false);
            lblMissed.setVisible(true);
            lives.setVisible(true);
            StopWatch.setVisible(true);
            Window.setScene(scene2);
            if (i==0) {
                pplay();
                i++;
            }
            else if (i==1)  {
                c.reset(lblMissed, timeline, timelineR1, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==2) {
                c.reset(lblMissed, timeline, timelineR2, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==3) {
                c.reset(lblMissed, timeline, timelineR3, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==4) {
                c.reset(lblMissed, timeline, timelineR4, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==5) {
                c.reset(lblMissed, timeline, timelineR5, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==6) {
                c.reset(lblMissed, timeline, timelineR6, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==7) {
                c.reset(lblMissed, timeline, timelineR7, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else
            {
                c.reset(lblMissed, timeline, timeline2, timer, StopWatch,PauseB,ResumeB,scoreLabel);

            }
        });
        level2.setOnAction(event -> {
            flag=0;
            music.play();
            timeline.play();
            timer1.start();
            timeline2.play();
            stopwatch.change(StopWatch);

            timerLabel.setVisible(false);
            lblMissed.setVisible(true);
            lives.setVisible(true);
            StopWatch.setVisible(true);
            Window.setScene(scene2);
            if (i==0) {
                pplay();
                i++;
            }
            else if (i==1)  {
                c.reset(lblMissed, timeline, timelineR1, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==2) {
                c.reset(lblMissed, timeline, timelineR2, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==3) {
                c.reset(lblMissed, timeline, timelineR3, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==4) {
                c.reset(lblMissed, timeline, timelineR4, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==5) {
                c.reset(lblMissed, timeline, timelineR5, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==6) {
                c.reset(lblMissed, timeline, timelineR6, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==7) {
                c.reset(lblMissed, timeline, timelineR7, timer1, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else
            {
                c.reset(lblMissed, timeline, timeline2, timer1, StopWatch,PauseB,ResumeB,scoreLabel);

            }
        });
        level3.setOnAction(event -> {
            flag=1;
            music.play();
            timerLabel.setVisible(false);
            lblMissed.setVisible(true);
            lives.setVisible(true);
            StopWatch.setVisible(true);
            Window.setScene(scene2);
            if (i==0) {
                pplay();
                i++;
            }
            else if (i==1)  {
                c.reset(lblMissed, timeline, timelineR1, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==2) {
                c.reset(lblMissed, timeline, timelineR2, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==3) {
                c.reset(lblMissed, timeline, timelineR3, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==4) {
                c.reset(lblMissed, timeline, timelineR4, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==5) {
                c.reset(lblMissed, timeline, timelineR5, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==6) {
                c.reset(lblMissed, timeline, timelineR6, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==7) {
                c.reset(lblMissed, timeline, timelineR7, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else
            {
                c.reset(lblMissed, timeline, timeline2, timer, StopWatch,PauseB,ResumeB,scoreLabel);

            }
        });

        arcadeB.setOnAction(event -> {
            flag=2;
            Window.setScene(scene2);
            lblMissed.setVisible(false);
            lives.setVisible(false);
            StopWatch.setVisible(false);
            timerLabel.setVisible(true);
            music.play();
            if (i==0) {
                pplay();
                i++;
            }
            else if (i==1)  {
                c.reset(lblMissed, timeline, timelineR1, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==2) {
                c.reset(lblMissed, timeline, timelineR2, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==3) {
                c.reset(lblMissed, timeline, timelineR3, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==4) {
                c.reset(lblMissed, timeline, timelineR4, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==5) {
                c.reset(lblMissed, timeline, timelineR5, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==6) {
                c.reset(lblMissed, timeline, timelineR6, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else if (i==7) {
                c.reset(lblMissed, timeline, timelineR7, timer, StopWatch,PauseB,ResumeB,scoreLabel);
                i++;
            }
            else
            {
                c.reset(lblMissed, timeline, timeline2, timer, StopWatch,PauseB,ResumeB,scoreLabel);

            }

            ///////////////////////////


            if (timelineDecrease != null) {
                timelineDecrease.stop();
            }
            timeSeconds = STARTTIME;


            // update timerLabel
            timerLabel.setText(timeSeconds.toString());
            timelineDecrease = new Timeline();
            timelineDecrease.setCycleCount(Timeline.INDEFINITE);
            timelineDecrease.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(0.5),
                            event1 ->  {
                                timeSeconds--;
                                timerLabel.setText(timeSeconds.toString() );
                                if (timeSeconds <= 0 ) {
                                    timelineDecrease.stop();
                                    c.endGame(Window,Scene1,highScore1,timer);
                                }

                            }));
            timelineDecrease.playFromStart();


        });
    }
    public void pplay(){

        timeline.play();
        timer.start();
        timeline2.play();
        stopwatch.change(StopWatch);
    }

    public Circle point () {
        Circle circle = new Circle();
        circle.setLayoutY(1);
        circle.setRadius(6);
        circle.setFill(Color.BLACK);
        return circle;

    }

    public ImageView drawObject () {

        if(flag==0)
        {
        int rn=rand(0,25);
        if (rn==2) {
            character="db";
            return dangerousBomb.draw();
        }
        else if (rn==1) {
            character = "fb";
            return fetalBomb.draw();
        }
        else if (rn >= 3&&rn<9) {
            character = "s";
            return strawberry.draw();
        }
        else if (rn > 9&&rn<15) {
            character = "w";
            return watermelon.draw();
        }
        else if (rn >15&&rn<=17) {
            character = "s1";
            return special1.draw();
        }
        else if (rn >17&&rn<19) {
            character = "s2";
            return special2.draw();
        }
        else {
            character = "g";
            return grabe.draw();
        }
    }
        else if(flag==1){

            int rn=rand(0,25);
            if (rn<5) {
                character="db";
                return dangerousBomb.draw();
            }
            else if (rn<=7&&rn>5) {
                character = "fb";
                return fetalBomb.draw();
            }
            else if (rn > 7&&rn<12) {
                character = "s";
                return strawberry.draw();
            }
            else if (rn > 12&&rn<18) {
                character = "w";
                return watermelon.draw();
            }
            else if (rn >18&&rn<20) {
                character = "s1";
                return special1.draw();
            }
            else if (rn >20&&rn<22) {
                character = "s2";
                return special2.draw();
            }
            else {
                character = "g";
                return grabe.draw();
            }
        }

        else {

            int rn=rand(0,25);
             if (rn<3) {
                character = "sb";
                return BombScore.draw();
            }
            else if (rn > 3&&rn<9) {
                character = "s";
                return strawberry.draw();
            }
            else if (rn > 9&&rn<15) {
                character = "w";
                return watermelon.draw();
            }
            else if (rn >15&&rn<17) {
                character = "s1";
                return special1.draw();
            }
            else if (rn >17&&rn<19) {
                character = "s2";
                return special2.draw();
            }
            else {
                character = "g";
                return grabe.draw();
            }
        }
    }



}

