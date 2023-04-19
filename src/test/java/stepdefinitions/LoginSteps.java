package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class LoginSteps {

    LoginPage login = new LoginPage();

    @When("type login {string} into {string} box")
    public void inputLoginData(String credential, String textBox) {

        WebElement box = null;

        switch (textBox) {
            case "username":
                box = login.textUsername;
                break;
            case "password":
                box = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(login.textPassword));
                break;
            default:
                break;
        }
        if (box != null) {
            box.sendKeys(ConfigReader.getProperty(credential));
        }
    }

    @When("click login button")
    public void clickLoginButton() {

        login.buttonLogin.click();
    }

    @Then("error message should be visible")
    public void errorMessage() {

        try {
            WebElement errorMessage = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(login.errorMessage));
            Assert.assertNotNull(errorMessage.getText());
        } catch (TimeoutException e) {
            Assert.fail("Wrong email message is not displayed.");
        }
    }
}
