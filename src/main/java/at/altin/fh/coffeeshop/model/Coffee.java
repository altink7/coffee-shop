package at.altin.fh.coffeeshop.model;

public class Coffe {
    private String name;
    private String type;
    private double price;

    public Coffe() {
    }

    public Coffe(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
