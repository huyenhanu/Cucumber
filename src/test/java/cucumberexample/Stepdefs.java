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
        Login.ClickLoginFB();
    }

    @When("^the user provides his credential with emplty \"([^\"]*)\" or \"([^\"]*)\" then try to login$")
    public void the_user_provides_his_credential_with_emplty_something_or_something_then_try_to_login(String email,String pass) throws Throwable {
        //THuwcj hien nhap cac thong tin de dang nhap
        Login.switchFB(email,pass);
    }

    @Then("^the message \"([^\"]*)\" will be showed$")
    public void the_message_something_will_be_showed(String mess) throws Throwable {
        Login.SeeMessage(mess);
    }

   /* @When("^the user provides his credential with emplty Password then try to login$")
    public void the_user_provides_his_credential_with_emplty_password_then_try_to_login() throws Throwable {

    }

    @When("^the user provides his credential with  incorrect format Email or Phone then try to login$")
    public void the_user_provides_his_credential_with_incorrect_format_emailphone_then_try_to_login() throws Throwable {

    }

    @When("^the user provides his credential with invalid Email or Phone then try to login$")
    public void the_user_provides_his_credential_with_invalid_emailphone_then_try_to_login() throws Throwable {

    }

    @When("^the user provides his credential with invalid Password then try to login$")
    public void the_user_provides_his_credential_with_invalid_password_then_try_to_login() throws Throwable {

    }

    @When("^the user provides his credential then try to login$")
    public void the_user_provides_his_credential_then_try_to_login() throws Throwable {

    }*/


    /*@Then("^the message \"([^\"]*)\" and \"([^\"]*)\" will be showed$")
    public void the_message_something_and_something_will_be_showed(String strArg1, String strArg2) throws Throwable {

    }

    @Then("^the daskboard will be showed$")
    public void the_daskboard_will_be_showed() throws Throwable {

    }*/
}
