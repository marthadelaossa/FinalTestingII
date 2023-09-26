package pageObjects;

import org.openqa.selenium.By;

public class ResumenCuentasPage {

    private By linkAccountsOverview=By.xpath("//a[text()='Accounts Overview']");
    private  By lblSuccessMessage = By.xpath("(//td[contains(text(),'*Balance includes deposits that may be subject to hold')])");

    public By getLinkAccountsOverview() {return linkAccountsOverview; }

    public By getLblSuccessMessage() {
        return lblSuccessMessage;
    }
}
