import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // create products
        expirableShippableProduct cheese = new expirableShippableProduct("cheese", 100, 5, LocalDate.now().plusDays(5), 400);
        expirableShippableProduct biscuits = new expirableShippableProduct("biscuits", 150, 2, LocalDate.now().plusDays(10), 700);
        shippableProduct tv = new shippableProduct("tv", 8000, 3, 5000);
        product scratchCard = new product("scratch card", 50, 10) {}; // simple product

        // create customer
        customer customerAli = new customer("ali", 1000);

        // add to cart (throws exception if item is not in stock)
        customerAli.addToCart(cheese, 2);
        customerAli.addToCart(biscuits, 1);
        customerAli.addToCart(scratchCard, 1);

        // checkout
        checkoutService.checkout(customerAli, customerAli.getCart());
    }
}
