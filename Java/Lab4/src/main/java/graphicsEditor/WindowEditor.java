package graphicsEditor;

import graphicsEditor.components.CanvasEditor;
import graphicsEditor.components.PanelButtons;

import javax.swing.*;
import java.awt.*;

public class WindowEditor {
    private static WindowEditor root = null;

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

                //Добавление полотна для рисования фигур
                addCanvas(root);

                //Панель с кнопками для интерфеса задания рисования фигур
                addPanelButtons(root);

                root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                root.setVisible(true);
            }
        });

    }

    private void addCanvas(JFrame root) {
        root.setContentPane(new CanvasEditor());
    }

    private void addPanelButtons(JFrame root) {
        PanelButtons panel = new PanelButtons();

        Font big_words = new Font("TimesRoman", Font.BOLD, 20);

        JButton button = new JButton("Линия");
        button.setFont(big_words);
        panel.add(button);

        button = new JButton("Квадрат");
        button.setFont(big_words);
        panel.add(button);

        button = new JButton("Круг");
        button.setFont(big_words);
        panel.add(button);

        button = new JButton("Овал");
        button.setFont(big_words);
        panel.add(button);


        root.add(panel);

    }
}
