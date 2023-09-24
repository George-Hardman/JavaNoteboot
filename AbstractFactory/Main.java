public class Main {

    public static void main(String[] args) {
        AbstractFactory asusFactory = new AsusFactory();
        Gpu asusGpu = asusFactory.createGpu();
        asusGpu.assemble();
    }
}
