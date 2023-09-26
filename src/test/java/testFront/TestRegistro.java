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
import pageObjects.MainPage;
import utils.MetodosWeb;
import pageObjects.RegistroPage;
import reporte.ExtentFactory;
import utils.Datos;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;


public class TestRegistro {

    public WebDriver driver;
    public WebDriverWait wait;

    public String USERNAME;



    ChromeDriveOptions chromeDriveOptions=new ChromeDriveOptions();
    Datos dataFaker = new Datos();

    MainPage mainPage = new MainPage();

    RegistroPage registroPage =new RegistroPage();

    static ExtentSparkReporter info = new ExtentSparkReporter("target/testRegistro.html");
    static ExtentReports extent;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver(chromeDriveOptions.options());
        wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.setup();
        metodosWeb.url("https://parabank.parasoft.com/parabank/index.htm");
    }


    @Test
    @Tag("registro")
    public void registro() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.clickear(mainPage.getBtnRegister());
        USERNAME=dataFaker.getNombre()+"_"+dataFaker.getNombre();
        try (PrintWriter out = new PrintWriter("./username.txt")) {
            out.println(USERNAME);
        } catch (FileNotFoundException ignored){}
        metodosWeb.sendKey(USERNAME, registroPage.getInputFirstname());
        metodosWeb.sendKey(dataFaker.getApellido(), registroPage.getInputLastname());
        metodosWeb.sendKey(dataFaker.getDireccion(), registroPage.getInputAddress());
        metodosWeb.sendKey(dataFaker.getCity(), registroPage.getInputCity());
        metodosWeb.sendKey(dataFaker.getEstado(), registroPage.getInputState());
        metodosWeb.sendKey(dataFaker.getZipCode(), registroPage.getInputZipCode());
        metodosWeb.sendKey(dataFaker.getCelular(), registroPage.getInputTelephone());
        metodosWeb.sendKey(dataFaker.getSSN(), registroPage.getInputSSN());
        metodosWeb.sendKey(USERNAME, registroPage.getInputUserName());
        metodosWeb.sendKey( mainPage.SENHA, registroPage.getInputPassword());
        metodosWeb.sendKey( mainPage.SENHA, registroPage.getInputConfirmPassword());
        metodosWeb.clickear(registroPage.getBtnRegister());
        metodosWeb.validarMsn(registroPage.getLblAccountCreated());
        test.log(Status.PASS, "Cuenta creada exitosamente");
        test.log(Status.INFO, "Fin  Test");
    }


    @AfterEach
    public void cerrar() {
        MetodosWeb metodosWeb= new MetodosWeb (driver, wait);
        metodosWeb.close();
    }

    @AfterAll
    public static void createReport() {
        extent.flush();
    }
}
