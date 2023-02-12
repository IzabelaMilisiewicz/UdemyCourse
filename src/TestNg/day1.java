package TestNg;

import org.testng.annotations.*;

public class day1 {

//    public static void main(String[] args) {
        //"psvm - create main class
        //we are uisng testng (@Test) instead of java complier (public static void main(String[] args))
    @Parameters({"URL"})
    @AfterTest  //everything what follows that test will be treated as a test by testNG
    public void lastExecution(String urlname){
        System.out.println("afterTest - I will execute at the end if the test");
        System.out.println(urlname);
    }
    @Parameters({"URL", "APIKey/usrname"})
    @Test  //everything what follows that test will be treated as a test by testNG
    public void Demo(String urlname, String key){
        System.out.println("Hello");
        System.out.println(urlname);
        System.out.println(key);
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
