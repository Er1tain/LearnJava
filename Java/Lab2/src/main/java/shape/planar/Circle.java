package shape.planar;

import shape.IShape;
import shape.Shape;

public class Circle extends Shape {
    private Double radius = 0.0;

    public Circle(Double x0, Double y0, Double radius) {
        this.x0 = x0;
        this.y0 = y0;
        if (radius > 0) this.radius = radius;
    }

    @Override
    public Double Perimeter() {
        Double P = Math.PI * 2 * radius;
        return P;
    }

    @Override
    public Double Square() {
        Double S = Math.PI * radius * radius;
        return S;
    }

    @Override
    public void Move(Double delta_x, Double delta_y) {
        this.x0 += delta_x; this.y0 += delta_y;
    }

//    @Override
//    public void Fill(String color) {
//        this.color_shape = color;
//    }

    @Override
    public Double[][] getPoints() {
        return new Double[][]{
                {this.x0, this.y0}
        };
    }

    @Override
    public String getColor() {
        return this.color_shape;
    }

    @Override
    public String toString() {
        String shape_info;
        shape_info = "Вид: Окружность\n";
        shape_info += "Центр: (" + this.x0 + "; " + this.y0 +"\n";
        shape_info += "Цвет: " + this.color_shape;

        return shape_info;
    }

    @Override
    public Boolean equals(IShape shape) {
        Boolean flag = true;
        flag = ((this.getBeginPoint() == shape.getBeginPoint()) && flag);
        flag = ((this.getPoints() == shape.getPoints()) && flag);
        flag = (flag && (this.getColor() == shape.getColor()));

        return flag;
    }
}
