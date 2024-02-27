interface Vehicle {
    double calcValue();
}
class Car implements Vehicle
{
    double v;

    @Override
    public double calcValue() {
        return v * 0.8;
    }
}

class Bike implements Vehicle {
    double v;

    @Override
    public double calcValue() {
        return v * 0.5;
    }
}