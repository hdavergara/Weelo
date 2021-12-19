package co.com.pruebatecnica.stepsdefinitions.stepdemoqa;

import co.com.pruebatecnica.controllers.webpage.DemoQAController;
import co.com.pruebatecnica.generalactions.WebAction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDemoQA {

    public static WebAction webAction;
    private DemoQAController demoQAController;

    @Before
    public void setUp() {
        webAction = new WebAction("Logs", "Weelo");
    }

    @After
    public void tearDown() {
        webAction.closeBrowser();
    }

    @Given("^We are on the DemoQA main page$")
    public void weAreOnTheDemoQAMainPage() {
        demoQAController = new DemoQAController();
        demoQAController.startBrowser();
        demoQAController.home();
    }

    @When("^Fill in the form$")
    public void fillInTheForm() {
        demoQAController.fillForm();
    }

    @Then("^The form is submitted$")
    public void theFormIsSubmitted() {
        demoQAController.formSubmission();
    }
}
