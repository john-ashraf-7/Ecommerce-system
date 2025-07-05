import java.util.*;

// handles shipping of items
public class shippingService {
    public static void ship(List<shippable> items) {
        if (items.isEmpty()) return;
        System.out.println("** shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> weights = new HashMap<>();
        for (shippable item : items) {
            counts.put(item.getName(), counts.getOrDefault(item.getName(), 0) + 1);
            weights.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        for (String name : counts.keySet()) {
            System.out.printf("%dx %s %.0fg\n", counts.get(name), name, weights.get(name) * counts.get(name));
        }
        System.out.printf("total package weight %.1fkg\n", totalWeight / 1000.0);
    }
}
