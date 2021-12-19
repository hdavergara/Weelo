package co.com.pruebatecnica.controllers.webpage;

import co.com.pruebatecnica.exceptions.WebActionsException;
import co.com.pruebatecnica.helpers.Browser;
import co.com.pruebatecnica.helpers.Properties;
import co.com.pruebatecnica.logs.Log;
import co.com.pruebatecnica.pages.PageAutomationPractice;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static co.com.pruebatecnica.stepsdefinitions.stepautomationpractices.StepAutomationPractices.webAction;

public class AutomationPracticeController {

    private Properties properties = new Properties();
    private PageAutomationPractice pageAutomationPractice;


    public void startBrowser() {

        try {
            webAction.startWebApp(configureBrowser(), properties.getFieldProperties("urlAplication2"));
        } catch (Throwable e) {
            Log.LOGGER.error("Ocurrio un error realizando una de las acciones de la prueba" + e);
            Assert.fail();
        }
    }

    public Browser configureBrowser() {
        Browser browserConfig = new Browser();
        browserConfig.setIncognito(true);
        browserConfig.setDriverVersion(properties.getFieldProperties("versionBrowser"));
        browserConfig.setBrowser(Browser.Browsers.CHROME);
        browserConfig.setMaximized(true);
        return browserConfig;
    }

    public void home() {

        Log.LOGGER.info("Opening URL Demo QA");
        pageAutomationPractice = PageFactory.initElements(webAction.getDriver(), PageAutomationPractice.class);
        Assert.assertTrue("We are not on the main page", pageAutomationPractice.isCorrectPage());
    }

    public void search() {
        pageAutomationPractice = PageFactory.initElements(webAction.getDriver(), PageAutomationPractice.class);
        try {
            Log.LOGGER.info("Filling the form...");
            pageAutomationPractice.inputSearch("Dress");
            pageAutomationPractice.clickSearchBtn();
        } catch (WebActionsException e) {
            Log.LOGGER.error("An error has occurred: " + e);
        }
    }

    public void enterTheDress() {
        pageAutomationPractice = PageFactory.initElements(webAction.getDriver(), PageAutomationPractice.class);
        try {
            pageAutomationPractice.clickFourthDress();
            Assert.assertTrue("We are not inside the dress",pageAutomationPractice.isPresentAddButton());
        } catch (WebActionsException e) {
            Log.LOGGER.error("An error has occurred: " + e);
        }
    }


}
