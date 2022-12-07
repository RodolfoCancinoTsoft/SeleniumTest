package ejemploSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccionesSelenium {

    public static void main(String[] args) throws InterruptedException {

        //Enlazar el webdriver

        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(5000);

        driver.quit();
    }
}
