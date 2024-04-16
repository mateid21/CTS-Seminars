package ro.ase.cts.facade.Example1;

public class Example1 {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Amplifier(),
                new Tuner(), new DvdPlayer(), new Projector(),
                new TheaterLights());
        homeTheater.watchMovie("The Lord of the Rings");
        homeTheater.endMovie();
    }
}
