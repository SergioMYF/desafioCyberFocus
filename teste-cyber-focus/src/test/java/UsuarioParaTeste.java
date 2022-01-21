import java.util.ArrayList;

public class UsuarioParaTeste {

    private String nome = "0";
    private String sobrenome = "0";
    private String endereco = "0";
    private String email = "0";
    private String telefone = "0";
    private String genero = "0";
    private String hobbie = "0";
    private ArrayList<String> idiomas = new ArrayList<>();
    private String habilidade = "0";
    private String pais = "0";
    private String anoNascimento = "0";
    private String mesNascimento = "0";
    private String diaNascimento = "0";
    private String dataNascimento = "0";
    private String senha = "0";
    private String comentario = "0";

    public UsuarioParaTeste(String caminhoArquivo, int numeroLinha){

        ArrayList<String> valoresLinha = LeitorDeArquivos.lerValoresLinha(caminhoArquivo, numeroLinha);

        this.nome = valoresLinha.get(0);
        this.sobrenome = valoresLinha.get(1);
        this.endereco = valoresLinha.get(2);
        this.email = valoresLinha.get(3);
        this.telefone = valoresLinha.get(4);
        this.genero = valoresLinha.get(5);
        this.hobbie = valoresLinha.get(6);
        preencherIdiomas(valoresLinha.get(7));
        this.habilidade = valoresLinha.get(8);
        this.pais = valoresLinha.get(9);
        this.anoNascimento = valoresLinha.get(10);
        this.mesNascimento = valoresLinha.get(11);
        this.diaNascimento = valoresLinha.get(12);
        this.dataNascimento = LeitorDeArquivos.conversorDeMesParaInt(this.mesNascimento) + "/" + this.diaNascimento + "/" + this.anoNascimento;
        this.senha = valoresLinha.get(13);
        this.comentario = valoresLinha.get(14);

    }

    private void preencherIdiomas(String valorIdiomas){

        String[] idiomas = valorIdiomas.split(",");

        for (int i = 0;i < idiomas.length;i++){

            this.idiomas.add(idiomas[i]);

        }

    }

    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getGenero() {
        return genero;
    }
    public String getHobbie() {
        return hobbie;
    }
    public ArrayList<String> getIdiomas() {
        return idiomas;
    }
    public String getHabilidade() {
        return habilidade;
    }
    public String getPais() {
        return pais;
    }
    public String getAnoNascimento() {
        return anoNascimento;
    }
    public String getMesNascimento() {
        return mesNascimento;
    }
    public String getDiaNascimento() {
        return diaNascimento;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public String getSenha() {
        return senha;
    }
    public String getComentario() {
        return comentario;
    }

}
