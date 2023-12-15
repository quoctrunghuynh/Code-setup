import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    // Biến serialVersionUID có tác dụng xác nhận object lúc gửi/nhận
    // tương thích với quá trình Serialization
    @Serial
    private static final long serialVersionUID = -266706354210367639L;

    private final int id;
    private final String name;
    private final double price;
    private final String description;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}