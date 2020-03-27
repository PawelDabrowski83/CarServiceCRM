package pl.coderslab.commons;

import java.util.Set;

public interface ServiceInterface<T> {

    void create (T t);
    T read (int id);
    void update (T t);
    void delete (int id);
    Set<T> findAll();
}
