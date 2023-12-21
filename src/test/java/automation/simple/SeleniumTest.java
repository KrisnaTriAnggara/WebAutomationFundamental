package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {
    WebDriver driver;
    @Test
    public void searchContentEmail(){

        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/en/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("automationtest");
        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();


         driver.switchTo().frame(driver.findElement(By.id("ifmail")));


        String txtActualBerhasilGet = driver.findElement(By.xpath("//span[contains(.,'Our representative will get in touch with you within 24 hours to understand your')]")).getText();
        String txtExpectedBerhasilGet= "Our representative will get in touch with you within 24 hours to understand your requirements and further assist you.";
//        System.out.println("txtActualBerhasilGet");
        Assert.assertEquals(txtActualBerhasilGet,txtExpectedBerhasilGet);


    }
}
