import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct("1", "Shirt", 50000);
        productManager.addProduct("2", "Pant", 70000);
        productManager.addProduct("3", "Shoes", 40000);
        productManager.addProduct("4", "Jacket", 200000);
        productManager.addProduct("5", "Belt", 60000);
        productManager.ShowProduct();
        productManager.ChangeProductById("2","Underwear",1);
        productManager.ShowProduct();
        productManager.RemoveProductById("2");
        productManager.ShowProduct();
        productManager.SearchNameByName("elt");

        productManager.ArrangeProduct();
    }
}
