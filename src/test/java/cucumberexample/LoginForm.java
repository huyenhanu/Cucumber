package cucumberexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginForm {
    WebDriver driver;
    By menuLogin = By.cssSelector("div.cx-account-control div.account__header");
    By btn = By.cssSelector("div.txt-color-67 a.cx-btn");
    By email = By.cssSelector("input#userId");
    By pass = By.cssSelector("input#password");
    By login = By.cssSelector("button[type=\"submit\"]");
    By errEmail = By.cssSelector("div.msg-error div.ng-star-inserted");
    By errPass = By.cssSelector("div.msg-error span");

    /*By btnFB = By.cssSelector("div.cx-social-login button.cx-btn-facebook");
    By fEmail = By.cssSelector("input#email");
    By fPass = By.cssSelector("input#pass");
    By fLogin = By.cssSelector("div#buttons input");
    By ErrMess = By.cssSelector("div.login_error_box div.fwb");*/

    public LoginForm(WebDriver driver){
        this.driver = driver;
    }
    private void insertText(By cssEditor, String text) {
        this.driver.findElement(cssEditor).sendKeys(text);
    }
    private void click(By cssEditor) {
        this.driver.findElement(cssEditor).click();
    }
    private static void Hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void openWebPage(){
        this.driver.get("https://www.adayroi.com/");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void ClickLogin(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 10);
        Hover(this.driver,this.driver.findElement(menuLogin));
        WebElement monthElement = waiter.until(ExpectedConditions.presenceOfElementLocated(btn));
        monthElement.click();
    }

    public void Login(String txtEmail, String txtPass){
        insertText(email, txtEmail);
        insertText(pass, txtPass);
        click(login);
    }

    public void SeeMessage(String erEmail, String erPass){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
       // WebElement notify = wait.until(ExpectedConditions.presenceOfElementLocated(errEmail));
        Assert.assertEquals(erEmail ,this.driver.findElement(errEmail).getText());
        Assert.assertEquals(erPass ,this.driver.findElement(errPass).getText());
    }
}