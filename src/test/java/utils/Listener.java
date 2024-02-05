package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class Listener implements ITestListener{
    boolean screenshot;

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult result)
    {
        screenshot = Screenshots.takeScreenshot();
        System.out.println("The name of the testcase failed is: "+result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult result)
    {
        screenshot = Screenshots.takeScreenshot();
        System.out.println("The name of the testcase Skipped is: "+result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println(result.getName()+" test case started");
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("The name of the testcase passed is: "+ result.getName());
    }

}