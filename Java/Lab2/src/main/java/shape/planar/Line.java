package shape.planar;

import shape.IShape;
import shape.Shape;

public class Line extends Shape {
    public Double x1, y1;

    public Line(Double x0, Double y0, Double x1, Double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public Double Perimeter() { //Периметр линии фактически её длина
        Double length = Math.sqrt((x1 - x0)*(x1 - x0) + (y1 - y0)*(y1 - y0));
        return length;
    }

    @Override
    public Double Square() { //У линии нет площади
        return 0.0;
    }

//    @Override
//    public void Fill(String color) {
//        this.color_shape = color;
//    }

    @Override
    public void Move(Double x, Double y) {
        this.x0 += x;
        this.x1 += x;
        this.y0 += y;
        this.y1 += y;
    }

    @Override
    public Double[][] getPoints() {
        Double[][] points = new Double[][]{
                {x0, x1}, {y0, y1}
        };
        return points;
    }

    @Override
    public String getColor() {
        return color_shape;
    }

    @Override
    public String toString() {
        String shape_info;
        shape_info = "Вид: линия\n";
        shape_info += "Точки: " + '(' +this.x0 + "; "+ this.y0 +"), " + "(" + this.x1 + "; " + this.y1 + ")\n";
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
