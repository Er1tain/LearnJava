package shape;

public interface IShape {
    Double[] getBeginPoint();
    Double[][] getPoints();
    String getColor();
    Boolean equals(IShape shape);
}
