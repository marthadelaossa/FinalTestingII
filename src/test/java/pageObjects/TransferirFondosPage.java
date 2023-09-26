package pageObjects;

import org.openqa.selenium.By;

public class TransferirFondosPage {

    private By linkTransferFunds=By.xpath("//a[text()='Transfer Funds']");
    private  By inputAmount = By.xpath("(//input[@id='amount'])");
    private By sltFromccountId=By.xpath("//select[@id='fromAccountId']");

    private By optFromccountId=By.xpath("(//select[@id='fromAccountId']//child::option)[1]");

    private By sltToccountId=By.xpath("//select[@id='toAccountId']");

    private By optToccountId=By.xpath("(//select[@id='toAccountId']//child::option)[2]");

    private By btnTransfer=By.xpath("//input[@value='Transfer']");
    private  By lblSuccessMessage = By.xpath("//h1[contains(text(),'Transfer Complete!')]");

    public By getLinkTransferFunds() {
        return linkTransferFunds;
    }

    public By getInputAmount() {
        return inputAmount;
    }

    public By getSltFromccountId() {
        return sltFromccountId;
    }

    public By getOptFromccountId() {
        return optFromccountId;
    }

    public By getSltToccountId() {
        return sltToccountId;
    }

    public By getOptToccountId() {
        return optToccountId;
    }

    public By getBtnTransfer() {
        return btnTransfer;
    }

    public By getLblSuccessMessage() {
        return lblSuccessMessage;
    }
}
