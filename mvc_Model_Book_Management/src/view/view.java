/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import model.Book;
import controller.DataController;
import java.util.ArrayList;

/**
 *
 * @author Dokkuhai
 */
public class view {
    
    public static void main(String[] args) {
        String booksFileName = "BOOK.DAT";
        DataController controller = new DataController();
        ArrayList<Book> books = new ArrayList<Book>();
        
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("_______________Book Management_____________");
            System.out.println("1.Add a book to the file");
            System.out.println("2.View all the book that have in file");
            System.out.println("0.Exit");
            System.out.println("Your selection?: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Exiting the program.....");
                    break;
                    
                case 1:
                    
                    String bookName,author,spec;
                    int year,quantity;
                    System.out.println("Input the name of book: ");
                    bookName = sc.nextLine();
                    System.out.println("Input the author name of book: ");
                    author = sc.nextLine();
                    System.out.println("Input the specialization: ");
                    spec = sc.nextLine();
                    System.out.println("Input the year of publish: ");
                    year = sc.nextInt();
                    System.out.println("Input quantity: ");
                    quantity = sc.nextInt();
                    Book book = new Book(0,bookName,author,spec,year,quantity);
                    controller.writeBookToFile(book, booksFileName);                  
                    break;
                    
                default:
                    throw new AssertionError();
            }
        }while(choice != 0);
    }
}
