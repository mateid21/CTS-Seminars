package ro.ase.cts.factory_method;

interface Animal{
    void sound();
}

class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("Woof");
    }
}
class Cat implements Animal{
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

interface AnimalFactory{
    Animal createAnimal();
}

class DogFactory implements AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

public class FMMainEx1 {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.sound();
        Animal cat = new CatFactory().createAnimal();
        cat.sound();
    }
}