package controller;

import gui.Root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Begin implements ActionListener {
    private JPanel panel;

    //Счётчик нажатий
    private boolean count_click = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Кнопка <Начать> была нажата)");
        count_click = !count_click;

        if (count_click) {
            panel.setBackground(Color.RED);
        } else {
            panel.setBackground(Color.YELLOW);
        }
    }

    public Begin(JPanel panel) {
       this.panel = panel;
    }

}
