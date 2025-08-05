package sistemas.midias.midia;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {

    public static final String ARQUIVO_MIDIA = "Midia.dat";

    public HashMap<String, Midia> recuperarDados()throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_MIDIA))){
            return (HashMap<String, Midia>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }
    public void salvarDados (HashMap<String, Midia> midias)throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_MIDIA))){
            out.writeObject(midias);
        }catch (IOException e){
            throw new IOException("Erro ao salvar dados"+e.getMessage(), e);
        }
    }
}
