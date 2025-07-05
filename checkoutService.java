import java.util.List;

// handles checkout logic
public class checkoutService {
    public static void checkout(customer customer, cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("cart is empty");

        // check for expired or out-of-stock products
        for (cartItem item : cart.getItems()) {
            product p = item.getProduct();
            if (p instanceof expirableProduct && ((expirableProduct) p).isExpired()) {
                throw new IllegalStateException(p.getName() + " is expired");
            }
            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalStateException(p.getName() + " out of stock");
            }
        }

        double subtotal = cart.getSubtotal();
        List<shippable> shippables = cart.getShippableItems();
        double shippingFee = 0;
        if (!shippables.isEmpty()) {
            double totalWeight = 0;
            for (shippable s : shippables) totalWeight += s.getWeight();
            shippingFee = Math.ceil(totalWeight / 1000.0) * 30; // 30 per kg
            shippingService.ship(shippables);
        }

        double total = subtotal + shippingFee;
        if (customer.getBalance() < total) throw new IllegalStateException("not enough balance");

        // update product quantities
        for (cartItem item : cart.getItems()) {
            product p = item.getProduct();
            p.setQuantity(p.getQuantity() - item.getQuantity());
        }
        customer.pay(total);

        // print receipt
        System.out.println("** checkout receipt **");
        for (cartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("subtotal %.0f\n", subtotal);
        System.out.printf("shipping %.0f\n", shippingFee);
        System.out.printf("amount %.0f\n", total);
        System.out.printf("customer balance after payment: %.0f\n", customer.getBalance());
    }
}
