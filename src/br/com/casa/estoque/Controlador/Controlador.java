package br.com.casa.estoque.Controlador;

import br.com.casa.estoque.Dao.IDao;
import br.com.casa.estoque.Entidades.Perfume;
import br.com.casa.estoque.Entidades.Roupa;
import br.com.casa.estoque.fabrica.Factory;
import java.io.File;
import javax.swing.JOptionPane;

public class Controlador {

    private final IDao<Perfume> daoPerfume = Factory.getDao(Perfume.class);
    private final IDao<Roupa> daoRoupa = Factory.getDao(Roupa.class);
    
    
    public void registrarRoupa(String codeRoupa, int tamanho, int quantidade, String descricao, double preco, String tipo){
    
        Roupa roupa = new Roupa(codeRoupa,tamanho,quantidade,descricao,preco,tipo);

        String pasta = "\\Projeto\\Roupa";
        
        File file = new File(pasta, codeRoupa + ".data");
        
        if(!file.exists()){
            daoRoupa.insert(roupa);
        }else{
        
            JOptionPane.showMessageDialog(null, "Esta roupa já consta no sistema");
        }
    }

    public void removerRoupa(String id){
        Roupa roupaNova = daoRoupa.search(id + ".data");
        
        if(roupaNova.getQuantidade()>1){
        
            roupaNova.setQuantidade(roupaNova.getQuantidade()-1);
            daoRoupa.update(roupaNova);
        }else{
        daoRoupa.delete(id);
        }
    }
    public void atualizarRoupa(String codeRoupa, int tamanho,String descricao, double preco, String tipo){
        try {
        Roupa roupaNova = daoRoupa.search(codeRoupa + ".data");
        
        roupaNova.setCodeRoupa(codeRoupa);
        roupaNova.setDescricao(descricao);
        roupaNova.setTipo(tipo);
        roupaNova.setPreco(preco);
        roupaNova.setTamanho(tamanho);
        
        
        daoRoupa.update(roupaNova);
        JOptionPane.showMessageDialog(null, "Roupa atualizada");
        
        } catch (NullPointerException e) {
            
            JOptionPane.showMessageDialog(null, "Roupa não encontrada");
            
        }
        
    }
    
    public void reabastecerEstoqueRoupa(String id, int quantidade) {
        try {
        
            Roupa roupaNova = daoRoupa.search(id + ".data");

            roupaNova.setQuantidade(roupaNova.getQuantidade() + quantidade);

            daoRoupa.update(roupaNova);
            
        } catch (NullPointerException e) {
            
            JOptionPane.showMessageDialog(null, "Não encontrado");
            
        }
        
    
   }
    public void registrarPerfume(String nome, String descricao, String codePerfume, double preco, String tipo, int quantidade){
    
        Perfume perfume = new Perfume(nome,descricao,codePerfume,preco,tipo,quantidade);

        String pasta = "\\Projeto\\Perfume";
        
        File file = new File(pasta, codePerfume + ".data");
        
        if(!file.exists()){
            daoPerfume.insert(perfume);
        }else{
        
            JOptionPane.showMessageDialog(null, "Este Perfume já consta no sistema");
        }
    }


    public void removerPerfume(String id){
        try{
            Perfume perfumeX = daoPerfume.search(id + ".data");
        
              if(perfumeX.getQuantidade()>1){
        
                perfumeX.setQuantidade(perfumeX.getQuantidade()-1);
                daoPerfume.update(perfumeX);
        
                }else{
                    daoPerfume.delete(id);
                }
        }catch(NullPointerException e){
        
            JOptionPane.showMessageDialog(null, "Não Encontrado");
        
        }        
}


public void atualizarPerfume(String nome, String descricao, String codePerfume, double preco, String tipo){
    
        Perfume perfumeNovo = daoPerfume.search(codePerfume + ".data");
        
        
        perfumeNovo.setDescricao(descricao);
        perfumeNovo.setTipo(tipo);
        perfumeNovo.setPreco(preco);
        perfumeNovo.setNome(nome);
        
        
        daoPerfume.update(perfumeNovo);
    }


public void reabastecerEstoquePerfume(String id, int quantidade) {
    try{
        Perfume perfumeNovo = daoPerfume.search(id + ".data");

        perfumeNovo.setQuantidade(perfumeNovo.getQuantidade() + quantidade);

        daoPerfume.update(perfumeNovo);
        
    }catch(NullPointerException ex){
    
        JOptionPane.showMessageDialog(null, "Não encontrado");
    
    }
    
}

 public void adicionarPecaExistente(String code, int quantidade){
     try{
     Roupa quantNova = daoRoupa.search(code + ".data");
     
     quantNova.setQuantidade(quantNova.getQuantidade() + quantidade);
     daoRoupa.update(quantNova);
     }catch(NullPointerException ex){
     
         JOptionPane.showMessageDialog(null, "Não encontrado");
     
     }
 
 }
 
 public void adicionarPerfumeExistene(String code, int quantidade){
     try{
        Perfume quantNova = daoPerfume.search(code + ".data");
     
        quantNova.setQuantidade(quantNova.getQuantidade() + quantidade);
        daoPerfume.update(quantNova);
        
     }catch(NullPointerException ex){
     
        JOptionPane.showMessageDialog(null, "Não encontrado");
     
    }
 }
 
 
}