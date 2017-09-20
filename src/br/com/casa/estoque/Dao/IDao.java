
package br.com.casa.estoque.Dao;

import br.com.casa.estoque.Entidades.Entidade;


public interface IDao<T extends Entidade> {
    
    
    void insert(T entidade);
    void delete(String id);
    void update(T entidade);
    T search(String id);
    
}
