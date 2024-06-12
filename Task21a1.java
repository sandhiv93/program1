package Task_21;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2_Herokuapp_Window {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        // Step 1 and 2 Initialize the Webdriver and navigate to website

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        // Step 3 : Click here the "Click here" in window to open new window

        WebElement parentpage = driver.findElement(By.xpath("//a[text()='Click Here']"));
        Thread.sleep(3000);
        parentpage.click();

        String parentwindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equalsIgnoreCase(parentwindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Step 4 and 5 : Verify the New Window open and "New Window" text present on
        // the page
        Thread.sleep(3000);
        String textpresent = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        if (textpresent.equalsIgnoreCase("New Window")) {
            System.out.println("New Window Text  is available on the page.");
        } else {
            System.out.println("New Window Text is NOT available on the page.");
        }
        Thread.sleep(3000);
        // Step 6 : Close the new Window
        driver.close();

        // Step 7 : Verify Original window is Active

        driver.switchTo().window(parentwindow);
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        driver.quit();

    }

}