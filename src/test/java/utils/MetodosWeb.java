package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MainPage;

import static org.eclipse.aether.repository.AuthenticationContext.PASSWORD;

public class MetodosWeb {

     public WebDriver driver;
     public WebDriverWait wait;

     MainPage mainPage = new MainPage();


     public MetodosWeb(WebDriver driver, WebDriverWait wait) {
          this.driver = driver;
          this.wait = new WebDriverWait(driver, Duration.ofMillis(2000));
     }


     public void setup() {
          System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
     }

     public void url(String url) throws InterruptedException {
          driver.get(url);
          Thread.sleep(1000);
     }

     public WebElement findElement(By locator) {
          wait.until(ExpectedConditions.presenceOfElementLocated(locator));
          return driver.findElement(locator);
     }

     public void sendKey(CharSequence pressKeys, By locator) {
          wait.until(ExpectedConditions.presenceOfElementLocated(locator));
          this.findElement(locator).sendKeys(pressKeys);
     }

     public void clickear(By locator) {
          wait.until(ExpectedConditions.elementToBeClickable(locator));
          this.findElement(locator).click();
     }


     public void waitImplicit() throws InterruptedException {
          Thread.sleep(5000);
     }
     public void validarMsn(By locator) {
          wait.until(ExpectedConditions.presenceOfElementLocated(locator));
     }
     public void close() {
          driver.quit();
     }

     public void login() {
          String username = null;
          try(BufferedReader in = new BufferedReader(new FileReader("./username.txt"))){ username = in.readLine();} catch (IOException ignored) {}
          sendKey(username, mainPage.getInputUsername());
          sendKey( mainPage.SENHA, mainPage.getInputPassword());
          clickear(mainPage.getBtnLogin());
     }
}