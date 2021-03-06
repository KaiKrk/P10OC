package oc.projet10.Controller;
import oc.projet10.Entity.Book;
import oc.projet10.Entity.Member;
import oc.projet10.Service.BookService;
import oc.projet10.bean.BookDto;
import oc.projet10.bean.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<List<BookDto>> books(@RequestBody MemberDto member){

        List<BookDto> booksList = bookService.findBooksNotReservated(member.getMemberId());
        if (booksList.isEmpty()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(booksList, HttpStatus.OK);
        }


    @PostMapping("/saveBook")
    public ResponseEntity<BookDto> save(@RequestBody Book book) {
        book.setMax_copies(book.getCopies());
        logger.info("New Book added : " + book.getName());
        BookDto newBook = new BookDto(bookService.save(book));
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);

    }


}
