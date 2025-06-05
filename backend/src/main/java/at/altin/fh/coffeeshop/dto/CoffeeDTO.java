package at.altin.fh.coffeeshop.dto;

public class CoffeeDTO {
    private Long id;
    private String name;
    private String coffeeType;
    private double price;
    // https://pasankavi.medium.com/managing-bidirectional-relationships-in-json-serialization-jsonignore-jsonmanagedreference-and-77cab1e4ef55
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customer) {
        this.customerId = customer;
    }
}
