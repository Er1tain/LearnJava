package graphicsEditor;

import javax.swing.*;
import java.awt.*;

public class WindowEditor extends JFrame {
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

                root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                root.setVisible(true);
            }
        });

    }
}
