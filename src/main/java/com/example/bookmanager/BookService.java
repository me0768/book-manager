package com.example.bookmanager;

import java.util.List;

import org.springframework.stereotype.Service;

@Service // 서비스에서는 비즈니스 로직 담당. repository 호출해서 결과를 가져오거나 write하거나 등등 + 중복체크 + 기타 요구사항
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book getBook(Long id) {
        return bookRepository.getBook(id);
    }

    public void addBook(Book book) {
        // 중복검사
        bookRepository.addBook(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    public void updateBook(Long id, Book book) {
        bookRepository.updateBook(id, book);
    }
}
