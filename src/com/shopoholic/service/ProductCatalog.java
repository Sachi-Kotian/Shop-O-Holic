package com.shopoholic.service;
import com.shopoholic.model.*;
import java.util.Optional;

import java.util.List;
import java.util.ArrayList;



public class ProductCatalog {

    private List<Product> catalog;

    public ProductCatalog()
    {
        catalog=new ArrayList<>();
    }

    public void addProducts(Product p)
    {
        catalog.add(p);
    }

    public void removeProduct(int productId)
    {
        catalog.removeIf(p -> p.getProductId() == productId);

    }

    public void displayProduct()
    {
        for(Product p:catalog)
        {
            System.out.println(p);
        }
    }

    public void filterByName(String productName)
    {
        List<Product> byName=catalog.stream()
                .filter(p->p.getProductName().toLowerCase().contains(productName.toLowerCase()))
                .toList();

        byName.forEach(p->System.out.println(p));
    }

    public void filterByCategory(String category)
    {
        List<Product> byCategory=catalog.stream()
                .filter(p->p.getCategory().toLowerCase().contains(category.toLowerCase()))
                .toList();

        byCategory.forEach(p->System.out.println(p));

    }

    public Optional<Product> idToProduct(int productId)
    {
        for(Product p:catalog)
        {
            if(p.getProductId()==productId)
            {
                return Optional.of(p);
            }

        }
        return Optional.empty();
    }


}
