public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("STRAWBERRY")) {
            return new Strawberry();
        } else if (shapeType.equalsIgnoreCase("GRABE")) {
            return new Grabe();
        } else if (shapeType.equalsIgnoreCase("WATERMELON")) {
            return new Watermelon();
        } else if (shapeType.equalsIgnoreCase("SPECIAL1")) {
            return new Special1();
        } else if (shapeType.equalsIgnoreCase("SPECIAL2")) {
            return new Special2();
        } else if (shapeType.equalsIgnoreCase("fetalBomb")) {
            return new FatalBomb();
        } else if (shapeType.equalsIgnoreCase("dangerousBomb")) {
            return new DangerousBomb();
        } else if (shapeType.equalsIgnoreCase("bombScore")) {
            return new BombScore();
        }  else
            return null;
    }
}
