package at.altin.fh.coffeeshop.controller;

import at.altin.fh.coffeeshop.model.Coffee;
import at.altin.fh.coffeeshop.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    /**
     * GET : retrieve all coffees HEHE :D
     */
    @GetMapping
    public List<Coffee> getAllCoffees() {
        return coffeeService.getAllCoffees();
    }

    /**
     * GET : get Coffe By Name
     */
    @GetMapping("/{name}")
    public Coffee getCoffeeByName(@PathVariable String name) {
        return coffeeService.getCoffeeByName(name);
    }

    /**
     * POST : add a Coffee to the Coffee List
     */
    @PostMapping
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        return coffeeService.addCoffee(coffee);
    }

    /**
     * DELETE:  deletes a coffee from the Coffee List
     */
    @DeleteMapping
    public boolean deleteCoffee(@RequestBody Coffee coffee) {
        return coffeeService.deleteCoffee(coffee);
    }

    /**
     * DELETE:  deletes a coffee from the Coffee List
     */
    @DeleteMapping("/{name}")
    public boolean deleteCoffee(@PathVariable String name) {
        return coffeeService.deleteCoffee(name);
    }

    /**
     * PUT:  updates a coffee from the Coffee List
     */
    @PutMapping
    public Coffee updateCoffee(@RequestBody Coffee coffee) {
        return coffeeService.updateCoffee(coffee);
    }
}
