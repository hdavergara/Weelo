package co.com.pruebatecnica.stepsdefinitions.stepautomationpractices;

import co.com.pruebatecnica.controllers.webpage.AutomationPracticeController;
import co.com.pruebatecnica.generalactions.WebAction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepAutomationPractices {

    public static WebAction webAction;
    private AutomationPracticeController automationPracticeController;

    @Before
    public void setUp() {
        webAction = new WebAction("Logs", "Weelo");
    }

    @After
    public void tearDown() {
        webAction.closeBrowser();
    }

    @Given("^We are on the Automation Practices main page$")
    public void weAreOnTheAutomationPracticesMainPage() {
        automationPracticeController = new AutomationPracticeController();
        automationPracticeController.startBrowser();
        automationPracticeController.home();
    }

    @When("^Lets search for the word dress$")
    public void letsSearchForTheWordDress() {
        automationPracticeController.search();
    }

    @Then("^We enter the result number 4")
    public void weEnterTheResultNumber4() {
        automationPracticeController.enterTheDress();
    }
}
