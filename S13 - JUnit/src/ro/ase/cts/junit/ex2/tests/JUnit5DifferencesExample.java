package ro.ase.cts.junit.ex2.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit5DifferencesExample {

//    // JUnit 4 - Test Annotation
//    @Test
//    public void testAnnotation_JUnit4() {
//        assertEquals(2 + 2, 4);
//    }

    // JUnit 5 - Test Annotation
    @Test
    void testAnnotation_JUnit5() {
        assertEquals(2 + 2, 4);
    }

//    // JUnit 4 - Assertion
//    @Test
//    public void assertion_JUnit4() {
//        assertTrue(true);
//    }

    // JUnit 5 - Assertion
    @Test
    void assertion_JUnit5() {
        assertTrue(true);
    }

//    // JUnit 4 - Parameterized Test
//    @Test
//    @Parameters({"JUnit", "Test"})
//    public void parameterizedTest_JUnit4(String text) {
//        assertTrue(text.length() >= 4);
//    }

    // JUnit 5 - Parameterized Test
    @ParameterizedTest
    @ValueSource(strings = {"JUnit", "Test"})
    void parameterizedTest_JUnit5(String text) {
        assertTrue(text.length() >= 4);
    }

//    // JUnit 4 - Before and After
//    @Before
//    public void before_JUnit4() {
//        System.out.println("Before JUnit 4 test");
//    }
//
//    @After
//    public void after_JUnit4() {
//        System.out.println("After JUnit 4 test");
//    }

    // JUnit 5 - Before Each and After Each
    @BeforeEach
    void beforeEach_JUnit5() {
        System.out.println("Before JUnit 5 test");
    }

    @AfterEach
    void afterEach_JUnit5() {
        System.out.println("After JUnit 5 test");
    }

//    // JUnit 4 - Test Suite
//    @RunWith(Suite.class)
//    @Suite.SuiteClasses({
//            CalculatorTests.class,
//            Junit4Annotations.class
//    })
//    public class JUnit4TestSuite {
//        // Test Suite in JUnit 4
//    }

    // JUnit 4 - Nested Test
    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            JUnit4NestedTest.class
    })
    public class JUnit4NestedTest {
        // Nested Test in JUnit 4
    }

    // JUnit 5 - Nested Test
    @Nested
    class JUnit5NestedTest {

        @Test
        void nestedTest_JUnit5() {
            assertEquals(2 * 2, 4);
        }
    }

    // JUnit 5 - Tagging and Filtering
    @Test
    @Tag("slow")
    void slowTest_JUnit5() {
        assertEquals(5, 5);
    }

    @Test
    @Tag("fast")
    void fastTest_JUnit5() {
        assertEquals(2 + 2, 4);
    }
}
