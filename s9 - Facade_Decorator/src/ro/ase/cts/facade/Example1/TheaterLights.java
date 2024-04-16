package ro.ase.cts.facade.Example1;

public class TheaterLights {
    void on() {
        System.out.println("Theater lights on");
    }

    void off() {
        System.out.println("Theater lights off");
    }

    void dim(int level) {
        System.out.println("Dimming lights to " + level + "%");
    }
}
