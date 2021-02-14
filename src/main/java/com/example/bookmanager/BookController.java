package com.example.bookmanager;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// TODO: 2021-02-14 중복체크, dto쓰기
@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookService bookService;

    // DI : 생성자 주입. @Autowired랑 똑같은 역할!
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 책 리스트 가져오기
    @GetMapping(value = {"", "/"})
    // @RequestMapping(method = RequestMethod.GET, path = {"", "/"})도 똑같다
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

//    @GetMapping("/{id}")
//    public Book getBook(@PathVariable Long id) {
//        return bookService.getBook(id);
//    }

    // 책 추가하기
    @PostMapping
    public void add(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping
    public void delete(Long id) {
        bookService.deleteBook(id);
    }

}
