package pageObjects;

import org.openqa.selenium.By;

public class AbrirCuentaPage {

    private By linkOpenNewAccount=By.xpath("//a[text()='Open New Account']");
    private  By lblAccountService = By.xpath("(//h2[contains(text(),'Account Services')])");
    private By sltTypeAccount=By.xpath("//select[@id='type']");

    private By optTypeAccount=By.xpath("//option[@value='1']");

    private By btnOpenNewAccount=By.xpath("//input[@value='Open New Account']");
    private  By lblSuccessMessage = By.xpath("(//p[contains(text(),'Congratulations, your account is now open.')])");

    public By getLinkOpenNewAccount() {
        return linkOpenNewAccount;
    }

    public By getLblAccountService() {
        return lblAccountService;
    }

    public By getSltTypeAccount() {
        return sltTypeAccount;
    }

    public By getOptTypeAccount() {
        return optTypeAccount;
    }

    public By getBtnOpenNewAccount() {
        return btnOpenNewAccount;
    }

    public By getLblSuccessMessage() {
        return lblSuccessMessage;
    }
}
