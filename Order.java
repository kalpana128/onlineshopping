
public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void placeOrder() {
        System.out.println("\nOrder placed successfully!");
        System.out.println("Amount paid: ₹" + cart.getTotalAmount());
        System.out.println("Thank you for shopping!\n");
        cart.clearCart();
    }
}
