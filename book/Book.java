/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;


//import java.util.*; //this will include all classes from java.util package

//the Book class

public class Book  {
    
    //data attribute
    protected String title; // the book title
    protected int year; //the year of the book published
    protected double price; //the price of the book
    protected String author;//The author of the book
    
    //default constuctor
    public Book()
    {
        this.title = " ";
        this.year = 0;
        this.price = 0.0;
        this.author = " ";
    }
    
    //normal constructor
    public Book (String title,int year, double price, String author )
    {
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }
    
    //Accessor: Returns the title of this Book
    public String getTitle() {
        return title;
    }

    //Accessor: Returns the year of this Book
    public int getYear() {
        return year;
    }

    //Accessor: Returns the price of this Book
    public double getPrice() {
        return price;
    }
    
    //Accessor: Returns the author of this Book
    public String getAuthor() {
        return author;
    }
    
    //Mutator: Assigns the title of this Book
    public void setTitle(String title) {
        this.title = title;
    }

    //Mutator: Assigns the year of this Book
    public void setYear(int year) {
        this.year =  year;
    }

    //Mutator: Assigns the price of this Book
    public void setPrice(double price) {
        this.price = price;
    }

    //Mutator: Assigns the author of this Book
    public void setAuthor(String author) {
        this.author = author;
    }
    
        
 
    
    // Overriding toString() method of String class
     @Override
        public String toString() 
    {
        return "Book Title :" + title + "\nYear published: " + year + "\nBook price:"+ price + "\nAuthor:" + author+"\n" ;
        
      }
    
   
}