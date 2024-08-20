package graphicsEditor;

import graphicsEditor.components.CanvasEditor;
import graphicsEditor.components.PanelButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class WindowEditor {
    private static WindowEditor root = null;

    private JFrame app;

    public static WindowEditor start(String title, int width, int height) {
        if (root == null) {
            root = new WindowEditor(title, width, height);
            return root;
        }
        System.out.println("Текстовый редактор уже запущен!");
        return null;
    }

    private WindowEditor(String title, int width, int height) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame root = new JFrame(title);
                root.setSize(width, height);

                //Сгрупируем полотно и панель с кнопками
                JPanel group = new JPanel();
                BoxLayout box = new BoxLayout(group, BoxLayout.Y_AXIS);
                group.setLayout(box);

                //Добавление полотна для рисования фигур
                CanvasEditor canvas = new CanvasEditor("Овал");
                group.add(canvas);

                //Панель с кнопками для интерфеса задания рисования фигур
                addPanelButtons(group);
                root.add(group);

                root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                root.setVisible(true);

                app = root;
            }
        });

    }


    private void addPanelButtons(JPanel container) {
        PanelButtons panel = new PanelButtons();

        Font big_words = new Font("TimesRoman", Font.BOLD, 20);

        JButton button = new JButton("Линия");
        button.setFont(big_words);
        button.addActionListener(drawFigure("Линия", panel));
        panel.add(button);

        button = new JButton("Квадрат");
        button.setFont(big_words);
        button.addActionListener(drawFigure("Квадрат", panel));
        panel.add(button);

        button = new JButton("Круг");
        button.setFont(big_words);
        panel.add(button);

        button = new JButton("Овал");
        button.setFont(big_words);
        button.addActionListener(drawFigure("Овал", panel));
        panel.add(button);


        container.add(panel);
    }

    private ActionListener drawFigure(String figure, PanelButtons panel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.getContentPane().removeAll();

                //Сгрупируем полотно и панель с кнопками
                JPanel group = new JPanel();
                BoxLayout box = new BoxLayout(group, BoxLayout.Y_AXIS);
                group.setLayout(box);

                group.add(new CanvasEditor(figure));
                group.add(panel);

                app.add(group);
                app.repaint();
                app.revalidate();
            }
        };
    }
}
