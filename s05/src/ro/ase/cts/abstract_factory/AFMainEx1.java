package ro.ase.cts.abstract_factory;

interface Chair{
    String sitOn();
}

class ModernChair implements Chair{
    @Override
    public String sitOn() {
        return "Sitting on a modern chair";
    }
}
class VictorianChair implements Chair{
    @Override
    public String sitOn() {
        return "Sitting on a victorian chair";
    }
}

interface Sofa{
    String lieOn();
}

class ModernSofa implements Sofa{
    @Override
    public String lieOn() {
        return "Lying on a modern sofa";
    }
}

class VictorianSofa implements Sofa{
    @Override
    public String lieOn() {
        return "Lying on a victorian sofa";
    }
}

interface FurnitureFactory{
    Chair createChair();
    Sofa createSofa();
}

class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
class VictorianFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class Client{
    private final FurnitureFactory furnitureFactory;

    public Client(FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    public void useFurniture(){
        Chair chair = furnitureFactory.createChair();
        System.out.println(chair.sitOn());
        Sofa sofa = furnitureFactory.createSofa();
        System.out.println(sofa.lieOn());
    }
}

public class AFMainEx1 {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();

        System.out.println("Modern furniture:");
        Client modernClient = new Client(modernFactory);
        modernClient.useFurniture();

        System.out.println();

        System.out.println("Victorian furniture:");
        Client victorianClient = new Client(victorianFactory);
        victorianClient.useFurniture();
    }
}
