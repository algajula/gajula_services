package com.gajula.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "AUTHOR", schema = "book_services")
public class AuthorDto {

    @Id
    @GeneratedValue(generator = "authorid_seq_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "authorid_seq_id", sequenceName = "authorid_seq", allocationSize = 1, schema = "book_services")
    @Column(name = "AUTHOR_ID")
    private BigInteger author_id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DATE_OF_BIRTH", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name = "NATIONALITY")
    private String nationality;

    public BigInteger getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(BigInteger author_id) {
        this.author_id = author_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "author_id=" + author_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
