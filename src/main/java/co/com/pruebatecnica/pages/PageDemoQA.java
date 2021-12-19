package co.com.pruebatecnica.pages;

import co.com.pruebatecnica.exceptions.WebActionsException;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Locale;

import static co.com.pruebatecnica.stepsdefinitions.stepdemoqa.StepDemoQA.webAction;

public class PageDemoQA {

    public PageDemoQA() {
    }

    private int DEFAULT_TIME = 60;


    @FindBy(how = How.ID, using = "firstName")
    private WebElement inputName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement inputLastName;

    @FindBy(how = How.ID, using = "userEmail")
    private WebElement inputEmail;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Female')]")
    private WebElement radioGenderFemale;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Male')]")
    private WebElement radioGenderMale;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Other')]")
    private WebElement radioOther;

    @FindBy(how = How.ID, using = "userNumber")
    private WebElement inputPhone;

    @FindBy(how = How.ID, using = "dateOfBirthInput")
    private WebElement inputDateOfBirth;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Sports')]")
    private WebElement chkSports;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Reading')]")
    private WebElement chkReading;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Music')]")
    private WebElement chkMusic;

    @FindBy(how = How.ID, using = "currentAddress")
    private WebElement txtCurrentAddress;

    @FindBy(how = How.XPATH, using = "//*[@id='state']")
    private WebElement selectState;

    @FindBy(how = How.ID, using = "city")
    private WebElement selectCity;

    @FindBy(how = How.ID, using = "submit")
    private WebElement btnSubmit;

    @FindBy(how = How.XPATH, using = "//h5[contains(text(),'Student Registration Form')]")
    private WebElement lblStudentRegisrtration;

    @FindBy(how = How.XPATH, using = "//*[@class='react-datepicker__month-select']")
    private WebElement selectMonth;

    @FindBy(how = How.XPATH, using = "//*[@class='react-datepicker__year-select']")
    private WebElement selectYear;

    @FindBy(how = How.XPATH, using = "//*[@id='subjectsContainer']/div/div")
    private WebElement objSubjects;

    @FindBy(how = How.ID, using = "subjectsInput")
    private WebElement inputSubjects;

    @FindBy(how = How.ID, using = "react-select-2-option-1")
    private WebElement objOption;

    @FindBy(how = How.ID, using = "uploadPicture")
    private WebElement objUploadFile;

    public enum Gender {
        Male, Female, Other
    }

    public enum Months {
        January, February, March, April, May, June, July, August, September, October, November, December
    }

    public enum Hobbies {
        Sports, Reading, Music
    }

    public boolean isCorrectPage() {
        return webAction.isVisible(lblStudentRegisrtration, DEFAULT_TIME);
    }


    public void fillName(String name) throws WebActionsException {
        webAction.sendText(inputName, name, DEFAULT_TIME);
    }

    public void fillLastName(String lastName) throws WebActionsException {
        webAction.sendText(inputLastName, lastName, DEFAULT_TIME);
    }

    public void fillEmail() throws WebActionsException {
        Faker faker = new Faker();
        webAction.sendText(inputEmail, faker.internet().emailAddress(), DEFAULT_TIME);
    }

    public void selectGender(Gender gender) throws WebActionsException {
        switch (gender) {
            case Male:
                webAction.click(radioGenderMale, DEFAULT_TIME);
                break;
            case Female:
                webAction.click(radioGenderFemale, DEFAULT_TIME);
                break;
            case Other:
                webAction.click(radioOther, DEFAULT_TIME);
            default:
                throw new IllegalStateException("Unexpected value: " + gender);
        }
    }

    public void fillPhoneNumber() throws WebActionsException {
        Faker faker = new Faker(Locale.ENGLISH);
        webAction.sendText(inputPhone, "350" + faker.number().digits(7), DEFAULT_TIME);
    }

    public void fillDateBirth(String day, Months month, String year) throws WebActionsException {
        webAction.click(inputDateOfBirth, DEFAULT_TIME);
        webAction.selectVisibleText(selectMonth, month.toString(), DEFAULT_TIME);
        webAction.selectVisibleText(selectYear, year, DEFAULT_TIME);
        webAction.getDriver().findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--0" + day + "']")).click();
    }

    public void sport(Hobbies hobbies) throws WebActionsException {
        switch (hobbies) {
            case Sports:
                webAction.click(chkSports, DEFAULT_TIME);
                break;
            case Reading:
                webAction.click(chkReading, DEFAULT_TIME);
                break;
            case Music:
                webAction.click(chkMusic, DEFAULT_TIME);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + hobbies);
        }
    }

    public void fillSubjects() throws WebActionsException {
        webAction.click(objSubjects, DEFAULT_TIME);
        webAction.sendText(inputSubjects, "T", DEFAULT_TIME);
        webAction.click(objOption, DEFAULT_TIME);
    }

    public void uploadFile(String path) throws WebActionsException {
        webAction.sendText(objUploadFile, path, DEFAULT_TIME);
    }

    public void fillCurrentAddress(String currentAddress) throws WebActionsException {
        webAction.sendText(txtCurrentAddress, currentAddress, DEFAULT_TIME);
    }

    public void selectState() throws WebActionsException {
        webAction.click(selectState, DEFAULT_TIME);
        Actions keyDown = new Actions(webAction.getDriver());
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
    }

    public void selectCity() throws WebActionsException {
        webAction.click(selectCity, DEFAULT_TIME);
        Actions keyDown = new Actions(webAction.getDriver());
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }

    public void clickSubmitButton() throws WebActionsException {
        webAction.click(btnSubmit, DEFAULT_TIME);
    }
}
