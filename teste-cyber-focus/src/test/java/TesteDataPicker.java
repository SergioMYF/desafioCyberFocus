import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteDataPicker {

    private int diaAtual;
    private String mesAtual;
    private int anoAtual;

    public TesteDataPicker(int diaAtual, String mesAtual, int anoAtual){

        this.diaAtual = diaAtual;
        this.mesAtual = mesAtual;
        this.anoAtual = anoAtual;

    }

    //@Test
    public void executarTerceiroteste(WebDriver janela, UsuarioParaTeste usuario){

        WebElement elemento;

        ExecutorDeTestes.esperar(2000);

        ExecutorDeTestes.minimizarPropagandoInferior(janela);

        //Selecionar a data no primeiro Datapicker
        selecionarDataCalendario(janela, usuario);

        //Preencher o segundo Datapicker
        elemento = janela.findElement(By.xpath("//*[@id='datepicker2']"));
        elemento.sendKeys(usuario.getDataNascimento());

        //Deselecionar o segundo Datapicker
        elemento = janela.findElement(By.xpath("//*[@class='container']"));
        elemento.click();

        ExecutorDeTestes.esperar(2000);

        System.out.println("Teste de datapicker com sucesso!");

    }

    private void selecionarDataCalendario(WebDriver janela, UsuarioParaTeste usuario){

        WebElement elemento = janela.findElement(By.xpath("//*[@id='datepicker1']"));
        elemento.click();

        int diferencaMeses = LeitorDeArquivos.conversorDeMesParaInt(usuario.getMesNascimento()) - LeitorDeArquivos.conversorDeMesParaInt(this.mesAtual);

        if(diferencaMeses < 0){

            diferencaMeses = diferencaMeses + 12;

        }

        for(int i = 0;i < diferencaMeses;i++){

            elemento = janela.findElement(By.xpath("//*[@data-handler='next']/span"));
            elemento.click();

            ExecutorDeTestes.esperar(50);

        }

        elemento = janela.findElement(By.xpath("//*[@class='ui-state-default'][.='" + usuario.getDiaNascimento() + "']"));
        elemento.click();

    }

}
