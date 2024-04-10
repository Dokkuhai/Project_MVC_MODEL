/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import model.Book;
import model.BookReaderManagement;
import model.Reader;

/**
 * purpose: 
 *  Read data from file (Reader, Book, Book Management), in Book.dat, Reader.dat
 *  Write dsta to file (Reader, Book, Book Management), to Book.dat, Reader.dat 
 * @author Dokkuhai
 * date: 16/02/2024
 */
public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
    
    //-----------------------------------------------------------------------
    public void openFileToWrite(String filename) {
        try {
            fileWriter = new FileWriter(filename,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void writeBookToFile(Book book,String fileName){
        openFileToWrite(fileName);
        printWriter.println(book.getBookId() + "|" + book.getBookName() + "|" 
                + book.getAuthor() + "|" + book.getSpecialization() + "|" 
                + book.getPublishYear() + "|" + book.getQuantiity());
        
        closeFileAfterWrite(fileName);
    }
    
    public void writeReaderToFile(Reader reader,String fileName){
        openFileToWrite(fileName);
        printWriter.println(reader.getReaderID() + "|" + reader.getFullname() + "|" 
                + reader.getAddress() + "|" + reader.getPhoneNumber());
        closeFileAfterWrite(fileName);
    }
    
    public void writeBRMToFile(BookReaderManagement brm,String fileName){
        openFileToWrite(fileName);
        printWriter.println(brm.getReader().getReaderID() + "|" + brm.getBook().getBookId() + "|" 
                + brm.getNumOfBorrow() + "|" + brm.getState());
        
        closeFileAfterWrite(fileName);
        
    }
    
    
    public void closeFileAfterWrite(String fileName){
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //-------------------------------------------------------------------------
    
    
    public void openFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName),"UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
     
    }
    
    
    public void closeFileAfterRead(String fileName){
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------
    public ArrayList <Reader> readReadersFromFile(String fileName){
        openFileToRead(fileName);
        ArrayList<Reader> readers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Reader reader = createReaderFromData(fileName);
            readers.add(reader);
        }
        
        closeFileAfterRead(fileName);
        return readers;
    }
    //Data input structrue in Reader file  ReaderID | Fullname | Address | PhoneNumber
    public Reader createReaderFromData(String data){
        String []datas = data.split("\\|");
        Reader reader = new Reader(Integer.parseInt(datas[0]),datas[1],datas[2],datas[3]);
        return reader;
    }
    
    //------------------------------------------------------------------------
    
    public ArrayList<Book> readBookFromFile(String fileName){
        openFileToRead(fileName);
        ArrayList<Book> books = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Book book = createBookfromData(data);
            books.add(book);
        }
        closeFileAfterRead(fileName);
        return books;
        
    }
    
    //Data input structrue in Book file: bookId | bookName, String Author,  String specialization, int publishYear, int quantiity) {
    public Book createBookfromData(String data){
        String[] datas = data.split("//|");
        Book book = new Book(Integer.parseInt(datas[0]),datas[1],datas[2],datas[3],Integer.parseInt(datas[4]),Integer.parseInt(datas[5]));
        return book;
    }
    
    //------------------------------------------------------------------------
    
    public ArrayList<BookReaderManagement> readBRMFromFile(String fileName){
         openFileToRead(fileName);
         ArrayList<BookReaderManagement> brms = new ArrayList<>();
         while(scanner.hasNextLine()){
             String data = scanner.nextLine();
             BookReaderManagement brm = createBRMFromData(data);
             brms.add(brm);
         }
        closeFileAfterRead(fileName);
        return brms;
    }
    
    public BookReaderManagement createBRMFromData(String data){
        String[] datas = data.split("\\|");
        BookReaderManagement brm = new BookReaderManagement(new Book(Integer.parseInt(datas[0])),new Reader(Integer.parseInt(datas[1])),Integer.parseInt(datas[2]),datas[3],Integer.parseInt(datas[4]));
        return brm;
    }
        
}
    
