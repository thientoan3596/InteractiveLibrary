import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    public User login(ArrayList<User> users)
    {
        String email ;
        String pwd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email address: ");
        email =scanner.nextLine();
        System.out.println("Password: ");
        pwd = scanner.nextLine();
        for(User user: users)
        {
            if(user.getEmail().equals(email)&&user.getPassword().equals(pwd))
            {
                System.out.println("Welcom "+ user.getName());
                return user;
            }

        }
        System.out.println("email/password is incorrect!");
        return null;
    }
    public User signUp()
    {
        return new User();
    }
    public void userMenu(User user)
    {
        Scanner scanner = new Scanner(System.in);
        int userOption = 0;
        System.out.println("(1) Show all renting books\n(2)Books in library \n(3)Rent \n(4) Return \n(5) Logout");
        while(userOption != 1 &&  userOption != 2 && userOption != 3 && userOption != 4 && userOption != 5)
        {
            
        }
    }

}