package sistemas.midias.sistema;

import sistemas.midias.exception.MidiaInexistenteException;
import sistemas.midias.exception.MidiaJaExisteException;
import sistemas.midias.midia.Midia;

import java.io.IOException;
import java.util.Collection;

public interface SistemaMidias {
    void cadastrarMidia(Midia midia)throws MidiaJaExisteException;
    Collection<Midia> pesquisarPorTitulo(String titulo);
    Collection<Midia> pesquisarPorGenero(String genero);
    Collection<Midia> pesquisarMidiaPorAno(int ano);
    Collection<Midia> pesquisarPorAtor(String ator);
    Collection<Midia> pesquisarPorDiretor(String diretor);
    Collection<Midia> mostrarTodosOsFilmes();
    Collection<Midia> mostrarTodasAsSeries();
    Collection<Midia> mostrarTodasAsMidias();
    void atualizarMidia(String titulo, String novoTitulo, String genero, int ano)throws MidiaInexistenteException;
    void removerMidia(String titulo)throws MidiaInexistenteException;
    void recuperarDados()throws IOException;
    void salvarDados()throws IOException;
}
