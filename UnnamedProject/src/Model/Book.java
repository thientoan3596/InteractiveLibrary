package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String id;
    private String name;
    private String author;

    public Book(String id,String name,String author )
    {
        setId(id);
        setName(name);
        setAuthor(author);
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //testing method;

    public static ArrayList<Book> test_autoGenerateBooks()
    {
        ArrayList<Book> books = new ArrayList<>();

        for(int tempCounter = 1;tempCounter< 20;tempCounter++)
        {
            books.add(new Book("B"+tempCounter,"Book "+tempCounter,"Author "+tempCounter));
        }
        return books;
    }


}
