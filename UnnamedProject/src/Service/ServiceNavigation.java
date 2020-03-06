package Service;

import Model.Book;
import Model.Loan;
import Model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceNavigation {

    public void launch()
    {
        //Initial set up
        User currentUser ;
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        UserService userService = new UserService();

        ArrayList<User> usersList;
        ArrayList<Book> bookList;
        ArrayList<Loan> loansList;


        //parsing data from DB
        usersList = User.test_autoGenerateUser();
        bookList = Book.test_autoGenerateBooks();
        loansList = test_autoGenerateEmptyLoanRecordList(usersList);

        //test
        /*Scanner scanner1 = new Scanner(System.in);
        System.out.println("Book's name: ");
        String bookName = scanner1.nextLine();

        System.out.println(bookList.get(0).getName().equals(bookName));*/
        //Showing main menu
        System.out.println("Welcome to Interactive Library");
        while (true )
        {
            System.out.println("(1) Sign up\n(2) Login \n(0) Exit!");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    usersList.add(new User());
                    loansList.add(new Loan(usersList.get(usersList.size()-1))); // -1?
                    //Registration
                    break;
                case 2:
                    // Login
                    currentUser = loginService(usersList);
                    if(currentUser != null)
                    {
                        Loan loan = findLoanRecordOfUser(currentUser,loansList);
                        //update loansList
                        loansList.set(loansList.indexOf(loan),userService.launch(currentUser,bookList,loan));
                    }

                    break;
                case 0:
                    System.out.println("Bye!");
                    continue;
                default:
                    System.out.println("Please enter an appropriate option!");
                    break;
            }
        }
        //update DB

    }

    public User loginService(ArrayList<User> users)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email: ");
        String email_Temp = scanner.nextLine();
        System.out.println("Password: ");
        String pwd_Temp = scanner.nextLine();
        for( User u: users)
        {
            if(u.getEmail().equals(email_Temp)&&u.getPassword().equals(pwd_Temp))
                return u;
        }
        System.out.println("Email or password is incorrect!");
        return null;
    }

    public Loan findLoanRecordOfUser(User u, ArrayList<Loan> loans)
    {
        for(Loan l: loans)
        {
            if(l.getUser().equals(u))
            {
                return l;
            }
        }
        return null;
    }


    //testing method
    public ArrayList<Loan> test_autoGenerateEmptyLoanRecordList(ArrayList<User> users)
    {
        ArrayList<Loan> loans = new ArrayList<>();
        for(User u: users)
        {
            loans.add(new Loan(u));
        }
        return loans;
    }
}
