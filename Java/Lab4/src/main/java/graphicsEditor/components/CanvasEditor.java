package graphicsEditor.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;

//Полотно для рисования фигур
public class CanvasEditor extends JPanel {
    private String figure;

    public CanvasEditor(String type_figure) {
        this.figure = type_figure;
        setBackground(new Color(227, 227, 227));
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
        switch (figure) {
            case "Квадрат":
                g.setColor(Color.red);
                // Рисуем квадрат
                g.fillRect(350, 50, 100, 100);
                break;
            case "Линия":
                g.setColor(Color.blue);

                g.drawLine(150, 50, 850, 180);
                break;
            case "Круг":
                break;
            case "Овал":
                g.setColor(Color.pink);

                g.fillOval(150, 50, 450, 180);
                break;
        }


    }

}
