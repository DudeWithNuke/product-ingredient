package com.dudewithnuke.productingredients.domain;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Product extends AbstractTreeDataStruct {
    public Product(String name) {
        super(name);
    }

    public boolean add(Product ingredient) {
        Product rootProduct = this;
        while (true) {
            if (rootProduct.getName().equals(ingredient.getName())) {
                log.warn("Failed to add ingredient " + ingredient.getName() + " to " + rootProduct.getName() + ": it cannot contain itself");
                return false;
            }

            if (rootProduct.hasParent()) {
                rootProduct = (Product) rootProduct.getParent();
            }
            else {
                break;
            }
        }

        super.add(ingredient);
        log.info("Ingredient " + ingredient.getName() + " successfully added to the " + rootProduct.getName() + " product");
        return true;
    }
}
