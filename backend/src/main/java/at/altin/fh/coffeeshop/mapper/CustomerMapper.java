package at.altin.fh.coffeeshop.mapper;

import at.altin.fh.coffeeshop.dto.CoffeeDTO;
import at.altin.fh.coffeeshop.dto.CustomerDTO;
import at.altin.fh.coffeeshop.model.Coffee;
import at.altin.fh.coffeeshop.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setCreatedAt(customer.getCreatedAt());
        customerDTO.setCoffeeIds(mapCoffees(customer.getCoffees()));
        return customerDTO;
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setCreatedAt(customerDTO.getCreatedAt());
        return customer;
    }

    public List<CoffeeDTO> mapCoffees(List<Coffee> coffees) {
        List<CoffeeDTO> coffeeDTOS = new ArrayList<>();
        for (Coffee coffee : coffees) {
            CoffeeDTO coffeeDTO = new CoffeeDTO();

            coffeeDTO.setId(coffee.getId());
            coffeeDTO.setName(coffee.getName());
            coffeeDTO.setCoffeeType(coffee.getCoffeeType());
            coffeeDTO.setPrice(coffee.getPrice());

            if (coffee.getCustomer() != null) {
                coffeeDTO.setCustomerId(coffee.getCustomer().getId());
            }

            coffeeDTOS.add(coffeeDTO);
        }
        return coffeeDTOS;
    }
}
