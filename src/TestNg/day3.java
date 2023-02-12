package TestNg;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;

public class day3 {

    @BeforeClass
    public void beforeClass(){
        //selenium
        System.out.println("beforeClass - will be executed before any test in this class");
    }

    @Test(groups = {"Smoke"})
    public void good(){
        //selenium
        System.out.println("good");
    }
    @Parameters({"URL"})
    @Test
    public void better(String urlDay3){
        //selenium
        System.out.println("better");
        System.out.println(urlDay3);
    }

    @Test
    public void theBest(){
        //selenium
        System.out.println("theBest");
        Assert.assertTrue(false);
    }

    @BeforeTest
    public void prerequisite(){
        //selenium
        System.out.println("beforeTest");
    }

    @BeforeSuite
    public void beforeSuite(){
        //selenium
        System.out.println("beforeSuite");
    }
}
