// product that can be shipped
public class shippableProduct extends product implements shippable {
    private double weight;

    public shippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
}
