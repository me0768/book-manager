package com.example.bookmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private Map<Long, Book> bookMap = new HashMap<>(); // key를 id로 갖고 value를 Book객체로 갖는 map
    private long lastId;

    // bookMap 에 있는 모든 책들을 리턴
    public List<Book> getBooks() {
        return new ArrayList<>(bookMap.values());
    }

    public Book getBook(Long id) {
        return bookMap.get(id);
    }

    public void addBook(Book book) {
        lastId = ++lastId;
        book.setId(lastId);
        bookMap.put(lastId, book);
    }

    public void deleteBook(Long id) {
        bookMap.remove(id);
    }

    public void updateBook(Long id, Book book) {
        book.setId(id);
        bookMap.replace(id, book);
    }

}
