#   Testing II
##  Proyecto Final

##  Objetivo
Crear un proyecto completo de Pruebas Automatizadas usando Java y Selenium, con Suites, Etiquetas e Informes, validando también una API RestAssured.
Sistema bajo prueba: Para Bank
Título del caso de prueba: Proceso de registro, apertura de una nueva cuenta, visión general de la cuenta, transferencia de fondos, actividad de la cuenta, para todas las etapas de las pruebas frontales Pruebas Front-end:

## Pruebas Front-end:

1.  Registro: 
      1.    Haga clic en Registro 
      2.	Rellene el formulario de registro con los datos requeridos 
      3.	Pulse de nuevo en <Registro>. 
      4.	Compruebe que el texto "Su cuenta se ha creado correctamente. En la pantalla se puede ver "You are now logged in". 

2.  Abrir una nueva cuenta :

      1.    Haga clic en Abrir nueva cuenta. 
      2.	En el apartado "¿Qué tipo de cuenta desea abrir?" seleccione la opción <SAVINGS>. 
      3.	Haga clic en <Abrir nueva cuenta> 
      4.	Compruebe si el texto "Congratulations, your account is now open." está visible en la pantalla 


3. Resumen de las cuentas:
   1.	Haga clic en <Resumen de cuentas> 
   2.	Compruebe si el texto "*El saldo incluye depósitos que pueden estar sujetos a retenciones" está visible en la pantalla 
 
4. Transferir Fondos :
      1.	Haga clic en <Transferencia de fondos> 
      2.	Compruebe que el texto "Transferir fondos" es visible en la pantalla 
      3.	En el campo Importe: $ introduzca el importe a transferir 
      4.	En el campo De la cuenta # seleccione una cuenta 
      5.	En el campo a la cuenta # seleccione una cuenta distinta a la anterior 
      6.	Haga clic en Transferencia
      7.	Compruebe que el texto "¡Transferencia completa!" es visible en la pantalla 
      8.	Haga clic en Resumen de cuentas
   
5. Actividad de la cuenta (cada mes):

      1.	Compruebe que el texto "*El saldo incluye depósitos que pueden estar sujetos a retenciones" es visible en la pantalla 
      2.	Haga clic en una cuenta en la columna <Cuenta>. 
      3.	Compruebe que el texto "Detalles de la cuenta" es visible en la pantalla 
      4.	En "Actividad de la cuenta" haga clic en <Periodo de actividad:> y seleccione "Todo" 
      5.	En "Actividad de la cuenta" haga clic en <Tipo:> y seleccione "Todo" 
      6.	Haga clic en <Ir> 

## Prueba back end de la API Rest:

Prueba back end de la API Rest: 
Validación del código de estado 200 para todas las etapas de las pruebas frontales 

1.	Registro URL: https://parabank.parasoft.com/parabank/register.htm 
2.	Abrir una nueva cuenta URL: https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=xxxxx 
3.	Resumen de las cuentas URL: https://parabank.parasoft.com/parabank/overview.htm 
4.	Descarga de fondos URL: https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx 
5.	Actividad de la cuenta (cada mes) URL: https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All 

# Caracteristicas:

## Patro de Diseño: POM
## RestAssuredng
## Gestor de Dependencia Maven

