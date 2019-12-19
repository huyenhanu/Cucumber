package cucumberexample;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Stepdefs {
    WebDriver driver;
    LoginForm Login;
    @Before
    public void startingTest()
    {
        //Khowir taoj driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\bupbe\\OneDrive\\Desktop\\chromedriver.exe");
        //Create a instance of ChromeOptions class
        ChromeOptions options = new ChromeOptions();

        //Add chrome switch to disable notification - "--disable-notifications"
        options.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(options);
        this.Login = new LoginForm(this.driver);

    }

    @Given("^the login page is showed$")
    public void the_login_page_is_showed() throws Throwable {
        //Su dung driver de thuc hien cac task nhu yeu cau
        Login.openWebPage();
        Login.ClickLogin();
    }

    @When("^the user provides his credential with emplty Email or Phone and password then try to login$")
    public void the_user_provides_his_credential_with_emplty_email_or_phone_and_password_then_try_to_login() throws Throwable {
       Login.Login("","");
    }

    @Then("^the message \"([^\"]*)\" and \"([^\"]*)\" will be showed$")
    public void the_message_something_and_something_will_be_showed(String strArg1, String strArg2) throws Throwable {
       Login.SeeMessage("Chưa nhập email/số điện thoại","Chưa nhập mật khẩu");
    }




}
