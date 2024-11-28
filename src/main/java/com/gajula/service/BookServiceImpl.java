package com.gajula.service;

import com.gajula.dto.BookDto;
import com.gajula.model.ResponseBean;
import com.gajula.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	private final static Logger admin = LogManager.getLogger(BookServiceImpl.class.getName());

	@Autowired
	BookRepository bookRepository;


	@Override
	public ResponseBean getAllBooks() throws Exception {
		ResponseBean response = new ResponseBean();
		List<BookDto> list = new ArrayList<BookDto>();
		try {
			admin.info("getAllBooks start ");
			list = bookRepository.findAll();
			response.setResult(list);
			admin.info("getAllBooks end");
		} catch (Exception e) {
			response.setStatusCode("00");
			response.setStatusDescription("FAILLURE");
			admin.info("error in getAllBooks=" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getBooksByTitle(String bookTitle) throws Exception {
		ResponseBean response = new ResponseBean();
		List<BookDto> list = new ArrayList<BookDto>();
		try {
			admin.info("getBooksByTitle start ");
			list = bookRepository.getBooksByTitle(bookTitle);
			response.setResult(list);
			admin.info("getBooksByTitle end");
		} catch (Exception e) {
			response.setStatusCode("00");
			response.setStatusDescription("FAILLURE");
			admin.info("error in getBooksByTitle=" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean getBooksByGenre(String genre) throws Exception {
		ResponseBean response = new ResponseBean();
		List<BookDto> list = new ArrayList<BookDto>();
		try {
			admin.info("getBooksByGenre start ");
			list = bookRepository.getBooksByGenre(genre);
			response.setResult(list);
			admin.info("getBooksByGenre end");
		} catch (Exception e) {
			response.setStatusCode("00");
			response.setStatusDescription("FAILLURE");
			admin.info("error in getBooksByGenre=" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean addNewBook(BookDto book) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("addNewBook start ");
			bookRepository.save(book);
			response.setResult(" New Book added successfullt!");
			admin.info("addNewBook end");
		} catch (Exception e) {
			response.setStatusCode("00");
			response.setStatusDescription("FAILLURE");
			admin.info("error in addNewBook=" + e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseBean updateExistingBook(BookDto book) throws Exception {
		ResponseBean response = new ResponseBean();
		try {
			admin.info("updateExistingBook start ");
			bookRepository.save(book);
			response.setResult(" Updated Existing Book successfullt!");
			admin.info("updateExistingBook end");
		} catch (Exception e) {
			response.setStatusCode("00");
			response.setStatusDescription("FAILLURE");
			admin.info("error in updateExistingBook=" + e.getMessage());
		}
		return response;
	}

}
