package pl.coderslab.person;

import pl.coderslab.commons.ServiceInterface;

import java.util.Set;

public interface PersonServiceInterface<T> extends ServiceInterface<T> {

    Set<T> findUnmatchedCustomers();
}
