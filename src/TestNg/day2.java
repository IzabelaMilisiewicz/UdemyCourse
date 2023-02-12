package TestNg;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

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

    @Test(dataProvider = "getData")
    public void multipleDataDemo(String username, String password){
        System.out.println("multipleDataDemo");
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData(){
        //1st combination - user and password for client with good credit history //1st row combination, 1st column - username; we are counting from 0
        //2nd combination - user and password for client without credit history
        //3rd - faudulent credit history
        Object[][] data = new Object[3][2]; //first brackets how many combinations, second how many data we are providing
        //first set; first row, columns in the row are vauleas for the combination
        data[0][0] = "firstusername";
        data[0][1] = "firstpassword";
        //second set
        data[1][0] = "secondusername";
        data[1][1] = "secondpassword";
        //third set
        data[2][0] = "thirdusername";
        data[2][1] = "thirdpassword";
        return data;
    }
}
