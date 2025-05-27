package at.altin.fh.coffeeshop.service;

import at.altin.fh.coffeeshop.exception.EntityAlreadyExistsException;
import at.altin.fh.coffeeshop.exception.EntityNotFoundException;
import at.altin.fh.coffeeshop.model.Coffee;
import at.altin.fh.coffeeshop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    /**
     * Get all coffees
     */
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }


    /**
     * Get a Coffee By Name
     */
    public Coffee getCoffeeByName(String name) {
        return coffeeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Coffee: %s does not exist", name)
                ));
    }

    /**
     * Add a coffee to the List of Coffees
     */
    public Coffee addCoffee(Coffee coffee) {
        Optional<Coffee> savedCoffee = coffeeRepository.findById(coffee.getId());

        if (savedCoffee.isPresent()) {
            throw new EntityAlreadyExistsException(String.format("Coffee: %s already exists", coffee.getName()));
        }
        
        return coffeeRepository.save(coffee);
    }

    /**
     * delete Coffee
     */
    public boolean deleteCoffee(Coffee coffee) {
        coffeeRepository.delete(coffee);
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
    public Coffee updateCoffee(Coffee coffee) {
        Optional<Coffee> savedCoffee = coffeeRepository.findById(coffee.getId());

        if (savedCoffee.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("Coffee: %s does not exist", coffee.getName())
            );
        }

        if (coffee.getCoffeeType() == null) {
            throw new RuntimeException();
        }

        return coffeeRepository.save(coffee);
    }
}
