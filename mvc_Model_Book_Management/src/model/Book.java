/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * purpose:
 * @author Dokkuhai 
 * date: 16/02/2024
 */
public class Book {

    private static int id = 10000000;
    private int bookId;
    private String bookName;
    private String Author;
    private String specialization;
    private int publishYear;
    private int quantiity;

    public Book(int bookId, String bookName, String Author, 
            String specialization, int publishYear, int quantiity) {
        if(bookId == 0){
            this.bookId = id++;
        }else
            this.bookId = bookId;
        
        this.bookName = bookName;
        this.Author = Author;
        this.specialization = specialization;
        this.publishYear = publishYear;
        this.quantiity = quantiity;
    }

    public Book(){
        
    }

    public Book(int bookId) {
        this.bookId = bookId;
    }
    
    
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantiity() {
        return quantiity;
    }

    public void setQuantiity(int quantiity) {
        this.quantiity = quantiity;
    }

}
