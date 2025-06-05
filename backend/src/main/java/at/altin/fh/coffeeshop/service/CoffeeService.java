package at.altin.fh.coffeeshop.service;

import at.altin.fh.coffeeshop.dto.CoffeeDTO;
import at.altin.fh.coffeeshop.exception.EntityAlreadyExistsException;
import at.altin.fh.coffeeshop.exception.EntityNotFoundException;
import at.altin.fh.coffeeshop.mapper.CoffeeMapper;
import at.altin.fh.coffeeshop.model.Coffee;
import at.altin.fh.coffeeshop.model.Customer;
import at.altin.fh.coffeeshop.repository.CoffeeRepository;
import at.altin.fh.coffeeshop.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final CustomerRepository customerRepository;
    private final CoffeeMapper coffeeMapper;


    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository, CustomerRepository customerRepository, CoffeeMapper coffeeMapper) {
        this.coffeeRepository = coffeeRepository;
        this.customerRepository = customerRepository;
        this.coffeeMapper = coffeeMapper;
    }

    /**
     * Get all coffees
     */
    public List<CoffeeDTO> getAllCoffees() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        return coffeeMapper.toDTO(coffeeList);
    }


    /**
     * Get a Coffee By Name
     */
    public CoffeeDTO getCoffeeByName(String name) {
        Coffee coffee = coffeeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Coffee: %s does not exist", name)
                ));

        return coffeeMapper.toDTO(coffee);
    }

    /**
     * Add a coffee to the List of Coffees
     */
    public CoffeeDTO addCoffee(CoffeeDTO coffee) {
        Optional<Coffee> savedCoffee = coffeeRepository.findByName(coffee.getName());

        if (savedCoffee.isPresent()) {
            throw new EntityAlreadyExistsException(String.format("Coffee: %s already exists", coffee.getName()));
        }

        Coffee entity = coffeeMapper.toEntity(coffee);
        Customer customer = new Customer().randomizeData();
        entity.setCustomer(customer);
        customerRepository.save(customer);

        Coffee repoCoffee = coffeeRepository.save(entity);

        return coffeeMapper.toDTO(repoCoffee);
    }

    /**
     * delete Coffee
     */
    public boolean deleteCoffee(CoffeeDTO coffee) {
        coffeeRepository.delete(coffeeMapper.toEntity(coffee));
        return true;
    }

    /**
     * delete Coffee with name
     */
    public boolean deleteCoffee(String name) {
        coffeeRepository.deleteByName(name);

        return true;
    }


    /**
     * update/patch Coffee
     */
    public CoffeeDTO updateCoffee(CoffeeDTO coffee) {
        Optional<Coffee> savedCoffee = coffeeRepository.findByName(coffee.getName());

        if (savedCoffee.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("Coffee: %s does not exist", coffee.getName())
            );
        }

        if (coffee.getCoffeeType() == null) {
            throw new RuntimeException();
        }

        Coffee repoCoffee = coffeeRepository.save(coffeeMapper.toEntity(coffee));

        return coffeeMapper.toDTO(repoCoffee);
    }
}
