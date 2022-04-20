package com.blueJ.chapter02;

public class Book{

    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed;
    private boolean courseBook;

    public Book(String bookAuthor, String bookTitle, int numberOfPages, boolean isCourseBook){
        author = bookAuthor;
        title = bookTitle;
        pages = numberOfPages;
        refNumber = "";
        courseBook = isCourseBook;
    }

    public void borrow(){
        borrowed ++;
    }

    public int getBorrowed(){
        return borrowed;
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public int getNumberOfPages(){
        return pages;
    }

    public boolean getIsCourseBook(){
        return courseBook;
    }

    public void setRefNumber(String ref){
        if(ref.length() >= 3){
            refNumber = ref;
        }
        else {
            throw new IllegalArgumentException("Reference-Number must be at least 3 characters long!");
        }
    }

    public String getRefNumber(){
        return refNumber;
    }

    public void printDetails(){
        System.out.println("-------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: "+ pages);
        System.out.println("Borrowed: " + borrowed + " times");
        System.out.println("Is a Course Book: " + courseBook);
        System.out.println("-------------");
        if(refNumber.length() > 0){
            System.out.println("Reference Number: " + refNumber);
            System.out.println("-------------");
        }
        else {
            System.out.println("The Reference Number is not set!");
            System.out.println("-------------");
        }
    }

    public void printAuthor(){
        System.out.println("Author: " + author);
    }

    public void printTitle(){
        System.out.println("Title: " + title);
    }

    public void printNumberOfPages(){
        System.out.println("Pages: " + pages);
    }   
}
