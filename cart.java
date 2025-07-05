import java.util.*;

// shopping cart holds items
public class cart {
    private List<cartItem> items = new ArrayList<>();

    // add product to cart if enough stock
    public void add(product product, int quantity) {
        if (quantity <= 0 || quantity > product.getQuantity()) {
            throw new IllegalArgumentException("not enough stock");
        }
        items.add(new cartItem(product, quantity));
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public List<cartItem> getItems() { return items; }

    // calculate total price of all items
    public double getSubtotal() {
        double sum = 0;
        for (cartItem item : items) {
            sum += item.getProduct().getPrice() * item.getQuantity();
        }
        return sum;
    }

    // get all shippable items from cart
    public List<shippable> getShippableItems() {
        List<shippable> shippables = new ArrayList<>();
        for (cartItem item : items) {
            if (item.getProduct() instanceof shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((shippable) item.getProduct());
                }
            }
        }
        return shippables;
    }
}
