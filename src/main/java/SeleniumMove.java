import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SeleniumMove {

    public static LoginSel loginPage;
    public static StartSel startTc;
    public static PauseSel pauseTc;
    public static WebDriver driver;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        loginPage = new LoginSel(driver);
        startTc = new StartSel(driver);
        pauseTc = new PauseSel(driver);
        driver.get(Regisration.timecontrol_page);
    }

    public static void loginAndStart() {
        loginPage.inputLogin(Regisration.login_for_sel);
        loginPage.inputPasswd(Regisration.password_for_sel);
        loginPage.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startTc.clickStartBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startTc.clickNextStartBtn();
        driver.close();
        driver.quit();
        System.out.println("                                                                                                  ");
        System.out.println("Timecontrol launched");


    }

    public static void loginAndPause() {
        loginPage.inputLogin(Regisration.login_for_sel);
        loginPage.inputPasswd(Regisration.password_for_sel);
        loginPage.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pauseTc.clickPauseBtn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
        System.out.println("                                                                                                  ");
        System.out.println("Timecontrol stopped");

    }
}


class LoginSel {
    public WebDriver driver;

    public LoginSel(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'login-form-username')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'login-form-password')]")
    private WebElement passwdField;


    @FindBy(xpath = "//*[contains(@id, 'login-form-submit')]")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String password) {
        passwdField.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }


}

class StartSel {

    public WebDriver driver;

    public StartSel(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'action_id_4')]")
    private WebElement startBtn;

    @FindBy(xpath = "//*[contains(@id, 'issue-workflow-transition-submit')]")
    private WebElement NextStartBtn;

    public void clickStartBtn() {
        startBtn.click();
    }

    public void clickNextStartBtn() {
        NextStartBtn.click();
    }
}

class PauseSel {
    public WebDriver driver;

    public PauseSel(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'action_id_711')]")
    private WebElement PauseBtn;

    public void clickPauseBtn() {
        PauseBtn.click();
    }
}