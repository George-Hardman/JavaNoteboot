/**
 * A good place to put construction routines so they can be used in various placed across the application.
 */
public class Director {

    public void buildPeugeot(Builder builder){
        builder.brand("Peugeot")
                .id(1111)
                .color("Red")
                .nbrDoors(5)
                .screenType("Wide");
    }

    public void buildVW(Builder builder){
        builder.brand("VW")
                .id(2222)
                .color("Green")
                .nbrDoors(3)
                .screenType("Wide")
                .height(44);
    }
}
