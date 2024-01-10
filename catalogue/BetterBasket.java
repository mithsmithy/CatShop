package catalogue;

import java.io.Serializable;
import java.util.Comparator;

public class BetterBasket extends Basket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean add(Product pr) {
        // Check if the product already exists in the basket
        for (Product existingProduct : this) {
            if (pr.getProductNum().equals(existingProduct.getProductNum())) {
                // Update quantity and sort the basket
                existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity());
                sortProducts();
                return true;
            }
        }

        // If the product is not found, add it to the basket and sort
        super.add(pr);
        sortProducts();
        return true;
    }

    // Method to sort products based on product numbers
    private void sortProducts() {
        this.sort(Comparator.comparing(Product::getProductNum));
    }
}
