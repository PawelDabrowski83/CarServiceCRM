package pl.coderslab.commons;

import java.util.Set;

public interface GenericDao<T> {

    public void create(T entity);
    public T read(int id);
    public void update(T entity);
    public void delete(int id);
    public Set<T> findAll();
}
