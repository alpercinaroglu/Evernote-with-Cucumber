package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class MainSteps {

    HomePage home = new HomePage();
    
    @When("go to {string}")
    public void goTo(String URL) {

        Driver.getDriver().get(ConfigReader.getProperty(URL));
    }

    @Then("page URL should be {string}")
    public void pageIs(String pageURL) {

        Assert.assertEquals(ConfigReader.getProperty(pageURL), Driver.getDriver().getCurrentUrl());
    }

    @When("click {string} link")
    public void clickLink(String keyword) {

        WebElement link = null;
        
        switch (keyword) {
            case "Log In":
                link = home.linkLogin;
                break;
            default:
                break;
        }
        if (link != null) {
            link.click();
        }
    }

    @And("close browser")
    public void closeBrowser() {

        Driver.closeDriver();
    }

    @And("go to the main frame")
    public void goToTheMainFrame() {

        Driver.getDriver().switchTo().defaultContent();
    }

    @Then("URL should contain {string}")
    public void urlShouldContain(String param) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(ConfigReader.getProperty(param)));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ConfigReader.getProperty(param)));
    }
}
