package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T var1);

    boolean delete(T var1);

    boolean update(T var1);

    T getById(int var1);

    List<T> getAll();
}
