import java.time.LocalDate;

// product that can expire and be shipped
public class expirableShippableProduct extends expirableProduct implements shippable {
    private double weight;

    public expirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
}
