package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Artigo {
    String url;
    WebDriver driver;

    @Before
    public void steup(){
        url = "https://www.cobasi.com.br/";
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/88/chromedriver");
        driver = new ChromeDriver(); // instanciar o selenium como Chrome driver

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void consultArticle(){
        //Abrir o site
        driver.get(url);

        //Pesquisar por coleira
        driver.findElement(By.name("q")).sendKeys("coleira");
        driver.findElement(By.className("btn-buscar")).click();//Clica na Lupa

        //Validar o Titulo da pagina de retorno
        assertEquals("Coleira - Cobasi",driver.getTitle());

    }

    @After
    public void TearDown(){
        driver.quit();

    }



}

