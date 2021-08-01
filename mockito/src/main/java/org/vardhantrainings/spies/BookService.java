package org.vardhantrainings.spies;

public class BookService {

    public Book findBook(String bookId) {
        // code to bring book from database
        throw new RuntimeException("Method not implemented");
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (price * discountRate / 100);
        return newPrice;
    }
}
