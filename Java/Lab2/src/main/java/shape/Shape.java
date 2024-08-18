package shape;

import java.util.Map;

public abstract class Shape implements IShape{
    protected Double x0, y0; //Начальная точка фигуры
    protected String color_shape;

    public abstract Double Square();
    public abstract Double Perimeter();

    public abstract void Move(Double delta_x, Double delta_y);
    public  abstract void Fill(String color);
    public abstract String toString();

    public Double[] getBeginPoint() {
        return new Double[]{x0, y0};
    }
}
