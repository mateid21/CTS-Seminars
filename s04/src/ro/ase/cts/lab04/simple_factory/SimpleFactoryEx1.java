package ro.ase.cts.lab04.simple_factory;

interface Animal {
    void sound();
}

//concrete Product 1
class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog is barking");
    }
}

//concrete Product 2
class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat is meowing");
    }
}

class AnimalFactory {
    private static AnimalFactory instance ;

    private AnimalFactory(){}

    public static AnimalFactory getInstance(){
        if(instance == null){
            instance = new AnimalFactory();
        }
        return instance;
    }

    public static Animal createAnimal(String type) {
        if("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if("Cat".equalsIgnoreCase(type)) {
            return new Cat();
        }else{
            throw new IllegalArgumentException("No such animal");
        }
    }
}
public class SimpleFactoryEx1 {
    public static void main(String[] args) {
        AnimalFactory animalFactory = AnimalFactory.getInstance();

        Animal genericAnimal = animalFactory.createAnimal("Dog");
        genericAnimal.sound();

        genericAnimal = animalFactory.createAnimal("Cat");
        genericAnimal.sound();
    }
}
