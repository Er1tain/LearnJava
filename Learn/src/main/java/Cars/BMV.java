package Cars;

public class BMV implements Car{
    private String model;
    private Integer born;
    private  String owner;

    public BMV(String model, Integer born, String owner){
        this.model = model;
        this.born = born;
        this.owner = owner;
    }

    public void Move() {
        System.out.println("BMV moving!!");
    }

    public String[] getInfo() {
        String[] info_about_car = {model, born.toString(), owner};
        return info_about_car;
    }
}
