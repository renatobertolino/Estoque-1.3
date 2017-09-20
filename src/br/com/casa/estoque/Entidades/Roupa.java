package br.com.casa.estoque.Entidades;

import java.io.Serializable;

public class Roupa extends Entidade implements Serializable {

    private static final long serialVersionUID= 1L;
    
    String codeRoupa;
    int tamanho;
    int quantidade;
    String descricao;
    double preco;
    String tipo;

    public Roupa() {
    
    
    }

    public Roupa(String codeRoupa, int tamanho, int quantidade, String descricao, double preco, String tipo) {
        this.codeRoupa = codeRoupa;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getCodeRoupa() {
        return codeRoupa;
    }

    public void setCodeRoupa(String codeRoupa) {
        this.codeRoupa = codeRoupa;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     
    
    
    @Override
    public String getId() {
        return codeRoupa;
    }

    
}
