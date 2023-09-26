package pageObjects;

import org.openqa.selenium.By;

public class ActividadCuentaPage {

    private By linkAccountsOverview=By.xpath("//a[text()='Accounts Overview']");
    private  By lblSuccessMessage = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to holds')]");
    private By linkToOneAccount=By.xpath("(//tbody//child::a)[1]");
    private  By lblMessageAccount = By.xpath("//h1[contains(text(),'Account Details')]");
    private By sltActivityPeriod=By.xpath("//select[@id='month']");
    private By optActivityPeriod=By.xpath("(//option[@value='All'])[1]");
    private By sltType=By.xpath("//select[@id='transactionType']");
    private By optType=By.xpath("(//option[@value='All'])[2]");
    private By btnGo=By.xpath("//input[@value='Go']");

    public By getLinkAccountsOverview() {
        return linkAccountsOverview;
    }

    public By getLblSuccessMessage() {
        return lblSuccessMessage;
    }

    public By getLinkToOneAccount() {
        return linkToOneAccount;
    }

    public By getLblMessageAccount() {
        return lblMessageAccount;
    }

    public By getSltActivityPeriod() {
        return sltActivityPeriod;
    }

    public By getOptActivityPeriod() {
        return optActivityPeriod;
    }

    public By getSltType() {
        return sltType;
    }

    public By getOptType() {
        return optType;
    }

    public By getBtnGo() {
        return btnGo;
    }
}
