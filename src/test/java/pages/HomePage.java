package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Fixed Top Menu Bar
    @FindBy (xpath = "(//a[text()='Log In'])[1]")
    public WebElement linkLogin;
}
