// customer with a balance and a cart
public class customer {
    private String name;
    private double balance;
    private cart cart;

    public customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new cart();
    }

    public double getBalance() { return balance; }
    public cart getCart() { return cart; }

    // add product to cart
    public void addToCart(product product, int quantity) {
        cart.add(product, quantity);
    }

    // reduce balance after payment
    public void pay(double amount) {
        if (amount > balance) throw new IllegalArgumentException("not enough balance");
        balance -= amount;
    }
}
