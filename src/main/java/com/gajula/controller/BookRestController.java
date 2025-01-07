package com.gajula.controller;

import com.gajula.dto.BookDto;
import com.gajula.exception.CustomException;
import com.gajula.model.ResponseBean;
import com.gajula.model.ValidateForm;
import com.gajula.service.BookService;
import com.gajula.util.APIConstants;
import com.gajula.validator.BookValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/book/")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookRestController {

	private final static Logger admin = LogManager.getLogger(BookRestController.class.getName());

	@Autowired
	BookService bookService;

	@Autowired
	BookValidator bookValidator;

	@GetMapping(value = { "/service/getAllBooks", "/ui/getAllBooks" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getAllBooks() throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getAllBooks START===");
			response = bookService.getAllBooks();
			admin.info("===getAllBooks END===");
		} catch (Exception e) {
			throw new CustomException("error occured in getAllBooks service" + e.getMessage());
		}
		return response;
	}

	@GetMapping(value = { "/service/getBookByTitle/{title}", "/ui/getBookByTitle/{title}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getBookByTitle(@PathVariable("title") String title) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getBookByTitle START===");
			response = bookService.getBooksByTitle(title);
			admin.info("===getBookByTitle END===");
		} catch (Exception e) {
			throw new CustomException("error occured in getBookByTitle service" + e.getMessage());
		}
		return response;
	}

	@GetMapping(value = { "/service/getBookByGenre/{genre}", "/ui/getBookByGenre/{genre}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getBookByGenre(@PathVariable("genre") String genre) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===getBookByGenre START===");
			response = bookService.getBooksByGenre(genre);
			admin.info("===getBookByTitle END===");
		} catch (Exception e) {
			throw new CustomException("error occured in getBookByGenre service" + e.getMessage());
		}
		return response;
	}

	@PostMapping(value = { "/service/saveBook/{actionType}", "/ui/saveBook/{actionType}"}, produces = "application/json", consumes = "application/json")
	public ResponseBean saveBook(@PathVariable("actionType") String actionType,
								 @RequestBody(required = true) String reqStr) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("===saveBook START===");
			admin.info("Request JSOn="+reqStr);
			BookDto book = APIConstants.getObjectMapper().readValue(reqStr, BookDto.class);
			ValidateForm validateForm = bookValidator.validateForm(book);
			admin.info("Form has errors ======"+validateForm.isHasErrors());
			if(actionType.equalsIgnoreCase("save")){
				admin.info("========= NEW BOOK =====================");
				if(validateForm.isHasErrors()) {
					response.setStatusCode(APIConstants.DATA_ERR_CODE);
					response.setStatusDescription(APIConstants.DATA_ERR_DESC);
					response.setResult(validateForm);
				}else {
					response = bookService.addNewBook(book);
				}
			}else if(actionType.equalsIgnoreCase("update")){
				admin.info("========= EDIT BOOK =====================");
				if(validateForm.isHasErrors()){
					response.setStatusCode(APIConstants.DATA_ERR_CODE);
					response.setStatusDescription(APIConstants.DATA_ERR_DESC);
					response.setResult(validateForm);
				}else {
					response = bookService.updateExistingBook(book);
				}
			}
			admin.info("===saveBook END===");
		} catch (Exception e) {
			throw new CustomException("error occured in saveBook service" + e.getMessage());
		}
		return response;
	}




}
