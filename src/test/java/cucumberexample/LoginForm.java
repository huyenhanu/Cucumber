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
    By btnFB = By.cssSelector("div.cx-social-login button.cx-btn-facebook");
    By fEmail = By.cssSelector("input#email");
    By fPass = By.cssSelector("input#pass");
    By fLogin = By.cssSelector("div#buttons input");
    By ErrMess = By.cssSelector("div.login_error_box div.fwb");

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
    public void ClickLoginFB(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 10);
        Hover(this.driver,this.driver.findElement(menuLogin));
        WebElement monthElement = waiter.until(ExpectedConditions.presenceOfElementLocated(btnFB));
        monthElement.click();
    }
    public void switchFB(String email, String pass) throws InterruptedException {
        String MainWindow = driver.getWindowHandle();
        Set s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                insertText(fEmail,email);
                insertText(fPass,pass);
                Thread.sleep(2000);
                click(fLogin);
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }

    public void SeeMessage(String mess){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement notify = wait.until(ExpectedConditions.presenceOfElementLocated(ErrMess));
        Assert.assertEquals(mess,this.driver.findElement(ErrMess).getText());
    }
}