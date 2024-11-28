package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "BOOK", schema = "book_services")
public class BookDto implements Serializable {

    @Id
    @GeneratedValue(generator = "bookid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bookid_seq_id", sequenceName = "bookid_seq", allocationSize = 1, schema = "book_services")
    @Column(name = "BOOK_ID")
    private BigInteger book_id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "GENRE")
    private String genre;

    @Column(name = "PUBLICATION_DATE", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @CreatedDate
    private Date publicationDate;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "AUTHOR_ID")
    private String author_id;

    @JsonIgnoreProperties(value = {"author"})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id", insertable = false, updatable = false)
    AuthorDto author;

    public BigInteger getBook_id() {
        return book_id;
    }

    public void setBook_id(BigInteger book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", author_id='" + author_id + '\'' +
                ", author=" + author +
                '}';
    }
}
