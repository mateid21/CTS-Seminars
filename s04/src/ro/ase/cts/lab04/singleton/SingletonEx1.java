package ro.ase.cts.lab04.singleton;

public class SingletonEx1 {
    private static SingletonEx1 instance ;

    private SingletonEx1(){}
    public static SingletonEx1 getInstance(){
        if(instance == null){
            instance = new SingletonEx1();
        }
        return instance;
    }

    public void doSomething(){
        System.out.println("Singleton is doing something");
    }
}

class MainEx1 {
    public static void main(String[] args) {
        SingletonEx1 singletonInstance = SingletonEx1.getInstance();

        singletonInstance.doSomething();
    }
}