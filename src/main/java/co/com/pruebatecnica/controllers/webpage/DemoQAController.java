package co.com.pruebatecnica.controllers.webpage;

import co.com.pruebatecnica.exceptions.WebActionsException;
import co.com.pruebatecnica.helpers.Browser;
import co.com.pruebatecnica.helpers.Properties;
import co.com.pruebatecnica.logs.Log;
import co.com.pruebatecnica.pages.PageDemoQA;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static co.com.pruebatecnica.stepsdefinitions.stepdemoqa.StepDemoQA.webAction;

public class DemoQAController {

    private Properties properties = new Properties();
    private PageDemoQA pageDemoQA;


    public void startBrowser() {

        try {
            webAction.startWebApp(configureBrowser(), properties.getFieldProperties("urlAplication1"));
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
        pageDemoQA = PageFactory.initElements(webAction.getDriver(), PageDemoQA.class);
        Assert.assertTrue("We are not on the main page", pageDemoQA.isCorrectPage());
    }

    public void fillForm() {
        pageDemoQA = PageFactory.initElements(webAction.getDriver(), PageDemoQA.class);
        try {
            Log.LOGGER.info("Filling the form...");
            pageDemoQA.fillName("Pedro");
            pageDemoQA.fillLastName("Gomez");
            pageDemoQA.fillEmail();
            pageDemoQA.selectGender(PageDemoQA.Gender.Female);
            pageDemoQA.fillPhoneNumber();
            pageDemoQA.fillDateBirth("20", PageDemoQA.Months.September, "1989");
            pageDemoQA.fillSubjects();
            pageDemoQA.sport(PageDemoQA.Hobbies.Reading);
            pageDemoQA.uploadFile("path");
            pageDemoQA.fillCurrentAddress("Lorem Ipsum is simply dummy text of the printing and typesetting industry");
            pageDemoQA.selectState();
            pageDemoQA.selectCity();
        } catch (WebActionsException e) {
            Log.LOGGER.error("An error has occurred: " + e);
        }
    }

    public void formSubmission() {
        pageDemoQA = PageFactory.initElements(webAction.getDriver(), PageDemoQA.class);
        try {
            pageDemoQA.clickSubmitButton();
        } catch (WebActionsException e) {
            e.printStackTrace();
        }
    }


}
