// one product and its quantity in the cart
public class cartItem {
    private product product;
    private int quantity;

    public cartItem(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public product getProduct() { return product; }
    public int getQuantity() { return quantity; }
}
