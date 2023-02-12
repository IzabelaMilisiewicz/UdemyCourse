package TestNg;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

//ITestListener - interface with implements TestNG listeners
//implements - implement all methods from this interface
public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("this is usually used only to reports when tests passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        //screenshot code
        //response if API filed
        System.out.println("I filed on that test case - " +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
    }

    @Override
    public void onStart(ITestContext context){
    }

    @Override
    public void onFinish(ITestContext context){
    }
}
