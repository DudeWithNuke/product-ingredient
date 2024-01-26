package com.dudewithnuke.productingredients;

import com.dudewithnuke.productingredients.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Test
    void createProduct_1() {
        Product cake = new Product("Cake");
        Product vanillin = new Product("Vanillin");
        Product cacao = new Product("Cacao");
        Product dough = new Product("Dough");
        Product caffeine = new Product("Caffeine");
        Product water = new Product("Water");
        Product flour = new Product("Flour");
        Product eggs = new Product("Eggs");
        Product anotherWater = new Product("Another water");

        cake.add(vanillin);
        cake.add(cacao);
        cake.add(dough);
        cacao.add(caffeine);
        cacao.add(water);
        dough.add(flour);
        dough.add(eggs);
        dough.add(anotherWater);

        cake.printAll();
    }

    @Test
    void createProduct_2() {
        Product dough = new Product("Dough");
        Product flour = new Product("Flour");
        Product eggs = new Product("Eggs");
        Product water = new Product("Water");
        Product wheat = new Product("Wheat");

        dough.add(flour);
        dough.add(eggs);
        dough.add(water);
        flour.add(dough);
        flour.add(wheat);
        wheat.add(dough);

        dough.printAll();
    }
}
