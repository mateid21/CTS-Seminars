package ro.ase.cts.junit.ex2;

// After applying DIP
interface Switchable {
    void turnOn();
}

class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        // logic to turn on the light bulb
    }
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}