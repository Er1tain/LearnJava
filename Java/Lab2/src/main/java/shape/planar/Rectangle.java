package shape.planar;

import shape.IShape;
import shape.Shape;

public class Rectangle extends Shape {
    private Double[][] points = new Double[2][3]; //Точки прямоугольника, кроме главной

    public Rectangle(Double x0, Double y0,Double[][] points) {
        //Проверка на то, что введены координаты 3х точек
        try{
            if ((points.length != 3) || (points[0].length != 2)) {
                throw new Exception("Должны быть введены 3 точки размерностью 2");
            }
            this.x0 = x0;
            this.y0 = y0;
            this.points = points;
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Double Perimeter() {
        Double side1, side2, side3, side4;

        side1 = Math.sqrt((x0 - points[0][0])*(x0 - points[0][0]) + (y0 - points[0][1])*(y0 - points[0][1]));
        side2 = Math.sqrt((points[1][0] - points[0][0])*(points[1][0] - points[0][0]) + (points[1][1] - points[0][1])*(points[1][1] - points[0][1]));
        side3 = Math.sqrt((points[1][0] - points[2][0])*(points[1][0] - points[2][0]) + (points[1][1] - points[2][1])*(points[1][1] - points[2][1]));
        side4 = Math.sqrt((x0 - points[2][0])*(x0 - points[2][0]) + (y0 - points[2][1])*(y0 - points[2][1]));

        return side1 + side2 + side3 + side4;

    }

    @Override
    public Double Square() {
        Double side1, side2;

        side1 = Math.sqrt((x0 - points[0][0])*(x0 - points[0][0]) + (y0 - points[0][1])*(y0 - points[0][1]));
        side2 = Math.sqrt((points[1][0] - points[0][0])*(points[1][0] - points[0][0]) + (points[1][1] - points[0][1])*(points[1][1] - points[0][1]));

        return side1 * side2;
    }

    @Override
    public void Move(Double delta_x, Double delta_y) {
        this.x0 += delta_x; this.y0 += delta_y;
        for (Double[] p:this.points) {
            p[0] += delta_x;
            p[1] += delta_y;
        }
    }

    @Override
    public void Fill(String color) {
        this.color_shape = color;
    }

    @Override
    public String getColor() {
        return color_shape;
    }

    @Override
    public Double[][] getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        String shape_info;
        shape_info = "Вид: Прямоугольник\n";

        //Точки
        shape_info += "Точки: " + '(' +this.x0 + "; "+ this.y0 + ")\n";
        for (Double[] point : this.points) {
            shape_info += "Точки: " + '(' +point[0] + "; "+ point[1] + ") ";
        }

        shape_info += "\nЦвет: " + this.color_shape;

        return shape_info;
    }

    @Override
    public Boolean equals(IShape shape) {
        Boolean flag = true;
        flag = ((this.getPoints() == shape.getPoints()) && flag);
        flag = ((this.getBeginPoint() == shape.getBeginPoint()) && flag);
        flag = (flag && (this.getColor() == shape.getColor()));

        return flag;
    }

}
