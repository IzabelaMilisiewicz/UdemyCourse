package TestNg;

import org.testng.annotations.Test;

public class day1 {

//    public static void main(String[] args) {
        //"psvm - create main class
        //we are uisng testng (@Test) instead of java complier (public static void main(String[] args))
    @Test  //everything what follows that test will be treated as a test by testNG
    public void Demo(){
        System.out.println("Hello");
    }

    @Test //this is one method = one test case
    public void SecondTest(){
        System.out.println("bye");
    }
}
