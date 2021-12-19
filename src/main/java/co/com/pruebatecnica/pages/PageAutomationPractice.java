package co.com.pruebatecnica.pages;

import co.com.pruebatecnica.exceptions.WebActionsException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static co.com.pruebatecnica.stepsdefinitions.stepautomationpractices.StepAutomationPractices.webAction;

public class PageAutomationPractice {

    public PageAutomationPractice() {
    }

    private int DEFAULT_TIME = 60;


    @FindBy(how = How.XPATH, using = "//*[@src='http://automationpractice.com/img/logo.jpg']")
    private WebElement objLogo;

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement inputSearch;

    @FindBy(how = How.NAME, using = "submit_search")
    private WebElement btnSearc;

    @FindBy(how = How.XPATH, using = "//*[@itemprop='name' ]/a[contains(text(),'Printed Chiffon Dress')]")
    private WebElement objDress4;

    @FindBy(how = How.ID, using = "add_to_cart")
    private WebElement btnAddToCar;

    public boolean isCorrectPage() {
        return webAction.isVisible(objLogo, DEFAULT_TIME);
    }

    public void inputSearch(String value) throws WebActionsException {
        webAction.sendText(inputSearch, value, DEFAULT_TIME);
    }

    public void clickSearchBtn() throws WebActionsException {
        webAction.click(btnSearc, DEFAULT_TIME);
    }

    public void clickFourthDress() throws WebActionsException {
        webAction.click(objDress4, DEFAULT_TIME);
    }

    public boolean isPresentAddButton(){
        return webAction.isVisible(btnAddToCar,DEFAULT_TIME);
    }


}
