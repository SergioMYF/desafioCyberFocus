import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TesteFormulario {

    //@Test
    public void executarPrimeiroTeste(WebDriver janela, UsuarioParaTeste usuario){

        WebElement elemento;

        ExecutorDeTestes.esperar(2000);

        ExecutorDeTestes.minimizarPropagandoInferior(janela);

        //Inserir o nome
        elemento = janela.findElement(By.xpath("//*[@ng-model='FirstName']"));
        elemento.sendKeys(usuario.getNome());

        //Inserir o sobrenome
        elemento = janela.findElement(By.xpath("//*[@ng-model='LastName']"));
        elemento.sendKeys(usuario.getSobrenome());

        //Inserir o endereco
        elemento = janela.findElement(By.xpath("//*[@ng-model='Adress']"));
        elemento.sendKeys(usuario.getEndereco());

        //Inserir o email
        elemento = janela.findElement(By.xpath("//*[@ng-model='EmailAdress']"));
        elemento.sendKeys(usuario.getEmail());

        //Inserir o telefone
        elemento = janela.findElement(By.xpath("//*[@ng-model='Phone']"));
        elemento.sendKeys(usuario.getTelefone());

        //Selecionar o genero
        String temp = "//*[@type='radio'][@value='" + usuario.getGenero() + "']";
        elemento = janela.findElement(By.xpath(temp));
        elemento.click();

        //Selecionar o hobbie
        temp = "//*[@id='checkbox" + usuario.getHobbie() + "']";
        elemento = janela.findElement(By.xpath(temp));
        elemento.click();

        //Selecionar os idiomas
        selecionarDiversosIdiomas(janela, usuario);

        //Selecionar a skill
        elemento = janela.findElement(By.xpath("//*[@id='Skills']"));
        elemento.click();
        temp = "//*[@value='" + usuario.getHabilidade() + "']";
        elemento = elemento.findElement(By.xpath(temp));
        elemento.click();

       //Selecionar o pais
        elemento = janela.findElement(By.xpath("//*[@class='select2-selection__arrow']"));
        elemento.click();
        temp = "//*[@class='select2-results__option'][.='" + usuario.getPais() + "']";
        elemento = janela.findElement(By.xpath(temp));
        elemento.click();
        
        //Selecionar o ano de nascimento
        elemento = janela.findElement(By.xpath("//*[@id='yearbox']"));
        elemento.click();
        temp = "//*[@value='" + usuario.getAnoNascimento() + "']";
        elemento = janela.findElement(By.xpath(temp));
        elemento.click();

        //Selecionar o mes de nascimento
        elemento = janela.findElement(By.xpath("//*[@ng-model='monthbox']"));
        elemento.click();
        temp = "//*[@value='" + usuario.getMesNascimento() + "']";
        elemento = janela.findElement(By.xpath(temp));
        elemento.click();

        //Selecionar o dia de nascimento
        elemento = janela.findElement(By.xpath("//*[@id='daybox']"));
        elemento.click();
        temp = "//*[@value='" + usuario.getDiaNascimento() + "']";
        elemento = janela.findElement(By.xpath(temp));
        elemento.click();
        
        //Inserir senha
        elemento = janela.findElement(By.xpath("//*[@id='firstpassword']"));
        elemento.sendKeys(usuario.getSenha());

        //Confirmar senha
        elemento = janela.findElement(By.xpath("//*[@id='secondpassword']"));
        elemento.sendKeys(usuario.getSenha());

        //Finalizar o formulario
        elemento = janela.findElement(By.xpath("//*[@id='submitbtn']"));
        elemento.click();

        ExecutorDeTestes.esperar(2000);

        System.out.println("Teste de formulario com sucesso!");

    }

    private void selecionarDiversosIdiomas(WebDriver janela, UsuarioParaTeste usuario){

        WebElement elemento = janela.findElement(By.id("msdd"));
        elemento.click();

        ArrayList<String> idiomas = usuario.getIdiomas();

        for (int i = 0;i < idiomas.size();i++){

            String x = idiomas.get(i);
            elemento = janela.findElement(By.xpath("//*[.='"+ x + "']"));
            elemento.click();

        }

        //Fechar o dropdown de idiomas
        elemento = janela.findElement(By.xpath("//*[@class='container']"));
        elemento.click();

    }

}
