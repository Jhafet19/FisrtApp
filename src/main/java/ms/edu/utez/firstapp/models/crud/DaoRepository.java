package ms.edu.utez.firstapp.models.crud;

import java.util.List;

public interface DaoRepository <T>{
    List<T> findAll();
    T findOne(Long id);
    boolean save(T object);
    boolean update(T object);
    boolean delate(Long id);
}
