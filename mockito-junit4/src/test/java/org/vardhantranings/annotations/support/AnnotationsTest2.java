package org.vardhantranings.annotations.support;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AnnotationsTest2 {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

//    @Before
//    public void beforeEach(){
//        MockitoAnnotations.initMocks(this);
//    }
    @Test
    public void demoCreateMocksUsingAnnotations() {
        //BookRepository bookRepository = mock(BookRepository.class);
        //BookService bookService = new BookService(bookRepository);
        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
