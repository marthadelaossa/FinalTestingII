package driver;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriveOptions {


    public ChromeOptions options (){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        return (options);
    }
}
