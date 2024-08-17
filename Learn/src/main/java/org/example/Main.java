package org.example;

import Cars.BMV;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        //Ввод данных
        Scanner in = new Scanner(System.in);

        String model, owner;
        Integer born;
        model = in.nextLine();
        try {
            born = parseInt(in.nextLine());
            if ((born <= 2000) || (born >= 2024)) {
                throw new Exception("False year");
            }
        } catch (Exception e) {
            System.out.println("Year only from 2000 to current year!");
            return;
        }
        owner = in.nextLine();

        BMV my_car = new BMV(model, born, owner);
        System.out.println(my_car.getInfo());
    }
}