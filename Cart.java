import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new LinkedHashMap<>();

    public void addProduct(Product product, int qty) {
        items.put(product, items.getOrDefault(product, 0) + qty);
        System.out.println(qty + " x " + product.getName() + " added to cart.");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("\n--- Cart Items ---");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            double cost = entry.getKey().getPrice() * entry.getValue();
            total += cost;
            System.out.println(entry.getKey().getName() +
                    " x " + entry.getValue() + " = ₹" + cost);
        }
        System.out.println("Total: ₹" + total);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotalAmount() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }
}
