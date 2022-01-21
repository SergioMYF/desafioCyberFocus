import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ConstrutorDeJanelas {

    //Valores do "browser":0 = chrome;1 = edge;
    public static WebDriver construirWebDriver(int browser, String url){

        WebDriver webDriver;

        switch (browser){
            case 1:
                System.setProperty("webdriver.edge.driver","recursos/edgedriver.exe");
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                System.out.println("");
                break;

            default:
                System.setProperty("webdriver.chrome.driver","recursos/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }


        webDriver.navigate().to(url);
        webDriver.manage().window().maximize();

        try {

            Thread.sleep(2000);

        }catch (Exception exception){}

        return webDriver;

    }

}