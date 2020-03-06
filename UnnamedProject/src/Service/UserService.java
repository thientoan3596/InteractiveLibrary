package Service;

import Model.Book;
import Model.Loan;
import Model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    public Loan launch(User u, ArrayList<Book> books, Loan loan)
    {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        System.out.println("Welcome back "+u.getName());
        while (true)
        {
            System.out.println("(1)Show all books in inventory\n(2)Show all renting books\n(3)Rent book\n(4)Return book\n(0)Logout");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    showInventory(books);
                    break;
                case 2:
                    showRentingBooks(loan);
                    break;
                case 3:
                    loan = rentBook(u,books,loan);
                    break;
                case 4:
                    loan = returnBook(u,loan);
                    break;
                case 0:
                    System.out.println("Bye "+u.getName()+"!");
                    return loan;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }

    }

    public void showInventory(ArrayList<Book> books){
        for(Book b: books)
        {
            System.out.println(b.getId() +" | " +b.getName() + " | "+ b.getAuthor());
        }
    }
    public void showRentingBooks(Loan loan){
        if (!loan.getRentingBooks().isEmpty())
        {
            for(Book b: loan.getRentingBooks())
            {
                System.out.println(b.getId() +" | " +b.getName() + " | "+ b.getAuthor());
            }
        }
        else
            System.out.println("You have not rented anybook!");
    }

    public Loan rentBook(User u, ArrayList<Book> books, Loan loan)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book's name: ");
        String bookName = scanner.nextLine();

        for (Book b: books)
        {
            if(b.getName().equals(bookName))
            {
                if(loan.getRentingBooks().isEmpty() || !loan.getRentingBooks().contains(b))
                {
                    loan.addABook(b);
                    System.out.println("Process succeeded!");
                    return loan;
                }
                else
                {
                    loan.addABook(b);
                    System.out.println("Process succeeded!");
                    return loan;
                }
            }
        }
        System.out.println("The book you're looking for is not existed!");
        System.out.println("Process fail!");
        return loan;

    }

    public Loan returnBook(User u,Loan loan)
    {
        if(!loan.getRentingBooks().isEmpty())
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Book's name: ");
            String bookName = scanner.nextLine();
            for (Book b:loan.getRentingBooks())
            {
                if (b.getName().equals(bookName))
                {
                    System.out.println("Return book <" +b.getName()+"> successfully!");
                    loan.getRentingBooks().remove(b);
                    return loan;
                }
            }
            System.out.println("You haven't rented this book!");
            return loan;
        }
        else
        {
            System.out.println("You don't have anything to return!");
            return loan;
        }

    }

}
