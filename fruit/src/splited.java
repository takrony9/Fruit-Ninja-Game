import javafx.scene.image.ImageView;

public abstract class splited {
    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    String img2;
    String img1;

    public int rand(int min, int max) {

        return (int) (Math.random() * max + min);
    }
    public  ImageView[] drawSplited() {

        ImageView g1 = new ImageView(img1);
        ImageView g2 =  new ImageView(img2);

        ImageView[] g  =new ImageView[2];
        g[0]=g1;
        g[1]=g2;
        g[0].setLayoutX(rand(0, 400));
        g[0].setLayoutY(1);
        g[0].setFitWidth(50);
        g[0].setFitHeight(55);
        g[1].setLayoutX(rand(0, 400));
        g[1].setLayoutY(1);
        g[1].setFitWidth(50);
        g[1].setFitHeight(55);
        return g;
    }

    public double getImageWidth() {
        return ImageWidth;
    }

    public void setImageWidth(double imageWidth) {
        ImageWidth = imageWidth;
    }

    double ImageWidth;





}
