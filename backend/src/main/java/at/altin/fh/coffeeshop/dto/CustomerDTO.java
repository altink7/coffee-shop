package at.altin.fh.coffeeshop.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String description;
    private LocalDateTime createdAt;
    //https://pasankavi.medium.com/managing-bidirectional-relationships-in-json-serialization-jsonignore-jsonmanagedreference-and-77cab1e4ef55
    private List<CoffeeDTO> coffees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CoffeeDTO> getCoffeeIds() {
        return coffees;
    }

    public void setCoffeeIds(List<CoffeeDTO> coffeeIds) {
        this.coffees = coffeeIds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
