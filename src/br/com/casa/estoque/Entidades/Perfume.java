package br.com.casa.estoque.Entidades;

import java.io.Serializable;

public class Perfume extends Entidade implements Serializable{

    private static final long serialVersionUID=1L;
    
    String nome;
    String descricao;
    String codePerfume;
    double preco;
    String tipo;
    int quantidade;
    
    public Perfume(){
    
    }

    public Perfume(String nome, String descricao, String codePerfume, double preco, String tipo, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.codePerfume = codePerfume;
        this.preco = preco;
        this.tipo = tipo;
        this.quantidade= quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodePerfume() {
        return codePerfume;
    }

    public void setCodePerfume(String codePerfume) {
        this.codePerfume = codePerfume;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    
    
    @Override
    public String getId() {
        
           return codePerfume;
    }

    
    
    
    
    
    
}
