package br.com.casa.estoque.Excecoes;

public class NaoConsta extends Throwable {
    @Override
    public String getMessage(){
        return "Este ID não consta no sistema";
    }
    
}
