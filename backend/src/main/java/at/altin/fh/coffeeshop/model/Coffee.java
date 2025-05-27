package at.altin.fh.coffeeshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coffees")
public class Coffee {
    @Id
    @GeneratedValue
    @Column(name = "coffee_id")
    private Long id;

    @Column(name = "coffee_name")
    private String name;

    private String coffeeType;
    private double price;

    public Coffee() {
    }

    public Coffee(String name, String type, double price) {
        this.name = name;
        this.coffeeType = type;
        this.price = price;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
