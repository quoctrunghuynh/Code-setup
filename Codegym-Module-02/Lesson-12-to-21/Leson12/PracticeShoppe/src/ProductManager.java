import java.util.*;

public class ProductManager {
    ArrayList<Product> listProduct = new ArrayList<>();

    public void addProduct(String id, String name, double price) {
        Product product = new Product(id, name, price);
        listProduct.add(product);
    }

    public void ChangeProductById(String id, String newName, double newPrice) {
        for (Product item : listProduct) {
            if (Objects.equals(item.getId(), id)) {
                item.setName(newName);
                item.setPrice(newPrice);
            }
        }
    }

    public void RemoveProductById(String id) {
        listProduct.removeIf(item -> Objects.equals(item.getId(), id));
    }

    public void ShowProduct() {
        System.out.println(listProduct);
    }

    public void SearchNameByName(String name) {
        ArrayList<Product> NameList = new ArrayList<>();
        for (Product item : listProduct) {
            if (item.getName().contains(name)) {
                NameList.add(item);
            }
        }
        for (Product item : NameList) {
            System.out.println(item);
        }
    }

    public void ArrangeProduct() {
        Comparator<Product> comparator = Collections.reverseOrder();
        listProduct.sort(comparator);
        for (Product item : listProduct) {
            System.out.println(item);
        }
    }
}
