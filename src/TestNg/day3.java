package TestNg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

    @Test
    public void better(){
        //selenium
        System.out.println("better");
    }

    @Test
    public void theBest(){
        //selenium
        System.out.println("theBest");
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
