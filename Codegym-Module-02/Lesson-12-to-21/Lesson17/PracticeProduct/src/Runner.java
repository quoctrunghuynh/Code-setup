import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Product> products = Proceed.productList();
        Proceed.addProduct("Ship", 100000, "VietNam", "A ship");
        Proceed.writeStream("products.txt", products);
        Proceed.showProducts();
        Proceed.lookFor("un");
    }
}