package testBack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.MainPage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class TestBack {
    String mainUrl = "https://parabank.parasoft.com/parabank/services/bank";
    String customerId;
    String accountId;
    MainPage mainPage = new MainPage();


    @BeforeEach
    public void login() {
        String username = null;
        try(BufferedReader in = new BufferedReader(new FileReader("./username.txt"))){
            username = in.readLine();
        } catch (IOException ignored) {}

        Response responseCustomer = RestAssured.get(mainUrl+"/login/"+username+"/"+ mainPage.SENHA);
        customerId = responseCustomer.xmlPath().getString("customer.id");

        Response responseAccount = RestAssured.get(mainUrl+"/customers/"+customerId+"/accounts");
        accountId = responseAccount.xmlPath().getString("accounts.account[0].id");
    }



    @Test
    @DisplayName("testRegistro")
    public void postTestRegistro() {
        String username = null;
        try(BufferedReader in = new BufferedReader(new FileReader("./username.txt"))){
            username = in.readLine();
        } catch (IOException ignored) {}
        Map<String, String> params = new HashMap<>();
        params.put("customerId", customerId);
        params.put("firstName", "Martha");
        params.put("lastName", "De la Ossa");
        params.put("street", "123");
        params.put("city", "Magangue");
        params.put("state","Bolivar");
        params.put("zipCode", "1458522145");
        params.put("phoneNumber","3231545454");
        params.put("ssn","1234");
        params.put("username",username);
        params.put("password", "Password123");
        given()
                .queryParams(params)
                .when()
                .post(mainUrl+"/customers/update/"+customerId)
                .then()
                .statusCode(200).log().all();
    }

    @Test
    @DisplayName("TestAbrirNuevaCuenta")
    public void postTestAbrirNuevaCuenta() {
            given()
                .queryParams(Map.of(
                        "customerId",customerId,
                        "newAccountType", 1,
                        "fromAccountId", accountId
                ))
                .when()
                .post(mainUrl+"/createAccount")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    @DisplayName("TestResumenDelasCeuntas")
    public void getTestResumenDelasCeuntas() {
        given()
                .when()
                .get(mainUrl+"/accounts/"+accountId)
                .then()
                .statusCode(200).log().all();
    }

    @Test
    @DisplayName("TestTransferenciaDeFondos")
    public void postTestTransferenciaDeFondos() {
        Response response = RestAssured.get(mainUrl+"/customers/"+customerId+"/accounts");
        String accountIdOne = response.xmlPath().getString("accounts.account[0].id");
        String accountIdTwo = response.xmlPath().getString("accounts.account[1].id");

        given()
                .queryParams(Map.of(
                        "fromAccountId", accountIdOne,
                        "toAccountId", accountIdTwo,
                        "amount", 50
                ))
                .when()
                .post(mainUrl+"/transfer")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    @DisplayName("TestActividadDelaCuenta")
    public void getTestActividadDelaCuenta() {
         given()
                .when()
                .get(mainUrl+"/accounts/"+accountId+"/transactions/month/All/type/All")
                .then()
                .statusCode(200).log().all();
    }


}
