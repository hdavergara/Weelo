package co.com.pruebatecnica.pages;

import co.com.pruebatecnica.exceptions.WebActionsException;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static co.com.pruebatecnica.stepsdefinitions.stepnewdesign.StepTest.webAction;

public class PageNewDesign {

    public PageNewDesign() {
    }

    private int DEFAULT_TIME = 60;


    @FindBy(how = How.XPATH, using = "//button[@id='addressBtn']")
    private WebElement btnSchedule;

    @FindBy(how = How.XPATH, using = "//h1[@id='slider-project-title']")
    private WebElement lblTitle;

    @FindBy(how = How.ID, using = "addressBtn")
    private WebElement btnSchedules;

    @FindBy(how = How.ID, using = "addressBtn")
    private WebElement btnSchedulsAe;

    @FindBy(how = How.ID, using = "addressBtn")
    private WebElement btnSchedaaule;

    @FindBy(how = How.XPATH, using = "//*[@class='fc-next-button fc-button fc-button-primary' and @aria-label='next']")
    private WebElement btnScheduleNext;

    @FindBy(how = How.XPATH, using = "//input[@id='scheduleMonth']")
    private WebElement btnOpenShedule;

    @FindBy(how = How.XPATH, using = "//li[2][@class='options']/span[text()='1 PM']")
    private WebElement btnHour;

    @FindBy(how = How.XPATH, using = "//*[@schedule-requested='Project presentation (Zoom Call)']")
    private WebElement btnVideoCall;

    @FindBy(how = How.ID, using = "email")
    private WebElement inputEmail;

    @FindBy(how = How.ID, using = "btnSendModal")
    private WebElement btnSchedulePresentation;

    @FindBy(how = How.ID, using = "name")
    private WebElement inputName;

    @FindBy(how = How.ID, using = "phone")
    private WebElement inputPhone;



    public void moveToElemnt() throws WebActionsException, InterruptedException {
        Actions actions = new Actions(webAction.getDriver());
        actions.sendKeys(Keys.END).build().perform();
        actions.sendKeys(Keys.END).build().perform();

        //actions.moveToElement(btnSchedule).perform();
    }

    public void clickScheduleBtn() throws WebActionsException, InterruptedException {
        Actions actions = new Actions(webAction.getDriver());
        actions.sendKeys(Keys.END).build().perform();
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor)webAction.getDriver();
        executor.executeScript("arguments[0].click();", btnSchedule);
        //webAction.click(btnSchedule, DEFAULT_TIME);
    }

    public void selectDate(int month, String day) throws WebActionsException, InterruptedException {
        webAction.click(btnOpenShedule,DEFAULT_TIME);
        Thread.sleep(1000);
        for (int i=0;i<month;i++){
            webAction.click(btnScheduleNext);
        }
        Thread.sleep(1000);
        webAction.getDriver().findElement(By.xpath("//*[contains(@class,'fc-daygrid-day')  and contains(@data-date,'-"+day+"')]")).click();
    }

    public void selectHour() throws WebActionsException {
        webAction.click(btnHour,DEFAULT_TIME);
    }

    public void clickVideoCallBtn() throws WebActionsException, InterruptedException {
        webAction.click(btnVideoCall,DEFAULT_TIME);
        Thread.sleep(2000);

    }

    public void fillEmail() throws WebActionsException {

        Faker faker = new Faker();
        ((JavascriptExecutor)webAction.getDriver()).executeScript("arguments[0].removeAttribute('autocomplete')", inputEmail);
        ((JavascriptExecutor)webAction.getDriver()).executeScript("arguments[0].removeAttribute('class')", inputEmail);
        ((JavascriptExecutor)webAction.getDriver()).executeScript("arguments[0].removeAttribute('aria-describedby')", inputEmail);
        ((JavascriptExecutor)webAction.getDriver()).executeScript("arguments[0].removeAttribute('aria-invalid')", inputEmail);
        ((JavascriptExecutor)webAction.getDriver()).executeScript("arguments[0].removeAttribute('type')", inputEmail);
        ((JavascriptExecutor)webAction.getDriver()).executeScript("arguments[0].setAttribute('type','text')", inputEmail);
        //((JavascriptExecutor)webAction.getDriver()).executeScript("document.getElementById('email').value='"+faker.internet().emailAddress()+"';");
        //webAction.doubleClick(inputEmail,DEFAULT_TIME);
        webAction.sendText(inputEmail,faker.internet().emailAddress(),DEFAULT_TIME);
    }

    public void clickSelectShedule() throws WebActionsException {
        webAction.click(btnSchedulePresentation,DEFAULT_TIME);
    }


    public boolean isMainPage() throws InterruptedException {
        return webAction.isVisible(lblTitle);
    }

   public void fillName() throws WebActionsException {
        Faker faker = new Faker();
        webAction.sendText(inputName,faker.name().fullName(),DEFAULT_TIME);
   }

    public void fillPhone() throws WebActionsException {
        Faker faker = new Faker();
        webAction.sendText(inputPhone,"350" + faker.number().digits(7),DEFAULT_TIME);
    }

    public void clickShedule() throws WebActionsException {
        webAction.click(btnSchedulePresentation,DEFAULT_TIME);
    }

}
