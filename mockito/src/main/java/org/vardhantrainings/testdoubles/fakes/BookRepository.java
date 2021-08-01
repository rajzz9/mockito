package org.vardhantrainings.testdoubles.fakes;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);
    Collection<Book> findAll();
}
