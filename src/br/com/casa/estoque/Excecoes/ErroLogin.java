package br.com.casa.estoque.Excecoes;

public class ErroLogin extends Throwable {
    
    @Override
    public String toString(){
        return "Login Errado";
    }
}
