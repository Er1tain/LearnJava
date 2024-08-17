package Cars;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        //Ввод данных
        Scanner in = new Scanner(System.in);

        String model, owner;
        Integer born;
        model = in.nextLine();
        born = parseInt(in.nextLine());
        owner = in.nextLine();

        BMV my_car = new BMV(model, born, owner);
        System.out.println(my_car.getInfo());
    }
}