package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_linked_list.util;

import ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_linked_list.models.Product;

import java.util.Comparator;

public class ProductQuantityComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getProductQuantity() > o2.getProductQuantity()) {
            return 1;
        } else if (o1.getProductQuantity() < o2.getProductQuantity()) {
            return -1;
        } else {
            return 1;
        }
    }
}
