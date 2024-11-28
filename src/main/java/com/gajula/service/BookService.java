package com.gajula.service;

import com.gajula.dto.BookDto;
import com.gajula.model.ResponseBean;

public interface BookService {

	public ResponseBean getAllBooks() throws Exception;
	public ResponseBean getBooksByTitle(String bookTitle) throws Exception;
	public ResponseBean getBooksByGenre (String genre) throws Exception;

	public ResponseBean addNewBook(BookDto book)throws Exception;
	public ResponseBean updateExistingBook(BookDto book) throws Exception;
}
