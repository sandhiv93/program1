package Task_21;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3_Herokuapp_NestedFrame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Step 1, 2 and 3 Initialize the Webdriver and navigate to website

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        // Verify that there are three frames on the page
        List<WebElement> frameCount = driver.findElements(By.xpath("//frameset[@name='frameset-middle']"));
        int value = 3;
        if (frameCount.equals(value)) {
            System.out.println("There are three frames on the page.");
        } else {
            System.out.println("There are NOT three frames on the page.");
        }

        // Switch to the left frame
        driver.switchTo().frame("frame-left");

        // Verify that the left frame has text "LEFT"
        WebElement leftFrameText = driver.findElement(By.tagName("body"));
        if (leftFrameText.getText().equals("LEFT")) {
            System.out.println("The left frame has the text 'LEFT'.");
        } else {
            System.out.println("The left frame does NOT have the text 'LEFT'.");
        }
        // Switch back to the top frame
        driver.switchTo().parentFrame();

        // Switch to the middle frame
        driver.switchTo().frame("frame-middle");

        // Verify that the middle frame has text "MIDDLE"
        WebElement middleFrameText = driver.findElement(By.id("content"));
        if (middleFrameText.getText().contains("MIDDLE")) {
            System.out.println("The middle frame has text 'MIDDLE'.");
        } else {
            System.out.println("The middle frame does NOT have the text 'MIDDLE'.");
        }

        //  Switch back to the top frame

        driver.switchTo().parentFrame();

        // Switch to the right frame
        driver.switchTo().frame("frame-right");
        //  Verify that the right frame has text "Right"
        WebElement rightFrameText = driver.findElement(By.tagName("body"));
        if (rightFrameText.getText().equals("RIGHT")) {
            System.out.println("The right frame has text 'RIGHT'.");
        } else {
            System.out.println("The right frame does NOT have text 'RIGHT'.");
        }

        //  Switch back to the top frame
        driver.switchTo().defaultContent();

        //  Switch back to the Bottom frame
        driver.switchTo().frame("frame-bottom");
        //  Verify that the bottom frame has text "Bottom"
        WebElement bottomFrameText =driver.findElement(By.tagName("body"));
        if (bottomFrameText.getText().equals("BOTTOM")) {
            System.out.println("The bottom frame has text 'BOTTOM'.");
        } else {
            System.out.println("The bottom frame does NOT have text 'BOTTOM'.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        //  Verify that the page title is "Frames"
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Frames")) {
            System.out.println("The page title is a 'Frames'.");
        } else {
            System.out.println("The page title is NOT a 'Frames'.");
        }

        //  Close the browser
        driver.quit();

    }
}
