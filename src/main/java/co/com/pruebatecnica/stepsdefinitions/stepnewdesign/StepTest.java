package co.com.pruebatecnica.stepsdefinitions.stepnewdesign;

import co.com.pruebatecnica.controllers.webpage.NewDesignController;
import co.com.pruebatecnica.generalactions.WebAction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepTest {

    public static WebAction webAction;
    private NewDesignController newDesignController;

    @Before
    public void setUp() {
        webAction = new WebAction("Logs", "Weelo");
    }

    @After
    public void tearDown() {
        webAction.closeBrowser();
    }

    @Given("^We are on the New Design main page$")
    public void weAreOnTheNewDesignMainPage() {
        newDesignController = new NewDesignController();
        newDesignController.startBrowser();
        newDesignController.homeNewDesign();
    }

    @When("^Fill out the form to schedule a demonstration$")
    public void fillOutTheFormToScheduleADemonstration() {
        newDesignController.loginAndSearchBlog();
    }

    @Then("^Demonstration to be scheduled$")
    public void demonstrationToBeScheduled() throws InterruptedException {


    }
}
