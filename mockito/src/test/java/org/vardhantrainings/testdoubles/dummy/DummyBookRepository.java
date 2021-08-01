package org.vardhantrainings.testdoubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DummyBookRepository implements BookRepository {
    // In memory database, HashMap or List
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(org.vardhantrainings.testdoubles.dummy.Book book) {
        bookStore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
