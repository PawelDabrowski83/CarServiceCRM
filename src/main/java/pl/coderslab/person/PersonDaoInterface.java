package pl.coderslab.person;

import pl.coderslab.commons.GenericDao;

import java.util.Set;

public interface PersonDaoInterface<T> extends GenericDao<T> {

    Set<T> findUnmatchedCustomers();
    Set<T> findUnmatchedEmployees();

}
