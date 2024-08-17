package org.example;

import gui.Root;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Root root = new Root("Главное", 700, 500);
        JPanel panel = root.addPanel();

        JButton Begin_btn = root.addButton(panel,"Начать");
        JButton End_btn = root.addButton(panel, "Закончить");

        root.Run();
    }
}