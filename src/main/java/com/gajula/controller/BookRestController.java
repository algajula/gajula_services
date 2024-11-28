package com.gajula.controller;

import com.gajula.dto.BookDto;
import com.gajula.exception.BookCustomeException;
import com.gajula.model.ResponseBean;
import com.gajula.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/book/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookRestController {

	private final static Logger admin = LogManager.getLogger(BookRestController.class.getName());

	@Autowired
	BookService bookService;

	@GetMapping(value = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAllBooks() throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getAllBooks START===");
			response = bookService.getAllBooks();
			admin.info("===getAllBooks END===");
		} catch (Exception e) {
			throw new BookCustomeException("error occured in getAllBooks service" + e.getMessage());
		}
		return response;
	}

	@GetMapping(value = "/getBookByTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getBookByTitle(@PathVariable("title") String title) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getBookByTitle START===");
			response = bookService.getBooksByTitle(title);
			admin.info("===getBookByTitle END===");
		} catch (Exception e) {
			throw new BookCustomeException("error occured in getBookByTitle service" + e.getMessage());
		}
		return response;
	}

	@GetMapping(value = "/getBookByGenre/{genre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getBookByGenre(@PathVariable("genre") String genre) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getBookByGenre START===");
			response = bookService.getBooksByGenre(genre);
			admin.info("===getBookByTitle END===");
		} catch (Exception e) {
			throw new BookCustomeException("error occured in getBookByGenre service" + e.getMessage());
		}
		return response;
	}

	@PostMapping(value = "/saveBook/{actionType}", produces = "application/json", consumes = "application/json")
	public ResponseBean saveBook(@PathVariable("actionType") String actionType,
								 @RequestBody(required = true) BookDto book) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===saveBook START===");
			if(actionType.equalsIgnoreCase("new")){
				response = bookService.addNewBook(book);
			}else if(actionType.equalsIgnoreCase("update")){
				response = bookService.updateExistingBook(book);
			}
			admin.info("===saveBook END===");
		} catch (Exception e) {
			throw new BookCustomeException("error occured in saveBook service" + e.getMessage());
		}
		return response;
	}




}
