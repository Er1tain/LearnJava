package org.example;

import shape.ArrayShapes;
import shape.IShape;
import shape.planar.Circle;
import shape.planar.Line;
import shape.planar.Rectangle;

public class Main {
    public static void main(String[] args) {
        ArrayShapes array_shapes = new ArrayShapes();

        //Задаём фигуры
        IShape line1 = new Line(21.0, 1.0, 2.5, -4.0);
        IShape line2 = new Line(1.0, 1.0, 2.5, -4.0);
        IShape line3 = new Line(-5.213, 1.56, -27.1, 41.3);

        IShape rect1 = new Rectangle(0.0, 0.0, new Double[][]{
                {-53.1, -5.184}, {32.9, 34.184}, {3.17, 5.184}
        });
        IShape rect2 = new Rectangle(1.5, -0.12, new Double[][]{
                {3.1, -5.184}, {32.9, 34.1084}, {3.17, 5.184}
        });

        IShape circ1 = new Circle(1.5, 3.12, 34.1);
        IShape circ2 = new Circle(-23.1, 9.0, 34.1);

        IShape circ3 = new Circle(1.5, 3.12, 34.1);

        array_shapes.addUnique(line1); array_shapes.addUnique(line2); array_shapes.addUnique(line3);

        array_shapes.addUnique(rect1); array_shapes.addUnique(rect2);

        array_shapes.addUnique(circ1); array_shapes.addUnique(circ2); array_shapes.addUnique(circ3);
        circ1.Fill("red"); circ2.Fill("lime"); circ3.Fill("red");
    }
}