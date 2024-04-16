package ro.ase.cts.facade.Example1;

public class DvdPlayer {
    void on() {
        System.out.println("DVD player on");
    }
    void play(String movie) {
        System.out.println("Playing movie " + movie);
    }
    void stop() {
        System.out.println("Stopping movie");
    }
    void eject() {
        System.out.println("Ejecting DVD");
    }
    void off() {
        System.out.println("DVD player off");
    }
}
