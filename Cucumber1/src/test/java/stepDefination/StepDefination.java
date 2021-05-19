package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class StepDefination {
    WebDriver driver;
    @Given("browser is open")
    public void browser_is_open() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        //System.out.println("Open Browser");
    }
    @Given("facebook login page is open")
    public void facebook_login_page_is_open() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().deleteAllCookies();
        System.out.println("Facebook login page is open");
    }
    @When("^user enters valid credentials with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_valid_credentials_with_something_and_password_something(String strArg1, String strArg2) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("button[title='Accept All']")).click();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#email")).sendKeys(strArg1);
        driver.findElement(By.cssSelector("#pass")).sendKeys(strArg2);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Entered username & password");
    }

    @Then("user should not be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
        String error = driver.findElement(By.className("_9ay7")).getText();
        Assert.assertEquals("The password that you've entered is incorrect. Forgotten password?",error);
        System.out.println(error);
    }
}
