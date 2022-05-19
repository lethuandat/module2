package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_array_list;

import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
       return o1.getProductName().compareTo(o2.getProductName());
    }
}
