package oc.projet10.Controller;

import oc.projet10.Entity.Book;
import oc.projet10.Entity.WaitingLine;
import oc.projet10.Service.BookService;
import oc.projet10.Service.WaitingLineService;
import oc.projet10.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class WaitingLineController {

    @Autowired
    WaitingLineService waitingLineService   ;

    @Autowired
    BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookingController.class);

    @PostMapping("/saveInWaitingLine")
    public ResponseEntity<WaitingLineDto> save(@RequestBody WaitingLine waitingLine) {
        WaitingLineDto waitingLineDto = new WaitingLineDto(waitingLineService.save(waitingLine));
        return new ResponseEntity<>(waitingLineDto, HttpStatus.CREATED);

    }

    @PostMapping("/waitingLinePosition")
    public WaitingLinePosition getPositionInWaitingLine(@RequestBody WaitingLineRequest waitingLineRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<WaitingLine> waitingListbyBook =  waitingLineService.getWaitingListbyBook(bookService.findBookById(waitingLineRequest.getBookId()));
        int position = waitingListbyBook.size();
        System.out.println("id " + waitingLineRequest.getBookId());
        System.out.println(new WaitingLinePosition(bookService.findBookById(waitingLineRequest.getBookId()),position,waitingListbyBook.get(0).getRegisteredDate().format(formatter)));
        return new WaitingLinePosition(bookService.findBookById(waitingLineRequest.getBookId()),position, waitingListbyBook.get(0).getRegisteredDate().format(formatter));
    }
}