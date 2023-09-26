package testFront;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driver.ChromeDriveOptions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.TransferirFondosPage;
import reporte.ExtentFactory;
import utils.MetodosWeb;


public class TestTransferirFondos {

    public WebDriver driver;
    public WebDriverWait wait;
    ChromeDriveOptions chromeDriveOptions=new ChromeDriveOptions();

    TransferirFondosPage transferirFondosPage= new TransferirFondosPage();

    static ExtentSparkReporter info = new ExtentSparkReporter("target/testTransferirFondos.html");
    static ExtentReports extent;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver(chromeDriveOptions.options());
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.setup();
        metodosWeb.url("https://parabank.parasoft.com/parabank/index.htm");
        metodosWeb.login();
    }


    @Test
    @Tag("transferirFondos")
    public void transferirFondos() throws InterruptedException {
        ExtentTest test = extent.createTest("Abrir Ceunta");
        test.log(Status.INFO, "Comienza el Test");
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.clickear(transferirFondosPage.getLinkTransferFunds());
        metodosWeb.clickear(transferirFondosPage.getSltFromccountId());
        metodosWeb.clickear(transferirFondosPage.getOptFromccountId());
        metodosWeb.clickear(transferirFondosPage.getSltToccountId());
        metodosWeb.clickear(transferirFondosPage.getOptToccountId());
        metodosWeb.sendKey("100", transferirFondosPage.getInputAmount());
        metodosWeb.clickear(transferirFondosPage.getBtnTransfer());
        metodosWeb.validarMsn(transferirFondosPage.getLblSuccessMessage());
        test.log(Status.INFO, "Fondos Transferidos , Fin  Test");
    }


    @AfterEach
    public void cerrar() {
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.close();
    }

    @AfterAll
    public static void createReport() { extent.flush(); }
}
