package cucumber_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private WebDriver driver;

    @Given("I am on https:\\/\\/www.saucedemo.com\\/")
    public void i_am_on_https_www_saucedemo_com() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I put my login and password")
    public void i_put_my_login_$_and_password_$() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
    }

    @When("I click on {string}")
    public void iClickOn(String buttonName) {
        WebElement button = driver.findElement(By.xpath("//input[@value='" + buttonName + "']"));
        button.click();
    }

    @Then("I am on inventory page")
    public void iAmConnected() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);

        driver.quit();
    }
}