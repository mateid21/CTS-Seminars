package ro.ase.cts.lab04.simple_factory;

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a SQUARE.");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a CIRCLE.");
    }
}

class ShapeFactory {
    private static ShapeFactory instance ;

    private ShapeFactory(){}

    public static ShapeFactory getInstance(){
        if(instance == null){
            instance = new ShapeFactory();
        }
        return instance;
    }

    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

public class SimpleFactoryEx2 {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();

        Shape shape1 = shapeFactory.createShape("CIRCLE");
        shape1.draw();

        shape1 = shapeFactory.createShape("SQUARE");
        shape1.draw();
    }
}

