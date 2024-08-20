package shape;

import java.util.Map;

public abstract class Shape implements IShape{
    protected Double x0, y0; //Начальная точка фигуры
    protected String color_shape;

    public abstract Double Square();
    public abstract Double Perimeter();

    public abstract void Move(Double delta_x, Double delta_y);
    public void Fill(String color) {
        this.color_shape = color_shape;
    }
    public abstract String toString();

    public Double[] getBeginPoint() {
        return new Double[]{x0, y0};
    }


}
