package org.vardhantrainings.argumentcaptor;

public interface BookRepository {
    void save(Book book);
    Book findBookById(String bookId);
}
