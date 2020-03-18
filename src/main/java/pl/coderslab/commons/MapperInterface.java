package pl.coderslab.commons;

public interface MapperInterface<D,S,E> {

    D mapServiceToDto (S s);
    S mapDtoToService (D d);
    E mapServiceToEntity (S s);
    S mapEntityToService (E e);

}
