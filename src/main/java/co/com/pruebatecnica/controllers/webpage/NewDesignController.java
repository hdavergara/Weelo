package co.com.pruebatecnica.controllers.webpage;

import co.com.pruebatecnica.exceptions.WebActionsException;
import co.com.pruebatecnica.helpers.Browser;
import co.com.pruebatecnica.helpers.Properties;
import co.com.pruebatecnica.logs.Log;
import co.com.pruebatecnica.pages.PageNewDesign;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static co.com.pruebatecnica.stepsdefinitions.stepnewdesign.StepTest.webAction;

public class NewDesignController {

    private Properties properties = new Properties();
    private PageNewDesign pageNewDesign;


    public void startBrowser() {

        try {
            webAction.startWebApp(configureBrowser(), properties.getFieldProperties("urlAplication3"));
        } catch (Throwable e) {
            Log.LOGGER.error("An error occurred preparing the browser" + e);
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

    public void homeNewDesign() {

        Log.LOGGER.info("Opening URL New Design");
        pageNewDesign = PageFactory.initElements(webAction.getDriver(), PageNewDesign.class);
        try {
            Assert.assertTrue("We are not on the main page", pageNewDesign.isMainPage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginAndSearchBlog() {
        pageNewDesign = PageFactory.initElements(webAction.getDriver(), PageNewDesign.class);
        try {
            pageNewDesign.moveToElemnt();
            pageNewDesign.clickScheduleBtn();
            pageNewDesign.selectDate(2, "15");
            pageNewDesign.selectHour();
            pageNewDesign.clickVideoCallBtn();
            pageNewDesign.fillEmail();
            pageNewDesign.clickSelectShedule();
            pageNewDesign.fillName();
            pageNewDesign.fillPhone();
        } catch (WebActionsException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
