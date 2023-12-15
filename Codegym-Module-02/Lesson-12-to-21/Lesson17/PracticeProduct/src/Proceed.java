import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Proceed {
    static List<Product> products = new ArrayList<>();
    static void writeStream(String path, List<Product> productList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(productList);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static List<Product> ReadStream(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            products = (List<Product>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    static List<Product> productList() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Iron Pan", 100, "VietNam", "A pan has iron"));
        products.add(new Product("Steel Pan", 100, "VietNam", "An upgrade of iron pan"));
        products.add(new Product("Gun", 900, "US", "An mini automatic high-tech bow used by clicking the trigger..." +
                "you have to reload and buy bullets"));
        products.add(new Product("Bullets Pack", 200, "US", "A pack of 10 mini high-tech arrows that you" +
                " can stick it in your gun...can blow a hole in your enemy head"));

        return products;
    }
    public static void addProduct(String name, double price, String from, String description){
        Product product = new Product(name,price,from,description);
        productList().add(product);
    }
    public static void showProducts(){
        List<Product> productData = Proceed.ReadStream("products.txt");
        for(Product product : productData){
            System.out.println(product);
        }
    }
    public static void lookFor(String keyword){
        List<Product> productData = Proceed.ReadStream("products.txt");
        for(Product product : productData){
            if(product.toString().contains(keyword)){
                System.out.println(product);
            }
        }
    }
}
