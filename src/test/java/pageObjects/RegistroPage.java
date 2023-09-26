package pageObjects;

import org.openqa.selenium.By;

public class RegistroPage {

    private By inputFirstname=By.xpath("//input[@id='customer.firstName']");
    private By inputLastname=By.xpath("//input[@id='customer.lastName']");
    private By inputAddress=By.xpath("//input[@id='customer.address.street']");
    private By inputCity=By.xpath("//input[@id='customer.address.city']");
    private By inputState=By.xpath("//input[@id='customer.address.state']");
    private By inputZipCode=By.xpath("//input[@id='customer.address.zipCode']");
    private By inputTelephone=By.xpath("//input[@id='customer.phoneNumber']");
    private By inputSSN=By.xpath("//input[@id='customer.ssn']");
    private By inputUserName=By.xpath("//input[@id='customer.username']");
    private By inputPassword=By.xpath("//input[@id='customer.password']");
    private By inputConfirmPassword=By.xpath("//input[@id='repeatedPassword']");
    private By btnRegister=By.xpath("//input[@value='Register']");
    private By lblAccountCreated=By.xpath("//*[contains(text(),'Your account was created successfully. You are now logged in.')]");
    public By getInputFirstname() {return inputFirstname;}
    public By getInputLastname() {return inputLastname;}
    public By getInputZipCode() {return inputZipCode;}
    public By getInputTelephone() {return inputTelephone;}
    public By getInputUserName() {return inputUserName;}
    public By getInputPassword() {return inputPassword;}
    public By getInputConfirmPassword() {return inputConfirmPassword;}
    public By getBtnRegister() {return btnRegister;}
    public By getLblAccountCreated() {return lblAccountCreated;}
    public By getInputAddress() {return inputAddress;}
    public By getInputCity() {return inputCity;}
    public By getInputState() {return inputState;}
    public By getInputSSN() {return inputSSN;}
}
