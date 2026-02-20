import java.util.Scanner;

public class OnlineShoppingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to DesiCart");

        Account account = new Account();
        account.createAccount(sc);

        Customer customer = new Customer(account);
        System.out.println("Hello " + customer.getCustomerName());

        ShopController shop = new ShopController(sc);
        shop.startShopping();

        // DO NOT close scanner for System.in
        // sc.close(); ❌
    }
}
