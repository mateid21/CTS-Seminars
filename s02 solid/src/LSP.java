interface isSquare{
    void checkSquare();
}
interface isRect{
    void checkRect();
}
class Rectangle implements isRect{
    double height;
    double width;

    @Override
    public void checkRect() {

    }
}

class Square implements isSquare{
    double height;
    double width;

    @Override
    public void checkSquare() {

    }
}