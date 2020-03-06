package Model;

import java.util.ArrayList;

public class Loan {
    private User user;
    private ArrayList<Book> rentingBooks;


    public  Loan(User u,ArrayList<Book> books)
    {
        setUser(u);
        setRentingBooks(books);
    }

    public  Loan(User u,Book b)
    {
        setUser(u);
        rentingBooks = new ArrayList<>();
        addABook(b);
    }
    public Loan(User u)
    {
        setUser(u);
        rentingBooks = new ArrayList<>();
    }
    public void addABook(Book b)
    {
        this.rentingBooks.add(b);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Book> getRentingBooks() {
        return rentingBooks;
    }

    public void setRentingBooks(ArrayList<Book> rentingBooks) {
        this.rentingBooks = rentingBooks;
    }

    public Boolean isExisted(Book book)
    {
        return rentingBooks.contains(book);
    }
}
