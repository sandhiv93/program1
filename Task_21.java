package Task_21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1_iFrame_HelloPeople {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        //Step 1 and 2 Initialize the Webdriver and navigate to website
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        System.out.println(driver.getCurrentUrl());

        //Step 3 Switch to the iFrame

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='tox-edit-area__iframe']")));
        driver.switchTo();


        //Step 4 Write Hello People in paragraph

        WebElement textarea = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textarea.clear();
        textarea.sendKeys("Hello People");

        //Step 5 Close Browser
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.close();
    }

}