import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private String from;
    private String description;
    private static int ids;

    public Product(String name, double price, String from, String description) {
        this.id = ids;
        ids++;
        this.name = name;
        this.price = price;
        this.from = from;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", from='" + getFrom() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
