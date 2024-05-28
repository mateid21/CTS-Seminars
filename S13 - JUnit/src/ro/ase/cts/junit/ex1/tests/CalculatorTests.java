package ro.ase.cts.junit.ex1.tests;

import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ro.ase.cts.junit.ex1.Calculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculatorTests {
    private Calculator calculator;
    private static FileWriter resultsFile;
    private static int passedTests = 0;

    @Parameterized.Parameter(0)
    public int m1;
    @Parameterized.Parameter(1)
    public int m2;
    @Parameterized.Parameter(2)
    public int addResult;
    @Parameterized.Parameter(3)
    public int mulResult;
    @Parameterized.Parameter(4)
    public double divResult;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 4, 2, 0.5 }, { 5, 3, 8, 15, 1.66 }, { 121, 4, 125, 484, 30.25 }, {2, 2, 4, 4, 1} };
        return Arrays.asList(data);
    }

    @BeforeClass
    public static void globalSetUp() throws Exception {
        resultsFile = new FileWriter(Instant.now().getEpochSecond() + "-results.txt");
        System.out.println("Fisierul este pregatit pentru scriere.");
    }

    @Before
    public void setUp() throws Exception {
        calculator = Calculator.getInstance();
    }
    @Test
    public void testSingleton()
    {
        Calculator calculatorTest = Calculator.getInstance();
        assertSame("Singleton nu este implementat corect.", calculator, calculatorTest);
        passedTests++;
    }

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFolder = folder.newFolder("newfolder");
        File createdFile = folder.newFile("myfilefile.txt");
        assertTrue(createdFile.exists());
    }

    @Test
    public void testAdd() {
        assertEquals("Adunare zerouri.",addResult,  calculator.add(m1,m2), 0);
        assertEquals("Adunare numere naturale.", 100, calculator.add(51,49), 0);
        assertEquals("Adunare valori reale.", 100.333, calculator.add(51.111,49.223), 0.01);
        passedTests++;
    }

    @Test
    public void testMultiply() {
        assertEquals("Multiplicare intregi.", calculator.multiply(m1,m2), mulResult, 0.1);
        assertEquals("Multiplicare intregi.", calculator.multiply(4,5), 20, 0.1);
        assertEquals("Multiplicare numere reale.", calculator.multiply(4.99,55.22), 275.5, 0.1);
        assertEquals("Test inmultire cu 0.",0,  calculator.multiply(0,5), 0);
        assertEquals("Testare comutativitate inmultire cu 0.", 0, calculator.multiply(5,0), 0);
        passedTests++;
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals("Impartirea lui 0.",0,  calculator.divide(0,11), 0);
        assertEquals("Impartire numere naturale.", 12.5, calculator.divide(25,2), 0);
        assertEquals("Impartire numere reale.", 1.038, calculator.divide(51.111,49.223), 0.001);
        passedTests++;
    }

    @Test(expected = Exception.class)
    public void testDivideToZero() throws Exception {
        calculator.divide(123, 0);
        passedTests++;
    }

    @Test(timeout=100)
    public void testFileContentRead() throws Exception {
        String filepath = "testfile.txt";
        String content = Files.readString(Path.of(filepath));

        assertEquals("Citirea din fisier nu s-a realizat corect.", content,  calculator.getAResultsFile(filepath));
        passedTests++;
    }
    @AfterClass
    public static void globalCleanUp() throws Exception {
        resultsFile.write("" + passedTests);
        resultsFile.close();
        System.out.println("Fisier inchis cu succes.");
    }
}
