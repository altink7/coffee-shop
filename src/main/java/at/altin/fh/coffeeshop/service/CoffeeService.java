package at.altin.fh.coffeeshop.service;

import at.altin.fh.coffeeshop.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {
    private List<Coffee> coffees = new ArrayList<>();

//Test für git
    public void initializeCoffees() {
        coffees.add(new Coffee("melange", "coffee", 4.5f));
        coffees.add(new Coffee("cappuccino", "coffee", 2.5f));
        coffees.add(new Coffee("cappuccino", "tee", 3.5f));
        coffees.add(new Coffee("ice cream", "vanilla", 5.5f));
    }

    /**
     * Get all coffees
     */
    public List<Coffee> getAllCoffees() {
        initializeCoffees();
        return coffees;
    }
    public void gittets(){

    }

    /**
     * Add a coffee to the List of Coffees
     */
    public Coffee addCoffee(Coffee coffee) {
        if (coffee == null) {
            System.out.println("WARN: null object");
            return null;
        }

        coffees.add(coffee);
        return coffee;
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
