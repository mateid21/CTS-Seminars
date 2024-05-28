package ro.ase.cts.junit.ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Calculator {
    private double lastResult;
    private static Calculator instance = null;
    private Calculator()
    {
        this.lastResult = 0.0;
        System.out.println("Obiect creat cu resetarea ultimului rezultat.");
    }
    public static Calculator getInstance()
    {
        if(instance == null)
            instance = new Calculator();
        //return instance;
        return new Calculator();
    }
    public double add(double x, double y)
    {
        this.lastResult = x + y;
        return this.lastResult;
    }

    public double multiply(double x, double y)
    {
        this.lastResult = x * y;
        return this.lastResult;
    }

    public double divide(double x, double y) throws Exception {
        if(y == 0)
            //return 999999999.999999999999;
            throw new Exception("Impartirea la 0 nu are sens.");
        this.lastResult = x / y;
        return this.lastResult;
    }

    public String getAResultsFile(String filepath) throws IOException {
        String content = Files.readString(Path.of(filepath));
        System.out.println(content);
        return content;
    }

    //test cu parametri
    //test timeout
    //
}
