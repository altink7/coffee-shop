package at.altin.fh.coffeeshop.service;

import at.altin.fh.coffeeshop.exception.EntityAlreadyExistsException;
import at.altin.fh.coffeeshop.model.Coffee;
import at.altin.fh.coffeeshop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    private CoffeeRepository coffeeRepository;

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
        return coffeeRepository.findByName(name);
    }

    /**
     * Add a coffee to the List of Coffees
     */
    public Coffee addCoffee(Coffee coffee) {
        Optional<Coffee> savedCoffee = coffeeRepository.findById(coffee.getId());

        if (savedCoffee.isPresent()) {
            throw new EntityAlreadyExistsException(String.format("Coffee: %s already exists", coffee.getName()));
        }
    }

    /**
     * delete Coffee
     */
    public boolean deleteCoffee(Coffee coffee) {
        // Important: make sure coffees contains no null elements, because NPE
        for (Coffee coffeObj : coffees) {
            if (coffeObj.getName().equals(coffee.getName())) {
                return coffees.remove(coffeObj);
            }
        }

        return false;
    }

    /**
     * delete Coffee with name
     */
    public boolean deleteCoffee(String name) {
        // Important: make sure coffees contains no null elements, because NPE
        for (Coffee coffeObj : coffees) {
            if (coffeObj.getName().equals(name)) {
                return coffees.remove(coffeObj);
            }
        }

        return false;
    }


    /**
     * update Coffee
     */
    public Coffee updateCoffee(Coffee coffee) {
        for (Coffee coffeObj : coffees) {
            if (coffeObj.getName().equals(coffee.getName())) {
                coffees.remove(coffeObj);
                coffees.add(coffee);
                return coffee;
            }
        }

        return null;
    }
}
