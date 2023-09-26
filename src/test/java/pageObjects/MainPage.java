package pageObjects;

import org.openqa.selenium.By;

public class MainPage {

     public String SENHA ="Password123";
     private By btnRegister=By.xpath("//a[text()='Register']");

    private By inputUsername=By.xpath("//input[@name='username']");
    private By inputPassword=By.xpath("//input[@name='password']");

    private By btnLogin=By.xpath("//input[@value='Log In']");
    public By getBtnRegister() { return btnRegister; }

    public By getInputUsername() { return inputUsername;
    }

    public By getInputPassword() {return inputPassword;
    }

    public By getBtnLogin() { return btnLogin;
    }
}