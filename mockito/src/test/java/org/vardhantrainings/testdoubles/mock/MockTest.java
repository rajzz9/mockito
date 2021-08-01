package org.vardhantrainings.testdoubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MockTest {
    @Test
    public void demoMock(){
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2, 1);

    }
    @Test
    public void demoMockWithMockito(){
        BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        verify(bookRepositoryMock, Mockito.times(1)).save(book2);
        verify(bookRepositoryMock, Mockito.times(0)).save(book1);

    }
    @Test
    public void demoSpyWithMockito(){
        BookRepository bookRepositorySpy = spy(BookRepository.class);
        BookService  bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        verify(bookRepositorySpy, Mockito.times(1)).save(book2);
        verify(bookRepositorySpy, Mockito.times(0)).save(book1);

    }
}
