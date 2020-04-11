package pl.coderslab.customer;

import java.util.Set;

public interface CustomerDaoInterface<T> {

    Set<T> findUnmatched();
}
