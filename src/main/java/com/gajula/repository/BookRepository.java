package com.gajula.repository;

import com.gajula.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface BookRepository  extends JpaRepository<BookDto, BigInteger> {

    @Query(value = "SELECT b FROM BookDto b WHERE b.title = :title")
    public List<BookDto> getBooksByTitle(String title);

    @Query(value = "SELECT b FROM BookDto b WHERE b.genre = :genre")
    public List<BookDto> getBooksByGenre(String genre);
}
