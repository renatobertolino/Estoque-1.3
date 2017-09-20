package br.com.casa.estoque.Dao;

import br.com.casa.estoque.Entidades.Entidade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class Dao<T extends Entidade> implements IDao<T> {

    private Class classeAtual;
    
    
    public Dao(Class<T> classeAtual){
    this.classeAtual=classeAtual;
    }
    
    
    @Override
    public void insert(T entidade) {
        salvar(entidade);
    }

    @Override
    public void delete(String id) {
        
        File pasta = getPasta();
        File file = new File(pasta, id+".data");
        
        if(!file.exists()){
        
            //lançar exceção
        }else{
        
        file.delete();
        
        }
        
    }

    @Override
    public void update(T entidade) {
        salvar(entidade);
    }

    @Override
    public T search(String id) {
        
        T entidade = null;
        File pasta = getPasta();
        
        File file = new File(pasta, id);
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            
            entidade = (T) ois.readObject();
            
        } catch (Exception e) {
            
        
        }finally{
        if(ois!=null){
        
            try {
                ois.close();
            } catch (IOException e) {

            //exceção
            }
            
        }
        
        }
        return entidade;
    }

    private void salvar(T entidade) {
        
        File pasta = getPasta();
        File file = new File(pasta, entidade.getId() + ".data");
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            
            fos=new FileOutputStream(file);
            oos =new ObjectOutputStream(fos);
            
            oos.writeObject(entidade);
            
        } catch (Exception ex) {
            //TODO
        }finally{
        
            if(oos!=null){
            
                try{
                
                    oos.close();
               
                }catch(Exception e){
               
                    //TODO
                
                }
            }
            
            
        }
    
   
        
        
    }

    private File getPasta() {
        String getNomeClasse = "\\Projeto\\" + classeAtual.getSimpleName();
        
        File file = new File(getNomeClasse);
        
        file.mkdirs();
        
        return file;
    }
    
}
