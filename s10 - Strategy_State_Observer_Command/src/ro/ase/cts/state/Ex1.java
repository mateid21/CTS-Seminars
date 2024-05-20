package ro.ase.cts.state;

interface TCPState{
    void open(TCPConnection connection);
    void close(TCPConnection connection);
    void acknowledge(TCPConnection connection);
}

class TCPConnection{
    private TCPState currentState;

    public TCPConnection(){
        currentState = new TPCClosedState();
    }

    public void setState(TCPState state){
        this.currentState = state;
    }

    public void open(){
        currentState.open(this);
    }

    public void close(){
        currentState.close(this);
    }

    public void acknowledge(){
        currentState.acknowledge(this);
    }
}

class TCPOpenState implements TCPState{
    @Override
    public void open(TCPConnection connection) {
        System.out.println("Connection is already open.");
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Closing connection...");
        connection.setState(new TPCClosedState());
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Acknowledging data.");
    }
}

class TPCClosedState implements TCPState{
    @Override
    public void open(TCPConnection connection) {
        System.out.println("Opening connection...");
        connection.setState(new TCPOpenState());
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Connection is already closed.");
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Cannot acknowledge data, connection is closed.");
    }
}

public class Ex1 {
    public static void main(String[] args) {
        TCPConnection connection = new TCPConnection();

        connection.open();
        connection.acknowledge();
        connection.close();
        connection.acknowledge();
    }
}
