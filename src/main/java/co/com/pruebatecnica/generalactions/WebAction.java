package co.com.pruebatecnica.generalactions;


import co.com.pruebatecnica.logs.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.com.pruebatecnica.exceptions.WebActionsException;
import co.com.pruebatecnica.helpers.Browser;


import java.nio.file.Paths;
import java.util.List;

import static java.awt.SystemColor.TEXT_TEXT;

public class WebAction {

    public WebAction(String nameFolder, String projectFolder) {
        Log.initLogs(Paths.get(System.getProperty("user.dir"), nameFolder), projectFolder);
        Log.LOGGER.info("============================ Start Test ==============================");
    }

    private WebDriver driver = null;

    private static final String SUCCESS_MSG_PARAMS = "Action '%s' executed successfully with parameters : '%s'";
    private static final String SUCCESS_MSG_NO_PARAMS = "Action '%s' executed successfully. %s";
    private static final String ERROR_MSG_PARAMS = "Action '%s' execution failed with parameters : '%s'. %s";
    private static final String ERROR_MSG_NO_PARAMS = "Action '%s' execution failed. %s";
    private static final String RESULT_MSG_NO_PARAMS = "Action executed successfully with results: '%s'. %s";
    private static final String RESULT_MSG_PARAMS = "Action executed successfully with results:: '%s' with parameters : '%s' . %s";
    private static final String TEXT_TIMEOUT = ", Timeout: ";
    private static final int DEFAULT_TIMEOUT = 5;
    private static final String TEXT_TIME_OUT = "Timeout: ";
    private Browser browserConfig;


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void sendText(WebElement element, String text) throws WebActionsException {
        sendText(element, text, DEFAULT_TIMEOUT);
    }

    public void sendText(WebElement element, String text, int timeout) throws WebActionsException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new WebActionsException("Ocurrio un error realizando accion sendText", e);
        }

    }

    public void moveTo(WebElement element, int timeout) throws WebActionsException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(driver -> element.findElement(By.xpath(".")));
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            throw new WebActionsException("Ocurrio un error realizando accion moveTo", e);
        }
    }

    public boolean isVisible(WebElement element) {
        return isVisible(element, DEFAULT_TIMEOUT);
    }

    public boolean isVisible(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException | NoSuchElementException | NullPointerException e) {
            return false;
        }
    }

    public void  closeModal(int timeout) throws WebActionsException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e){
            throw new WebActionsException("Ocurrio un error al cerrad el modal", e);
        }
    }

    public void selectByPartialText(WebElement selectElement, String optionPartialText, int timeout) throws WebActionsException {
        try {
            Select selectBox = new Select(selectElement);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(x -> !selectBox.getOptions().isEmpty());
            List<WebElement> options = selectBox.getOptions();
            for (int i = 0; i < options.size(); i++) {
                String textContent = options.get(i).getText();
                if (textContent.contains(optionPartialText)) {
                    selectBox.selectByIndex(i);
                    return;
                }
            }
            throw new NoSuchElementException("No such element containing text : '" + optionPartialText + "'");
        } catch (NoSuchElementException e) {
            String error = String.format(ERROR_MSG_PARAMS, "selectByPartialText", TEXT_TEXT + optionPartialText + TEXT_TIMEOUT + timeout);
            throw new WebActionsException(error, e);
        }
    }

    public void click(WebElement element) throws WebActionsException {
        click(element, DEFAULT_TIMEOUT);
    }

    public void click(WebElement element, int timeout) throws WebActionsException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (NoSuchElementException | NullPointerException | TimeoutException e) {
            throw new WebActionsException("Ocurrio un error realizando accion Clic", e);
        }
    }

    public String getText(WebElement element, int timeout) throws WebActionsException {
        String value = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            value = element.getText();
        } catch (NoSuchElementException | NullPointerException | TimeoutException e) {
            throw new WebActionsException("Ocurrio un error realizando accion Clic", e);
        }
        return value;
    }

    public void selectVisibleText(WebElement selectElement, String texto, int timeout) throws WebActionsException {
        try {
            Select selectBox = new Select(selectElement);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(x -> !selectBox.getOptions().isEmpty());
            selectBox.selectByVisibleText(texto);
        } catch (NoSuchElementException e) {
            throw new WebActionsException("Error validan funcion visible text", e);
        }
    }

    public void selectValue(WebElement selectElement, String texto, int timeout) throws WebActionsException {
        try {
            Select selectBox = new Select(selectElement);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(x -> !selectBox.getOptions().isEmpty());
            selectBox.selectByValue(texto);
        } catch (NoSuchElementException e) {
            throw new WebActionsException("Error con funcion Value", e);
        }
    }

    public void waitVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectIndex(WebElement selectElement, int index, int timeout) throws WebActionsException {
        try {
            Select selectBox = new Select(selectElement);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(x -> !selectBox.getOptions().isEmpty());
            selectBox.selectByIndex(index);
        } catch (NoSuchElementException e) {
            throw new WebActionsException("Ocurrio un error realizando accion select index", e);
        }
    }

    public void doubleClick(WebElement element, int timeout) throws WebActionsException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            new Actions(driver).doubleClick(element).perform();
        } catch (NoSuchElementException | NullPointerException | TimeoutException e) {
            throw new WebActionsException("Ocurrio un error realizando accion Clic", e);
        }
    }

    public void rightClick(WebElement element, int timeout) throws WebActionsException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            new Actions(driver).contextClick(element).perform();
        } catch (NoSuchElementException | NullPointerException | TimeoutException e) {
            throw new WebActionsException("Ocurrio un error realizando accion Clic", e);
        }
    }

    public void startWebApp(Browser browserConfiguration, String url) throws WebActionsException {
        try {
            this.browserConfig = browserConfiguration;
            driver = browserConfiguration.createDriver();
            driverNavigation(url);
        } catch (Exception e) {
            throw new WebActionsException("", e);
        }
    }

    private void driverNavigation(String url) {
        setDriver(driver);
        driver.get(url);
    }

    public void switchToFrame(WebElement webElemen) {
        driver.switchTo().frame(webElemen);
    }

    public enum AlertActions {
        ACCEPT(""), CLOSE(""), SEND_KEYS("");
        private String text;

        AlertActions(String value) {
            text = value;
        }

        public AlertActions keys(String text) {
            SEND_KEYS.text = text;
            return SEND_KEYS;
        }

        public String getKeys() {
            return SEND_KEYS.text;
        }
    }

    public void handleAlert(AlertActions action, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        switch (action) {
            case ACCEPT:
                alert.accept();
                break;
            case CLOSE:
                alert.dismiss();
                break;
            case SEND_KEYS:
                alert.sendKeys(action.getKeys());
                break;
        }
    }

    public WebDriver getNewWindow() throws WebActionsException {
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        } catch (Exception e) {
            throw new WebActionsException("Error al realizar cambio de ventana", e);
        }
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            try {
                driver.close();
            } catch (Exception e) {
                Log.LOGGER.warn("Window handlers already closed.");
            }
            driver.quit();
        }
        Log.LOGGER.info("============================= End Test ================================\n\n");
    }
}
