import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeitorDeArquivos {

    public static ArrayList<String> lerValoresLinha(String caminhoArquivo, int numeroLinha){

        ArrayList<String> valoresLinha = new ArrayList<>();

        try{

            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);

            for (int nL = 0; nL <= numeroLinha; nL++) {

                String linha = bufferedReader.readLine();

                if(nL == numeroLinha){

                    //System.out.println("* Valores da Linha *");

                    String[] valores = linha.split(";");

                    for (int i = 0; i < valores.length; i++){

                        String valor = valores[i];
                        //System.out.println(i + "---" + valor);
                        valoresLinha.add(valor);

                    }

                    break;

                }

            }

        }catch(Exception erro){
            System.out.println("Erro na leitura do arquivo '" + caminhoArquivo + "'!");
        }

        return valoresLinha;

    }

    public static int conversorDeMesParaInt(String mes){

        int numeroMes = 0;

        ArrayList<String> valoresMeses = LeitorDeArquivos.lerValoresLinha("recursos/meses.txt",1);

        for(int i = 1;i < valoresMeses.size();i++){

            if(mes.equals(valoresMeses.get(i))){

                numeroMes = i;

            }

        }

        if(numeroMes == 0){

            System.out.println("Erro na conversao de mes!");

        }

        return numeroMes;

    }

}
