import java.util.Scanner;

public class Account {
    private String name;
    private String mobile;

    public void createAccount(Scanner sc) {
        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter mobile number: ");
        mobile = sc.nextLine();

        System.out.println("Account created successfully!\n");
    }

    public String getName() {
        return name;
    }
}
