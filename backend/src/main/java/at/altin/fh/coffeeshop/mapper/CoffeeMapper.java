package at.altin.fh.coffeeshop.mapper;

import at.altin.fh.coffeeshop.dto.CoffeeDTO;
import at.altin.fh.coffeeshop.model.Coffee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoffeeMapper {

    public List<CoffeeDTO> toDTO(List<Coffee> coffees) {
        List<CoffeeDTO> coffeeDTOS = new ArrayList<>();
        for (Coffee coffee : coffees) {
            coffeeDTOS.add(toDTO(coffee));
        }
        return coffeeDTOS;
    }

    public CoffeeDTO toDTO(Coffee coffee) {
        CoffeeDTO coffeeDTO = new CoffeeDTO();

        coffeeDTO.setId(coffee.getId());
        coffeeDTO.setName(coffee.getName());
        coffeeDTO.setCoffeeType(coffee.getCoffeeType());
        coffeeDTO.setPrice(coffee.getPrice());

        if (coffee.getCustomer() != null) {
            coffeeDTO.setCustomerId(coffee.getCustomer().getId());
        }

        return coffeeDTO;
    }


    public Coffee toEntity(CoffeeDTO coffeeDTO) {
        Coffee coffee = new Coffee();
        coffee.setId(coffeeDTO.getId());
        coffee.setName(coffeeDTO.getName());
        coffee.setCoffeeType(coffeeDTO.getCoffeeType());
        coffee.setPrice(coffeeDTO.getPrice());

        return coffee;
    }
}
