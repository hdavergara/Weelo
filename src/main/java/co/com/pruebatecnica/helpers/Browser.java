package co.com.pruebatecnica.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Browser {

    public enum Browsers {
        CHROME("chromedriver.exe"),
        FIREFOX("geckodriver.exe");

        private String driverFileName;

        Browsers(String name) {
            driverFileName = name;
        }

        public String getDriverFileName() {
            return driverFileName;
        }
    }
    private List<String> argumentsList = new ArrayList<>();
    private List<File> extensionsList = new ArrayList<>();
    private Map<String, Object> chromePrefs = new HashMap<>();
    private FirefoxProfile firefoxPrefs = new FirefoxProfile();
    private ChromeOptions chromeOptions = new ChromeOptions();
    private FirefoxOptions firefoxOptions = new FirefoxOptions();
    private InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
    private EdgeOptions edgeOptions = new EdgeOptions();

    private Browsers browser = Browsers.CHROME;
    private String downloadPath = "";
    private boolean isUsingBrowserOptions = true;
    private boolean isIncognito = false;
    private boolean isMaximized = false;
    private boolean isHeadless = false;
    private boolean ignoreAlerts = false;
    private boolean autoDriverDownload = true;
    private boolean isRemote = false;
    private boolean isRemoteVNCEnabled = false;
    private boolean isRemoteVideoEnabled = false;
    private boolean isUsingBrowserName = false;
    private Proxy proxy = null;
    private Platform currentOS = Platform.WIN10;
    private String hubURL = "http://localhost:4444/wd/hub";
    private String driverVersion = "";
    private String driverPath = "src/main/resources/drivers/";

    public List<String> getArgumentsList() {
        return argumentsList;
    }

    public void setArgumentsList(List<String> argumentsList) {
        this.argumentsList = argumentsList;
    }

    public List<File> getExtensionsList() {
        return extensionsList;
    }

    public void setExtensionsList(List<File> extensionsList) {
        this.extensionsList = extensionsList;
    }

    public Map<String, Object> getChromePrefs() {
        return chromePrefs;
    }

    public void setChromePrefs(Map<String, Object> chromePrefs) {
        this.chromePrefs = chromePrefs;
    }

    public FirefoxProfile getFirefoxPrefs() {
        return firefoxPrefs;
    }

    public void setFirefoxPrefs(FirefoxProfile firefoxPrefs) {
        this.firefoxPrefs = firefoxPrefs;
    }

    public ChromeOptions getChromeOptions() {
        return chromeOptions;
    }

    public void setChromeOptions(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

    public FirefoxOptions getFirefoxOptions() {
        return firefoxOptions;
    }

    public void setFirefoxOptions(FirefoxOptions firefoxOptions) {
        this.firefoxOptions = firefoxOptions;
    }

    public InternetExplorerOptions getInternetExplorerOptions() {
        return internetExplorerOptions;
    }

    public void setInternetExplorerOptions(InternetExplorerOptions internetExplorerOptions) {
        this.internetExplorerOptions = internetExplorerOptions;
    }

    public EdgeOptions getEdgeOptions() {
        return edgeOptions;
    }

    public void setEdgeOptions(EdgeOptions edgeOptions) {
        this.edgeOptions = edgeOptions;
    }

    public Browsers getBrowser() {
        return browser;
    }

    public void setBrowser(Browsers browser) {
        this.browser = browser;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public boolean isUsingBrowserOptions() {
        return isUsingBrowserOptions;
    }

    public void setUsingBrowserOptions(boolean usingBrowserOptions) {
        isUsingBrowserOptions = usingBrowserOptions;
    }

    public boolean isIncognito() {
        return isIncognito;
    }

    public void setIncognito(boolean incognito) {
        isIncognito = incognito;
    }

    public boolean isMaximized() {
        return isMaximized;
    }

    public void setMaximized(boolean maximized) {
        isMaximized = maximized;
    }

    public boolean isHeadless() {
        return isHeadless;
    }

    public void setHeadless(boolean headless) {
        isHeadless = headless;
    }

    public boolean isIgnoreAlerts() {
        return ignoreAlerts;
    }

    public void setIgnoreAlerts(boolean ignoreAlerts) {
        this.ignoreAlerts = ignoreAlerts;
    }

    public boolean isAutoDriverDownload() {
        return autoDriverDownload;
    }

    public void setAutoDriverDownload(boolean autoDriverDownload) {
        this.autoDriverDownload = autoDriverDownload;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public boolean isRemoteVNCEnabled() {
        return isRemoteVNCEnabled;
    }

    public void setRemoteVNCEnabled(boolean remoteVNCEnabled) {
        isRemoteVNCEnabled = remoteVNCEnabled;
    }

    public boolean isRemoteVideoEnabled() {
        return isRemoteVideoEnabled;
    }

    public void setRemoteVideoEnabled(boolean remoteVideoEnabled) {
        isRemoteVideoEnabled = remoteVideoEnabled;
    }

    public boolean isUsingBrowserName() {
        return isUsingBrowserName;
    }

    public void setUsingBrowserName(boolean usingBrowserName) {
        isUsingBrowserName = usingBrowserName;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Platform getCurrentOS() {
        return currentOS;
    }

    public void setCurrentOS(Platform currentOS) {
        this.currentOS = currentOS;
    }

    public String getHubURL() {
        return hubURL;
    }

    public void setHubURL(String hubURL) {
        this.hubURL = hubURL;
    }

    public String getDriverVersion() {
        return driverVersion;
    }

    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public WebDriver createDriver() {
        applyBrowser(isUsingBrowserName);
        applyDownloadDirectory(downloadPath);
        applyIncognito(isIncognito);
        applyMaximized(isMaximized);
        applyHeadless(isHeadless);
        applyVideo(isRemoteVideoEnabled);
        applyVNC(isRemoteVNCEnabled);
        applyProxy(proxy);
        try {
            applyIgnoreAlerts(ignoreAlerts);
        } catch (Exception e) {
            System.out.println("Ha ocurrdio un error" + e.getMessage());
        }
        switch (browser) {
            case CHROME:
                return createChromeDriver();
            case FIREFOX:
                return createFireFoxDriver();
            default:
                return createChromeDriver();
        }
    }

    private WebDriver createChromeDriver() {
        chromeOptions = addChromeOptions();
        if (autoDriverDownload) {
            WebDriverManager.chromedriver().version(driverVersion).setup();
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + browser.getDriverFileName());
        }
        if (isRemote) {
            try {
                return new RemoteWebDriver(new URL(hubURL), chromeOptions);
            } catch (MalformedURLException e) {
                return new ChromeDriver(chromeOptions);
            }
        } else {
            return new ChromeDriver(chromeOptions);
        }
    }

    private void applyBrowser(boolean isUsingBrowserName) {
        if (isUsingBrowserName) {
            switch (browser) {
                case CHROME:
                    chromeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
                    break;
                case FIREFOX:
                    firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
                    break;
            }
        }
    }

    private void applyProxy(Proxy proxy) {
        if (proxy != null) {
            switch (browser) {
                case CHROME:
                    chromeOptions.setCapability(CapabilityType.PROXY, proxy);
                    break;
                case FIREFOX:
                    firefoxOptions.setCapability(CapabilityType.PROXY, proxy);
                    break;
            }
        }
    }

    private WebDriver createFireFoxDriver() {
        FirefoxOptions firefoxOptions = addFirefoxOptions();
        if (autoDriverDownload) {
            WebDriverManager.firefoxdriver().version(driverVersion).setup();
        } else {
            System.setProperty("webdriver.gecko.driver", driverPath);
        }
        if (isRemote) {
            try {
                return new RemoteWebDriver(new URL(hubURL), firefoxOptions);
            } catch (MalformedURLException e) {
                return new FirefoxDriver(firefoxOptions);
            }
        } else {
            return new FirefoxDriver(firefoxOptions);
        }

    }

    private WebDriver createEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (autoDriverDownload) {
            WebDriverManager.edgedriver().version(driverVersion).setup();
        } else {
            System.setProperty("webdriver.edge.driver", driverPath);
        }
        if (isRemote) {
            try {
                return new RemoteWebDriver(new URL(hubURL), edgeOptions);
            } catch (MalformedURLException e) {
                return new EdgeDriver(edgeOptions);
            }
        } else {
            return new EdgeDriver(edgeOptions);
        }

    }

    private WebDriver createIEDriver() {
        if (autoDriverDownload) {
            WebDriverManager.iedriver().version(driverVersion).setup();
        } else {
            System.setProperty("webdriver.ie.driver", driverPath);
        }
        if (isRemote) {
            try {
                return new RemoteWebDriver(new URL(hubURL), internetExplorerOptions);
            } catch (MalformedURLException e) {
                return new InternetExplorerDriver(internetExplorerOptions);
            }
        } else {
            return new InternetExplorerDriver(internetExplorerOptions);
        }

    }


    private ChromeOptions addChromeOptions() {
        String[] listaArgumentos = argumentsList.toArray(new String[0]);
        chromeOptions.addExtensions(extensionsList);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments(listaArgumentos);
        return chromeOptions;
    }

    private FirefoxOptions addFirefoxOptions() {
        String[] listaArgumentos = argumentsList.toArray(new String[0]);
        firefoxOptions.addArguments(listaArgumentos);
        firefoxOptions.setProfile(firefoxPrefs);
        return firefoxOptions;
    }


    private void applyDownloadDirectory(String downloadPath) {
        String error;
        if (!downloadPath.isEmpty()) {
            String downloadDirectory = new File(downloadPath).getAbsolutePath();
            switch (browser) {
                case CHROME:
                    chromePrefs.put("download.default_directory", downloadDirectory);
                    argumentsList.add("--test-type");
                    break;
                case FIREFOX:
                    firefoxPrefs.setPreference("browser.download.dir", downloadDirectory);
                    firefoxPrefs.setPreference("browser.download.folderList", 2);
                    firefoxPrefs.setPreference("browser.helperApps.neverAsk.saveToDisk",
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");
                    firefoxPrefs.setPreference("browser.download.manager.showWhenStarting", false);
                    firefoxPrefs.setPreference("pdfjs.disabled", true);
                    break;
                default:
                    break;
            }
        }
    }

    private void applyIncognito(boolean isIncognito) {
        String error;
        if (isIncognito) {
            switch (browser) {
                case CHROME:
                    argumentsList.add("--incognito");
                    break;
                case FIREFOX:
                    firefoxPrefs.setPreference("browser.private.browsing.autostart", true);
                    break;
            }
        }
    }

    private void applyVNC(boolean isVNCEnabled) {
        String error;
        if (isVNCEnabled) {
            switch (browser) {
                case CHROME:
                    chromeOptions.setCapability("enableVNC", true);
                    break;
                case FIREFOX:
                    firefoxOptions.setCapability("enableVNC", true);
                    break;
            }
        }
    }

    private void applyVideo(boolean isVideoEnabled) {
        String error;
        if (isVideoEnabled) {
            switch (browser) {
                case CHROME:
                    chromeOptions.setCapability("enableVideo", false);
                    break;
                case FIREFOX:
                    firefoxOptions.setCapability("enableVideo", false);
                    break;
            }
        }
    }

    private void applyMaximized(boolean isMaximized) {
        String error;
        if (isMaximized) {
            switch (browser) {
                case CHROME:
                    argumentsList.add("--start-maximized");
                    break;
            }
        }
    }

    private void applyHeadless(boolean isHeadless) {
        String error;
        if (isHeadless) {
            switch (browser) {
                case CHROME:
                    argumentsList.add("--headless");
                    break;
                case FIREFOX:
                    argumentsList.add("-headless");
                    break;
            }
        }
    }

    public void addExtensions(String... extensionPaths) {
        String error;
        for (String extensionPath : extensionPaths) {
            File extensionFile = new File(extensionPath);
            switch (browser) {
                case CHROME:
                case FIREFOX:
                    extensionsList.add(extensionFile);
                    break;
            }
        }
    }

    private void applyIgnoreAlerts(boolean isIgnoreAlerts) {
        String error;
        if (isIgnoreAlerts) {
            switch (browser) {
                case CHROME:
                    chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                    break;
                case FIREFOX:
                    firefoxPrefs.setPreference("dom.webnotifications.enabled", false);
                    break;
            }
        }
    }
}
