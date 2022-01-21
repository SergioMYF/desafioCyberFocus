import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExecutorDeTestes {

    @Test
    public void testes(){

        //Escolher um usuario para o teste
        //NOTA: e possivel selecionar outros usuarios para teste alterando o numero na linha
        UsuarioParaTeste usuario = new UsuarioParaTeste("recursos/usuarios_para_teste.txt", 1);

        //Instanciar uma janela e navegar ate pagina de Formulario
        //NOTA: use o valor de browser para usar o Chrome e 1 para usar o Edge
        WebDriver janela = ConstrutorDeJanelas.construirWebDriver(0, "http://demo.automationtesting.in/Register.html");

        //Executar o teste da pagina do formulario (primeiro teste)
        {
            TesteFormulario testeFormulario = new TesteFormulario();
            testeFormulario.executarPrimeiroTeste(janela, usuario);
        }

        //Ir ate a pagina de teste de Frames
        irParaTesteFrames(janela);

        //Fechar anuncio
        {
            esperar(1000);
            janela.switchTo().frame("aswift_2");
            janela.switchTo().frame("ad_iframe");
            WebElement elemento = janela.findElement(By.xpath("//*[@id='dismiss-button']"));
            elemento.click();
        }

        //Executar o teste da pagina de frames (segundo teste)
        TesteFrames.executarSegundoTeste(janela, usuario);

        //Ir ate a pagina de teste de Datapicker
        irParaTesteDatapicker(janela);

        //Executar o teste da pagina de Datapicker (terceiro teste)
        {
            //Atualizar os dados com a data atual para maior precisao
            TesteDataPicker dataPicker = new TesteDataPicker(21,"January", 2022);
            dataPicker.executarTerceiroteste(janela, usuario);
        }

        //Ir ate a pagina de Slider
        irParaTesteSlider(janela);

        //Executar a pagina de Slider (quato teste)
        TesteSlider.executarQuartoteste(janela);

        //Fechar janela
        janela.quit();

    }

    public static void esperar(int tempoMiliSec){

        try{
            Thread.sleep(tempoMiliSec);
        }catch (Exception exception){}

    }

    public static void minimizarPropagandoInferior(WebDriver janela){

        WebElement elemento = janela.findElement(By.xpath("//*[@stroke='#FAFAFA']"));
        elemento.click();

        ExecutorDeTestes.esperar(2000);

    }

    public static void irParaTesteFormulario(WebDriver janela){

        WebElement elemento = janela.findElement(By.xpath("//*[@href='Register.html']"));
        elemento.click();

    }

    public static void irParaTesteFrames(WebDriver janela){

        WebElement elemento = janela.findElement(By.xpath("//*[.='SwitchTo']"));
        elemento.click();
        esperar(1000);

        elemento = janela.findElement(By.xpath("//*[@href='Frames.html']"));
        elemento.click();

    }

    public static void irParaTesteDatapicker(WebDriver janela){

        WebElement elemento = janela.findElement(By.xpath("//*[.='Widgets']"));
        elemento.click();
        esperar(1000);

        elemento = janela.findElement(By.xpath("//*[@href='Datepicker.html']"));
        elemento.click();

    }

    public static void irParaTesteSlider(WebDriver janela){

        WebElement elemento = janela.findElement(By.xpath("//*[.='Widgets']"));
        elemento.click();
        esperar(1000);

        elemento = janela.findElement(By.xpath("//*[@href='Slider.html']"));
        elemento.click();

    }

}
