import java.time.LocalDate;

// product that can expire
public class expirableProduct extends product {
    private LocalDate expiryDate;

    public expirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
