package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BoardPage;
import utilities.Auxiliary;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class BoardSteps {

    BoardPage board = new BoardPage();

    private static String[] parseNoteFile() {

        return Auxiliary.read(ConfigReader.getProperty("noteFile")).split(ConfigReader.getProperty("parseKey"));
    }

    @Then("board should be opened")
    public void boardOpened() {

        Assert.assertEquals(ConfigReader.getProperty("username"), board.menuAccount.getText());
    }
    
    @Given("open the {string} menu on the left panel")
    public void openTheMenuOnTheLeftPanel(String option) {

        WebElement menu = null;

        switch (option) {
            case "New":
                menu = board.menuNew;
                break;
            case "Account":
                menu = board.menuAccount;
                break;
            default:
                break;
        }
        if (menu != null) {
            menu.click();
        }
    }

    @When("select {string} option in the menu")
    public void selectOptionInTheMenu(String option) {

        WebElement select = null;

        switch (option) {
            case "Note":
                select = board.optionNote;
                break;
            case "Task":
                select = board.optionTask;
                break;
            case "Logout":
                select = board.optionLogout;
                break;
            default:
                break;
        }
        if (select != null) {
            select.click();
        }
    }

    @And("go to the Editor frame")
    public void goToTheEditorFrame() {

        Driver.getDriver().switchTo().frame(board.editorIFrame);
    }

    @And("write note title from file")
    public void writeNoteTitleFromFile() {

        board.noteHeader.sendKeys(parseNoteFile()[0].trim());
    }

    @And("write note body from file")
    public void writeNoteBodyFromFile() {

        board.noteBody.sendKeys(parseNoteFile()[1].trim());
    }

    @Then("the last note should be saved")
    public void theLastNoteShouldBeSaved() {

        // TODO More controls for various note contents will be added.
        // This wait process also verifies that the note has been saved.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(180));
        wait.until(ExpectedConditions.and(ExpectedConditions.textToBe(By.xpath(board.xpathTheLastNoteTitle), parseNoteFile()[0].trim()), ExpectedConditions.textToBe(By.xpath(board.xpathTheLastNoteBody), parseNoteFile()[1].trim())));

        System.out.println(board.noteTitles.get(0).getText());
        System.out.println(board.noteSnippets.get(0).getText());
    }

    @Given("select {string} option on the left panel")
    public void selectOptionOnTheLeftPanel(String option) {

        WebElement select = null;

        switch (option) {
            case "Home":
                select = board.menuHome;
                break;
            case "Shortcuts":
                select = board.menuShortcuts;
                break;
            case "Notes":
                select = board.menuNotes;
                break;
            case "Tasks":
                select = board.menuTasks;
                break;
            default:
                break;
        }
        if (select != null) {
            select.click();
        }
    }

    @When("select the note added from file")
    public void selectTheNoteAddedFromFile() {

        for (int i=0; i<board.noteTitles.size(); i++) {
            if (board.noteTitles.get(i).getText().equals(parseNoteFile()[0].trim())) {
                if (board.noteSnippets.get(i).getText().equals(parseNoteFile()[1].trim())) {
                    board.noteSnippets.get(i).click();
                }
            }
        }
    }

    @Then("the note should be opened")
    public void theNoteShouldBeOpened() {

        Auxiliary.wait(5);
        Assert.assertEquals(parseNoteFile()[0].trim(), board.noteHeader.getAttribute("value"));
    }
}
