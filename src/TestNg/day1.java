package TestNg;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day1 {

//    public static void main(String[] args) {
        //"psvm - create main class
        //we are uisng testng (@Test) instead of java complier (public static void main(String[] args))

    @AfterTest  //everything what follows that test will be treated as a test by testNG
    public void lastExecution(){
        System.out.println("afterTest - I will execute at the end if the test");
    }

    @Test  //everything what follows that test will be treated as a test by testNG
    public void Demo(){
        System.out.println("Hello");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Test //this is one method = one test case
    public void SecondTest(){
        System.out.println("bye");
    }
}
