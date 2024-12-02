package repositories;

import java.util.ArrayList;
import java.util.List;

// Interface genérica para repositórios
public interface Repository<T> {
    void save(T entity);
    List<T> findAll();
}