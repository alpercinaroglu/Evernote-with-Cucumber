package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Log In Forms
    @FindBy(id = "username")
    public WebElement textUsername;

    @FindBy(id = "password")
    public WebElement textPassword;

    @FindBy(id = "loginButton")
    public WebElement buttonLogin;

    @FindBy(id = "responseMessage")
    public WebElement errorMessage;
}
