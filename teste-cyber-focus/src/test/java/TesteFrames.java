import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteFrames {

   //@Test
    public static void executarSegundoTeste(WebDriver janela, UsuarioParaTeste usuario){

        WebElement elemento;

        ExecutorDeTestes.esperar(2000);

        ExecutorDeTestes.minimizarPropagandoInferior(janela);

        //Escrever dentro do frame
        janela.switchTo().frame("singleframe");
        elemento = janela.findElement(By.xpath("//*[@type='text']"));
        elemento.sendKeys(usuario.getComentario());

        //Selecionar a janela
        janela.switchTo().parentFrame();

        ExecutorDeTestes.esperar(2000);

        System.out.println("Teste de frames executado com sucesso!");

    }

}
