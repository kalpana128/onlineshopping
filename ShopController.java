import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopController {

    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();
    private Scanner sc;

    public ShopController(Scanner sc) {
        this.sc = sc;

        products.add(new Product("Tata Salt", 30));
        products.add(new Product("Amul Milk", 28));
        products.add(new Product("Parle-G", 10));
        products.add(new Product("Maggi", 15));
        products.add(new Product("Rice (1kg)", 50));
        products.add(new Product("Wheat Flour (1kg)", 40));
        products.add(new Product("Sugar (1kg)", 45));
        products.add(new Product("Tea Leaves (250g)", 120));
        products.add(new Product("Coffee Powder (200g)", 150));
        products.add(new Product("Bread", 25));
        products.add(new Product("Butter (500g)", 200));
        products.add(new Product("Cheese (200g)", 180));
        products.add(new Product("Eggs (12 pack)", 60));
        products.add(new Product("Chicken (1kg)", 250));
        products.add(new Product("Fish (500g)", 300));
        products.add(new Product("Potatoes (1kg)", 30));
        products.add(new Product("Onions (1kg)", 25));
        products.add(new Product("Tomatoes (1kg)", 40));
        products.add(new Product("Apples (1kg)", 120));
        products.add(new Product("Bananas (1kg)", 50));
        products.add(new Product("Orange Juice (1L)", 80));
        products.add(new Product("Coca-Cola (2L)", 90));
        products.add(new Product("Chocolates (100g)", 70));
        products.add(new Product("Soap", 20));
        products.add(new Product("Shampoo (200ml)", 150));
    }

    public void startShopping() {
        showProducts();
        addProductsToCart();
        proceedToPayment();
    }

    private void showProducts() {
        System.out.println("\n--- Products ---");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " +
                    products.get(i).getName() +
                    " - ₹" + products.get(i).getPrice());
        }
    }

    private void addProductsToCart() {
        String choice = "yes";

        while (choice.equalsIgnoreCase("yes")) {

            System.out.print("\nSelect product number: ");
            int productNo = sc.nextInt();
            sc.nextLine();

            if (productNo < 1 || productNo > products.size()) {
                System.out.println("Invalid product number.");
                continue;
            }

            System.out.println("You selected: " + products.get(productNo - 1).getName());
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            cart.addProduct(products.get(productNo - 1), qty);

            System.out.print("Add more products? (yes/no): ");
            choice = sc.nextLine();
        }
    }

    private void proceedToPayment() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Order cancelled.");
            return;
        }

        cart.viewCart();

        System.out.print("\nProceed to payment? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            Order order = new Order(cart);
            order.placeOrder();
        } else {
            System.out.println("Payment cancelled.");
        }
    }
}
