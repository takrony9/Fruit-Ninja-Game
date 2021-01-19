
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class model {
    Stopwatch stopwatch = new Stopwatch();
    ScoreContext context1 = new ScoreContext(new RegularScore());
    ScoreContext context2 = new ScoreContext(new SpecialScore());
    ScoreContext context3 = new ScoreContext(new DecrementScore());
    Types types = new Types();
    AlarmBox alarmBox=new AlarmBox();
    double mouseX;
    double mouseY;
    Circle cont;
    Strawberry strawberry=new Strawberry();
    Grabe grabe=new Grabe();
    Watermelon watermelon=new Watermelon();
    Special1 special1=new Special1();
    Special2 special2=new Special2();
    FatalBomb fatalBomb=new FatalBomb();
    DangerousBomb dangerousBomb=new DangerousBomb();
    ImageView j,f;
    ImageView h;
    ImageView d;
    int live=3;
    int HighScore ;

    public int getFlagr() {
        return flagr;
    }

    public void setFlagr(int flagr) {
        this.flagr = flagr;
    }

    int flagr;
    int test;
    Pane root = new Pane();
    List drop = new ArrayList();
   public int scoree =0;
    double xl;

    public List getCharacterArray() {
        return characterArray;
    }

    public void setCharacterArray(List characterArray) {
        this.characterArray = characterArray;
    }

    ImageView[] m= new ImageView[2];
    List characterArray = new ArrayList();

    public int getMissed() {
        return live;
    }

    public void setMissed(int live) {
        this.live = live;
    }
BombScore bombScore = new BombScore();



    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }


    public List getDrop() {
        return drop;
    }

    public void setDrop(List drop) {
        this.drop = drop;
    }

    public Circle getCont() {
        return cont;
    }

    public void setCont(Circle cont) {
        this.cont = cont;
    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }
    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }

    public int rand(int min, int max) {

        return (int) (Math.random() * max   );
    }
    double x=rand(0,50),y=500;
    int flag=0;
    List splited=new ArrayList();

    public void goup(ImageView v){
        xl=20;
        while (   v.getLayoutY()<500){
            v.setLayoutY(xl);
            xl=xl+20;
        }

    }
    ImageView img;
    public void reset (Label lblMissed, Timeline timeline, Timeline timelineR, AnimationTimer timer, Label StopWatch, Button PauseB,Button ResumeB , Label score) {

        live=3;
        PauseB.setVisible(true);
        ResumeB.setVisible(false);
        lblMissed.setText(" " + String.valueOf(live));
        timeline.play();
        timer.start();
        timelineR.play();
        score.setText(" 0");
        scoree=0;
        stopwatch.change(StopWatch);
    }

    public String getGrabLocation() {
        return grabLocation;
    }

    public void setGrabLocation(String grabLocation) {
        this.grabLocation = grabLocation;
    }

    String grabLocation;
    int g=rand(0,400);
    int flagbomb=0;

    public void gameUpdate (Label lblMissed, Stage Window, Scene scene, Timeline timeline, Timeline timeline2,Timeline timelineR1,Timeline timelineR2,Timeline timelineR3,Timeline timelineR4,Timeline timelineR5,Timeline timelineR6,Timeline timelineR7, AnimationTimer timer , Label score,Label highScore1,double speed ) {
        cont.setLayoutX(mouseX);
        cont.setLayoutY(mouseY);

        for(int i=0;i<drop.size();i++){
            img=(ImageView) drop.get(i);
            double width=(img).getFitWidth();
            double higth=(img).getFitHeight();

            if(grabe.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
            {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 50;
                y = ((x - 320) * (x - 320) / (300));
            }
            else if(watermelon.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
            {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 30;
                y = ((x - 190) * (x - 190) / (350));
            }
            else if(strawberry.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
            {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 30;
                y = ((x - 230) * (x - 230) / (400));
            }
            else if(special2.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
            {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 50;
                y = ((x - 200) * (x - 200) / (300));
            }
            else if(special1.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
            {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 50;
                y = ((x - 250) * (x - 250) / (300));
            }
            else if(dangerousBomb.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
            {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 50;
                y = ((x - 300) * (x - 300) / (300));
            }
            else {
                x = (img).getLayoutX() + speed + (img).getLayoutX() / 50;
                y = ((x - 280) * (x - 280) / (300));
            }

            (img).setLayoutY(y);
            (img).setLayoutX(x);
             flagbomb=0;
            if ( cont.getLayoutX() > (img).getLayoutX() && ((img).getLayoutX()+width > cont.getLayoutX() + 6) && (img).getLayoutY() < cont.getLayoutY() && (img).getLayoutY()+higth > cont.getLayoutY() + 6)
            {
                root.getChildren().remove(j);
                root.getChildren().remove(f);
                root.getChildren().remove(((ImageView) drop.get(i)));
                if(grabe.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playslide();
                    m = grabe.drawSplited();
                    scoree=context1.excuteScore(scoree);
                    score.setText(" "+ scoree);
                }
                else if(watermelon.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playslide();
                    m=watermelon.drawSplited();
                    scoree=context1.excuteScore(scoree);
                    score.setText(" "+ scoree);

                }
                else if(strawberry.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playslide();

                    m=strawberry.drawSplited();
                    scoree=context1.excuteScore(scoree);
                    score.setText(" "+ scoree);

                }
                else if(special2.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playslide();
                    m=special2.drawSplited();
                    scoree=context2.excuteScore(scoree);
                    score.setText(" "+ scoree);

                }
                else if(special1.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playslide();

                    m=special1.drawSplited();
                   scoree=context2.excuteScore(scoree);
                    score.setText(" "+ scoree);

                }
                else if(dangerousBomb.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playbomb();

                    m=dangerousBomb.drawSplited();
                  live=  dangerousBomb.doAction(types,live);
                    lblMissed.setText(" " + String.valueOf(live));
                    if (live == 0) {
                        music.stop();
                        music.playgameover();
                        timeline.stop();
                        timeline2.stop();
                        timelineR1.stop();
                        timelineR2.stop();
                        timelineR3.stop();
                        timelineR4.stop();
                        timelineR5.stop();
                        timelineR6.stop();
                        timelineR7.stop();
                        timer.stop();

                        lblMissed.setText(" 0 ");
                        alarmBox.Display(Window, scene);
                        test=load();
                        System.out.println(test);
                        System.out.println(scoree);
                        System.out.println(HighScore);
                        if(test<scoree) {
                            HighScore = scoree;
                            save();
                            highScore1.setText("High Score: "+ scoree );
                        }
                    }
                }
                else if(fatalBomb.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playbomb();

                    m=dangerousBomb.drawSplited();
                    live=fatalBomb.doAction(types,live);
                    lblMissed.setText(" " + String.valueOf(live));
                    if (live == 0) {
                        music.stop();
                        music.playgameover();
                        timeline.stop();
                        timeline2.stop();
                        timelineR1.stop();
                        timelineR2.stop();
                        timelineR3.stop();
                        timer.stop();
                        lblMissed.setText(" 0 ");
                        alarmBox.Display(Window, scene);
                    }
                }
                else if(bombScore.getImageWidth()==((ImageView) drop.get(i)).getFitWidth())
                {
                    music.playbomb();
                    m= bombScore.drawSplited();
                    scoree=context3.excuteScore(scoree);
                    score.setText(" "+ scoree);

                       /* test=load();
                        if(test<scoree) {
                            HighScore = scoree;
                            save();
                            highScore1.setText("High Score: "+ scoree );
                        }*/
                    }

                drop.remove(i);
               j=m[0];
                f=m[1];
                j.setLayoutX(cont.getLayoutX()-30);
                f.setLayoutX(cont.getLayoutX()+30);
                j.setLayoutY(cont.getLayoutY());
                f.setLayoutY(cont.getLayoutY());
                splited.add(j);
                splited.add(f);
                root.getChildren().add(j);
                root.getChildren().add(f);
            }

            //LIVES>>>>>>>>>>>>>>>>>>>>>>>>>>>
            else if ((img).getLayoutX() > 600) {

                if (flagr == 0 || flagr == 1){
                    if (dangerousBomb.getImageWidth() != ((ImageView) drop.get(i)).getFitWidth() && fatalBomb.getImageWidth() != ((ImageView) drop.get(i)).getFitWidth()) {
                        root.getChildren().remove(((ImageView) drop.get(i)));
                        drop.remove(i);
                        live--;
                        lblMissed.setText(" " + String.valueOf(live));
                        if (live == 0) {
                            music.stop();
                            music.playgameover();

                            timeline.stop();
                            timeline2.stop();
                            timelineR1.stop();
                            timelineR2.stop();
                            timelineR3.stop();
                            timer.stop();
                            lblMissed.setText(" 0 ");
                            alarmBox.Display(Window, scene);
                            test = load();
                            if (test < scoree) {
                                HighScore = scoree;
                                save();
                                highScore1.setText("High Score: " + scoree);
                            }
                        }
                    }
                }
                else if( flagr==2) {
                        root.getChildren().remove(((ImageView) drop.get(i)));
                        drop.remove(i);
                   /* if (live == 0) {
                        music.stop();
                        music.playgameover();

                        timeline.stop();
                        timeline2.stop();
                        timelineR1.stop();
                        timelineR2.stop();
                        timelineR3.stop();
                        timer.stop();
                        lblMissed.setText(" 0 ");
                        alarmBox.Display(Window, scene);
                        test = load();
                        System.out.println(test);
                        System.out.println(scoree);
                        System.out.println(HighScore);
                        if (test < scoree) {
                            HighScore = scoree;
                            save();
                            highScore1.setText("High Score: " + scoree);
                        }
                    }*/

                    }
            }


            if(splited.isEmpty()!=true){

                j.setLayoutY( j.getLayoutY() + speed  + j.getLayoutY() /20);
                j.setLayoutX(j.getLayoutX() + speed*3 + j.getLayoutX() /500);
                f.setLayoutY( f.getLayoutY() + speed  + f.getLayoutY() /20);
                f.setLayoutX(f.getLayoutX() + speed +f.getLayoutX() /100);

            }



        }





    }


    public void endGame(Stage Window, Scene scene,Label highScore1, AnimationTimer timer){
            music.stop();
            music.playgameover();
            timer.stop();
            alarmBox.Display(Window, scene);
            test = load();
            if (test < scoree) {
                HighScore = scoree;
                save();
                highScore1.setText("High Score: " + scoree);
            }
    }

    public void save() {
        final String xml = "HighScore.xml";
        Document dom;
        Element e = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

            // create the root element
            Element rootEle = dom.createElement("HighScore");

            // create data elements and place them under root
            e = dom.createElement("HighScore");
            e.appendChild(dom.createTextNode(String.valueOf(HighScore)));
            rootEle.appendChild(e);
            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                // send DOM to file
                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
    public int load() {
        final String xml_file = "HighScore.xml";
        ArrayList<Integer> rolev;
        rolev = new ArrayList<Integer>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(xml_file);
            Element doc = dom.getDocumentElement();

            HighScore = Integer.parseInt(getTextValue(String.valueOf(HighScore), doc, "HighScore"));
            if (HighScore != 0) {
                rolev.add(HighScore);
            }

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return HighScore;
    }
    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

}
