package ro.ase.cts.facade.Example1;

public class Amplifier {
    void on() {
        System.out.println("Amplifier on");
    }

    void off() {
        System.out.println("Amplifier off");
    }

    void setDvd(DvdPlayer dvd) {
        System.out.println("Setting DVD player to " + dvd);
    }

    void setVolume(int volume) {
        System.out.println("Setting volume to " + volume);
    }
}
