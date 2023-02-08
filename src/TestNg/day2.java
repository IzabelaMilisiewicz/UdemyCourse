package TestNg;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

    @Test(timeOut = 4000)
    public void WebLoginHomeLoan(){
        //selenium
        System.out.println("webloginHome - this is dependency for MobileSignOut");
    }

    @Test(enabled = false)
    public void MobileLoginHome(){
        //selenium
        System.out.println("MobileLoginHome");
    }

    @Test
    public void MobileSignIn(){
        //selenium
        System.out.println("MobileSignIn");
    }

    @Test(dependsOnMethods = {"WebLoginHomeLoan", "MobileSignIn"})
    public void MobileSignOut(){
        //selenium
        System.out.println("MobileSignOut depending on method WebLoginHomeLoan and MobileSignIn");
    }

    @Test(groups = {"Smoke"})
    public void LoginAPIHome(){
        //selenium
        System.out.println("LoginAPIHome");
    }

    @BeforeTest
    public void anotherPrerequisition(){
        //selenium
        System.out.println("anotherPrerequisition");
    }
}
