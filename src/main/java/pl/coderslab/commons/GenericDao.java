package pl.coderslab.commons;

import java.util.Set;

public interface GenericDao<T> {

    public abstract void create(T entity);
    public abstract T read(int id);
    public abstract void update(T entity);
    public abstract void delete(int id);
    public abstract Set<T> findAll();
}
