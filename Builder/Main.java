public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.buildPeugeot(carBuilder);
        Car peugeot = carBuilder.build();

        CarSchemaBuilder carSchemaBuilder = new CarSchemaBuilder();
        director.buildPeugeot(carSchemaBuilder);
        CarSchema peugeotManual = carSchemaBuilder.build();
    }
}
