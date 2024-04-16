package ro.ase.cts.decorator;

interface DataService{
    String fetchData();
}

class DataServiceConcrete implements DataService{
    @Override
    public String fetchData() {
        return "Data fetched from database";
    }
}

class LoggingDecorator implements DataService{
    private DataService dataService;

    LoggingDecorator(DataService dataService) {
        this.dataService = dataService;
    }
    @Override
    public String fetchData() {
        System.out.println("Fetching data...");
        return dataService.fetchData();
    }
}

public class Example1 {
    public static void main(String[] args) {
        DataService myDataService = new LoggingDecorator(new DataServiceConcrete());
        System.out.println(myDataService.fetchData());

        DataService realDataService = new DataServiceConcrete();

        DataService loggedDataService = new LoggingDecorator(realDataService);

        String data = loggedDataService.fetchData();
        System.out.println("Data retrieved: " + data);
    }
}
