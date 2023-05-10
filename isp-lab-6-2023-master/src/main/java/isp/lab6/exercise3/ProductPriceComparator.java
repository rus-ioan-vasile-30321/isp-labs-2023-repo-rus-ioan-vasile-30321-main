package isp.lab6.exercise3;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}
