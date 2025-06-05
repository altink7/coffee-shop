package at.altin.fh.coffeeshop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String description;
    private LocalDateTime createdAt;

    //https://www.baeldung.com/hibernate-one-to-many
    @OneToMany(mappedBy = "customer")
    private List<Coffee> coffees;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Please ignore this method, it is only for testing purposes.
     * It generates a random customer with random data.
     *
     * @return a random Customer object
     */
    public Customer randomizeData() {
        //random strings and dates for testing
        String[] firstNames = {"John", "Jane", "Alice", "Bob"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Williams"};
        String[] addresses = {"123 Main St", "456 Elm St", "789 Oak St", "101 Pine St"};
        String[] descriptions = {"Regular customer", "VIP customer", "New customer", "Returning customer"};

        this.firstName = firstNames[(int) (Math.random() * firstNames.length)];
        this.lastName = lastNames[(int) (Math.random() * lastNames.length)];
        this.address = addresses[(int) (Math.random() * addresses.length)];
        this.description = descriptions[(int) (Math.random() * descriptions.length)];
        // Random date within the last 30 days
        this.createdAt = LocalDateTime.now().minusDays((int) (Math.random() * 30));

        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }
}
