import java.util.Scanner;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;




    /*public User(String email,String password)
    {
        setName("Not existed");
        setId("Not existed");
        setEmail(email);
        setPassword(password);
    }*/
    public User(String id,String name,String email,String password)
    {
        setId(id);
        setEmail(email);
        setName(name);
        setPassword(password);
    }

    public User()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User's ID: ");
        setId(scanner.nextLine());
        System.out.println("Username: ");
        setName(scanner.nextLine());
        System.out.println("Email: ");
        setEmail(scanner.nextLine());
        System.out.println("Password: ");
        setPassword(scanner.nextLine());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
