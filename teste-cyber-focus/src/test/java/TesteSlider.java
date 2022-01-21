import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TesteSlider {

    //@Test
    public static void executarQuartoteste(WebDriver janela){

        WebElement elemento;

        ExecutorDeTestes.esperar(2000);

        ExecutorDeTestes.minimizarPropagandoInferior(janela);

        //Mover o Slider ate a metade
        elemento = janela.findElement(By.xpath("//*[@id='slider']"));
        int x = Integer.parseInt(elemento.getDomProperty("scrollWidth"))/2;
        int y = Integer.parseInt(elemento.getDomProperty("scrollHeight"))/2;
        elemento = janela.findElement(By.xpath("//*[@id='slider']/*[@href='#']"));
        Actions acoes = new Actions(janela);
        acoes.dragAndDropBy(elemento, x, y).build().perform();

        //Deselecionar o botao de slider
        elemento = janela.findElement(By.xpath("//*[@class='container']"));
        elemento.click();

        ExecutorDeTestes.esperar(2000);

        System.out.println("Teste de slider executado com sucesso!");

    }

}
