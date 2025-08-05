package sistemas.midias.midia;

public class Filme extends Midia{
    private int duracao;

    public Filme(String titulo, String genero, int anoLancamento, String descricao, String [] elenco, String diretor, int duracao){
        super(titulo, genero, anoLancamento, descricao, elenco, diretor);
        this.duracao = duracao;
    }
    public int getDuracao() {
        return this.duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    @Override
    public String toString(){
        return "Filme "+super.getTitulo()+"\nGenero "+super.getGenero()+
                "\nAno de lançamento "+super.getAnoLancamento()+"\nDescricao "+super.getDescricao()+
                "\nElenco "+String.join(",",super.getElenco())+
                "\nDiretor "+super.getDiretor()+"\nDuração "+this.duracao;
    }
}
