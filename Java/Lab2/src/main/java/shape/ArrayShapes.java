package shape;

import java.util.ArrayList;

public class ArrayShapes extends ArrayList<IShape>{

    public void addUnique(IShape shape) {
        boolean shape_exist = false;
        for (IShape s : this) {
            if (s.equals(shape)) shape_exist = true;
        }
        if (!shape_exist) {
            this.add(shape);
            System.out.println("Добавлена новая уникальная фигура!\n");
            shape.toString();
            return;
        }
        System.out.println("Такая фигура уже существует");
    }

}
