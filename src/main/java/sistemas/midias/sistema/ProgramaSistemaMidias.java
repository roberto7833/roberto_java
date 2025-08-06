package sistemas.midias.sistema;

import sistemas.midias.exception.MidiaInexistenteException;
import sistemas.midias.exception.MidiaJaExisteException;
import sistemas.midias.midia.Filme;
import sistemas.midias.midia.GravadorDeDados;
import sistemas.midias.midia.Midia;
import sistemas.midias.midia.Serie;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class ProgramaSistemaMidias implements SistemaMidias{
    private HashMap<String, Midia> midias;
    private GravadorDeDados gravador;

    public ProgramaSistemaMidias(){
        this.midias = new HashMap<>();
        this.gravador = new GravadorDeDados();

        try {
            this.midias = gravador.recuperarDados();
        }catch (IOException e){
            this.midias = new HashMap<>();
        }
    }
    public void cadastrarMidia(Midia midia)throws MidiaJaExisteException{
        if(this.midias.containsKey(midia.getTitulo())){
            throw new MidiaJaExisteException("Já existe uma midia cadastrada com esse nome "+midia.getTitulo());
        }
        this.midias.put(midia.getTitulo(), midia);
    }
    public Collection<Midia> pesquisarPorTitulo(String titulo){
        Collection<Midia> tituloPesq = new ArrayList<>();
        for(Midia m: this.midias.values()){
            if(m.getTitulo().equalsIgnoreCase(titulo)){
                tituloPesq.add(m);
            }
        }
        return tituloPesq;
    }
    public Collection<Midia> pesquisarPorGenero(String genero){
        Collection<Midia> generoPesq = new ArrayList<>();
        for(Midia m: this.midias.values()){
            if(m.getGenero().equalsIgnoreCase(genero)){
                generoPesq.add(m);
            }
        }
        return generoPesq;
    }
    public Collection<Midia> pesquisarMidiaPorAno(int ano){
        Collection<Midia> anoPesq = new ArrayList<>();
        for(Midia m: this.midias.values()){
            if(m.getAnoLancamento()==ano){
                anoPesq.add(m);
            }
        }
        return anoPesq;
    }
    public Collection<Midia> pesquisarPorAtor(String ator){
        Collection<Midia> atorPesq = new ArrayList<>();
        for(Midia m: this.midias.values()){
            String [] elenco = m.getElenco();
            for(String nome: elenco){
                if(nome.equalsIgnoreCase(ator)){
                    atorPesq.add(m);
                }
            }
        }
        return atorPesq;
    }
    public Collection<Midia> pesquisarPorDiretor(String diretor){
        Collection<Midia> diretorPesq = new ArrayList<>();
        for(Midia m: this.midias.values()){
            if(m.getDiretor().equalsIgnoreCase(diretor)){
                diretorPesq.add(m);
            }
        }
        return diretorPesq;
    }
    public Collection<Midia> mostrarTodosOsFilmes(){
        Collection<Midia> totalFilmes = new ArrayList<>();
        for(Midia m: this.midias.values()){
            if(m instanceof Filme){
                totalFilmes.add(m);
            }
        }
        return totalFilmes;
    }
    public Collection<Midia> mostrarTodasAsSeries(){
        Collection<Midia> totalSeries = new ArrayList<>();
        for(Midia m: this.midias.values()){
            if(m instanceof Serie){
                totalSeries.add(m);
            }
        }
        return totalSeries;
    }
    public Collection<Midia> mostrarTodasAsMidias(){
        return this.midias.values();
    }
    public void atualizarMidia(String titulo, String novoTitulo, String genero, int ano)throws MidiaInexistenteException{
        if(this.midias.containsKey(titulo)){
            Midia midia = midias.get(titulo);
            midia.setTitulo(novoTitulo);
            midia.setGenero(genero);
            midia.setAnoLancamento(ano);
            midias.remove(titulo);
            midias.put(titulo, midia);
        }else {
            throw new MidiaInexistenteException("nenhuma midia encontrada com o titulo "+titulo);
        }
    }
    public void removerMidia(String titulo)throws MidiaInexistenteException{
        if(!this.midias.containsKey(titulo)){
            throw new MidiaInexistenteException("nenhuma midia encontrada com o titulo "+titulo);
        }else {
            this.midias.remove(titulo);
        }
    }
    public void recuperarDados()throws IOException{
        this.midias = gravador.recuperarDados();
    }
    public void salvarDados()throws IOException{
        this.gravador.salvarDados(midias);
    }
}
