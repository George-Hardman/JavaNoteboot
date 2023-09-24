public class Car {

     Car(int id, String brand, String model, String color, int nbrDoors, String screenType, double weight, double height) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.nbrDoors = nbrDoors;
        this.screenType = screenType;
        this.weight = weight;
        this.height = height;
        System.out.println("Creating a Car!");
    }
    private int id;
    private String brand;
    private String model;
    private String color;
    private int nbrDoors;
    private String screenType;
    private double weight;
    private double height;


}
