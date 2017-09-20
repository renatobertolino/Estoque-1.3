
package br.com.casa.estoque.fabrica;

import br.com.casa.estoque.Dao.Dao;
import br.com.casa.estoque.Dao.IDao;
import br.com.casa.estoque.Entidades.Entidade;


public class Factory {

    public static<T extends Entidade> IDao<T> getDao(Class<T> classeAtual){
        return new Dao<>(classeAtual);
    }
}
