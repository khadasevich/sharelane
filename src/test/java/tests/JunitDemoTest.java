package tests;

import org.junit.jupiter.api.*;
import org.junit.platform.suite.api.Suite;

@Suite
public class JunitDemoTest {

    @BeforeAll
    public static void beforeAllDemo() {
        System.out.println("I'm before all method");
    }

    @BeforeEach
    public void beforeEachDemo() {
        System.out.println("I'm before each method");
    }

    @Test
    @Tag("QA")
    @DisplayName("First Junit Test")
    public void firstJunitTest() {
        System.out.println("I'm first Junit test");
        Assertions.assertEquals(4, 5, "Check integers");
    }

    @Test
    @Tag("Prod")
    @Disabled
    public void secondJunitTest() {
        System.out.println("I'm second Junit test");
    }

    @AfterEach
    public void afterEachDemo() {
        System.out.println("I'm after each method");
    }

    @AfterAll
    public static void afterAllDemo() {
        System.out.println("I'm after all");
    }
}
