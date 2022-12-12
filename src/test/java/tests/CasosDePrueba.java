package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CasosDePrueba {

    private WebDriver driver;
    private WebDriverWait wait;

    private JavascriptExecutor js;

    private String rutaDriver= System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String propertyDriver = "webdriver.chrome.driver";

    @AfterMethod
    public void posCondicion(){
        driver.close();
    }

    @BeforeMethod
    public void preCondiciones(){

        System.setProperty(propertyDriver,rutaDriver);

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10);

        js = (JavascriptExecutor) driver;

        driver.navigate().to("https://open.spotify.com/");

        driver.manage().window().maximize();
    }

    @Test
    public void CP001_Buscar_por_Banda() throws InterruptedException {
        //Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[2]/a"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/input"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/input"))).sendKeys("Metallica");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/input"))).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/section[1]/div[2]"))).click();

        Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Metallica')]"))).getText(),"Metallica");

    }

    @Test

    public void CP002_Inicio_Seccion_Google() throws InterruptedException {

        By localizadorBtnIniciaSeccion = By.xpath("//span[text() = 'Iniciar sesión']");
        Thread.sleep(2000);
        WebElement btnInicioSesion = driver.findElement(localizadorBtnIniciaSeccion);
        Thread.sleep(2000);
        btnInicioSesion.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-testid= 'google-login']")).click();
        Thread.sleep(2000);
        //String tituloPagina = driver.getTitle();
        //System.out.println(tituloPagina);
        Assert.assertEquals(driver.getTitle(),"Inicia sesión: Cuentas de Google");

    }

    @Test

    public void CP003_Inicio_Seccion_Facebook() throws InterruptedException {

        By localizadorBtnIniciaSeccion = By.xpath("//span[text() = 'Iniciar sesión']");
        Thread.sleep(2000);
        WebElement btnInicioSesion = driver.findElement(localizadorBtnIniciaSeccion);
        Thread.sleep(2000);
        btnInicioSesion.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-testid= 'facebook-login']")).click();
        Thread.sleep(2000);
        //String tituloPagina = driver.getTitle();
        //System.out.println(tituloPagina);
        Assert.assertEquals(driver.getTitle(),"Iniciar sesión en Facebook | Facebook");

    }

    @Test

    public void CP004_Inicio_Seccion_Apple() throws InterruptedException {

        By localizadorBtnIniciaSeccion = By.xpath("//span[text() = 'Iniciar sesión']");
        Thread.sleep(2000);
        WebElement btnInicioSesion = driver.findElement(localizadorBtnIniciaSeccion);
        Thread.sleep(2000);
        btnInicioSesion.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-testid= 'apple-login']")).click();
        Thread.sleep(2000);
        //String tituloPagina = driver.getTitle();
        //System.out.println(tituloPagina);
        Assert.assertEquals(driver.getTitle(),"Inicia sesión con el ID de Apple");

    }

    @Test

    public void CP005_Inicio_Seccion_Numero_Telefono() throws InterruptedException {

        By localizadorBtnIniciaSeccion = By.xpath("//span[text() = 'Iniciar sesión']");
        Thread.sleep(2000);
        WebElement btnInicioSesion = driver.findElement(localizadorBtnIniciaSeccion);
        Thread.sleep(2000);
        btnInicioSesion.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-testid= 'phone-login']")).click();
        Thread.sleep(2000);
        //String tituloPagina = driver.getTitle();
        //System.out.println(tituloPagina);
        Assert.assertEquals(driver.getTitle(),"Iniciar sesión - Spotify");

    }

    @Test

    public void CP006_Tipos_Pruebas_Xpath_Buscar_Por_Artista(){

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[2]/a"))).click();
        By localizadorBtnBuscar = By.xpath("//span[contains(text(),'Buscar')]");
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']")));
        driver.findElement(By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']")).sendKeys("Metallica");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']")));

        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']")).getText(),"");

    }

    @Test

    public void CP007_Inicio_Seccion_Facebook_Xpath(){
        By localizadorBtnIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");
        WebElement btnIniciarSesion = driver.findElement(localizadorBtnIniciarSesion);
        btnIniciarSesion.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='facebook-login']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Iniciar sesión en Facebook')]")));

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Iniciar sesión en Facebook')]")).getText(),"Iniciar sesión en Facebook");


    }

    @Test

    public void CP008_Inicio_Seccion_Apple_Xpath(){
        By localizadorBtnIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");
        WebElement btnIniciarSesion = driver.findElement(localizadorBtnIniciarSesion);
        btnIniciarSesion.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='apple-login']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='account_name_text_field']")));

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='account_name_text_field']")).getText(),"");

    }

    @Test

    public void CP009_Inicio_Seccion_Google_Xpath() {
        By localizadorBtnIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");
        WebElement btnIniciarSesion = driver.findElement(localizadorBtnIniciarSesion);
        btnIniciarSesion.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='google-login']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Iniciar sesión con Google')]")));

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Iniciar sesión con Google')]")).getText(),"Iniciar sesión con Google");
    }

    @Test

    public void CP010_Inicio_Seccion_Google_Xpath(){

        By localizadorBtnIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");
        WebElement btnIniciarSesion = driver.findElement(localizadorBtnIniciarSesion);
        btnIniciarSesion.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='phone-login']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Introducir número de teléfono')]")));

        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Introducir número de teléfono')]")).getText(),"Introducir número de teléfono");

    }


}
