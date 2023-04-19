package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class BoardPage {

    public BoardPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Left Panel
    // Left Panel Account Menu
    @FindBy(xpath = "//*[@id='qa-NAV_USER']/div/div/span/div/div[1]/div")
    public WebElement menuAccount;

    @FindBy(id = "qa-ACCOUNT_DROPDOWN_LOGOUT")
    public WebElement optionLogout;

    // Left Panel New Menu
    @FindBy(xpath = "//*[@id='qa-CREATE_NOTE']/div")
    public WebElement menuNew;

    @FindBy(xpath = "//*[@id='ActionMenu']/ul[1]/li[1]/button")
    public WebElement optionNote;

    @FindBy(xpath = "//*[@id='ActionMenu']/ul[1]/li[2]/button")
    public WebElement optionTask;

    // Left Panel Main Menu
    @FindBy(id = "qa-NAV_HOME")
    public WebElement menuHome;

    @FindBy(xpath = "//*[@id='qa-NAV']/div/ul/ul/div/div[1]/div/div/li[1]/div/button")
    public WebElement menuShortcuts;

    @FindBy(id = "qa-NAV_ALL_NOTES")
    public WebElement menuNotes;

    @FindBy(id = "qa-NAV_TASKS")
    public WebElement menuTasks;

    // Main Panel
    @FindBy(xpath = "//*[@id='qa-COMMON_EDITOR_IFRAME']")
    public WebElement editorIFrame;

    @FindBy(xpath = "/html/body/en-noteheader/div/div[2]/textarea")
    public WebElement noteHeader;

    public String xpathNoteHeaderActual = "/html/body/en-noteheader/div/div[2]/div";

    @FindBy(id = "en-note")
    public WebElement noteBody;

    public String xpathNoteBodyActual = "//*[@id='en-note']/div";

    // Note List
    public String xpathTheLastNoteTitle = "(//*[contains(@id,'NOTES_SIDEBAR_NOTE_TITLE')])[1]";
    public String xpathTheLastNoteBody = "(//*[contains(@id,'NOTES_SIDEBAR_NOTE_SNIPPET')])[1]";

    @FindBy(xpath = "//*[contains(@id,'NOTES_SIDEBAR_NOTE_TITLE')]")
    public List<WebElement> noteTitles;

    @FindBy(xpath = "//*[contains(@id,'NOTES_SIDEBAR_NOTE_SNIPPET')]")
    public List<WebElement> noteSnippets;
}
