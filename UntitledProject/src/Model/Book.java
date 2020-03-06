import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {

    public void mainMenu()
    {
        //Set up and fetching DB
        ArrayList<User> users =  new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();
        //ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> books = Book.autoGenerateBooks();

        UserService userService = new UserService();
        User currentUser = null;

        int UserOption = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Interactive Library\n\n");
        System.out.println("(1) Login\n(2)Sign up\n(3) Exit");
        UserOption = scanner.nextInt();
        while(UserOption != 1 && UserOption != 2 && UserOption != 3)
        {
            System.out.println("Please choose appropriate option!");
            UserOption = scanner.nextInt();
        }
        switch (UserOption)
        {
            case 1:
                //call login service?
                currentUser = userService.login(users)
                while( currentUser == null) //repeating until login successful
                {
                    currentUser = userService.login(users);
                }
                break;
            case 2:
                currentUser = userService.signUp();
                users.add(currentUser); //add this user to the DB;
                break;
            case 3:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("coding error!");
                break;
        }
    }
}
