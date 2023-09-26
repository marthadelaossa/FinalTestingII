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
import pageObjects.ActividadCuentaPage;
import pageObjects.TransferirFondosPage;
import reporte.ExtentFactory;
import utils.MetodosWeb;


public class ActividadCuenta {

    public WebDriver driver;
    public WebDriverWait wait;
    ChromeDriveOptions chromeDriveOptions=new ChromeDriveOptions();

    ActividadCuentaPage actividadCuentaPage= new ActividadCuentaPage();

    static ExtentSparkReporter info = new ExtentSparkReporter("target/reporteActividadCuenta.html");
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
        metodosWeb.clickear(actividadCuentaPage.getLinkAccountsOverview());
        metodosWeb.validarMsn(actividadCuentaPage.getLblSuccessMessage());
        metodosWeb.clickear(actividadCuentaPage.getLinkToOneAccount());
        metodosWeb.validarMsn(actividadCuentaPage.getLblMessageAccount());
        metodosWeb.clickear(actividadCuentaPage.getSltActivityPeriod());
        metodosWeb.clickear(actividadCuentaPage.getOptActivityPeriod());
        metodosWeb.validarMsn(actividadCuentaPage.getSltType());
        metodosWeb.validarMsn(actividadCuentaPage.getOptType());
        metodosWeb.validarMsn(actividadCuentaPage.getBtnGo());

        test.log(Status.INFO, "Fin  Test");
    }


    @AfterEach
    public void cerrar() {
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.close();
    }

    @AfterAll
    public static void createReport() { extent.flush(); }
}
