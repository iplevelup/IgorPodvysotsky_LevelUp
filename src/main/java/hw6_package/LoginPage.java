package hw6_package;

// TODO Неиспользуемые импорты
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy (id = "username")
    private WebElement userNameTextField;

    @FindBy (id = "password")
    private WebElement passwordTextField;

    @FindBy (xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TODO А почему метод protected?
    // TODO Лучшу было бы использовать объект вместо 2-х параметров
    protected void login(final String username, final String password){
        //Enter login and password
        userNameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}
