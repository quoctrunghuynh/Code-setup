package service.impl;

import entity.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void add() {
        products.add(new Product(1,"Men's shirt",55000.0,1));
        products.add(new Product(2,"Men's pant",5000.0,1));
        products.add(new Product(3,"Men's shoes",100000.0,4));

        products.add(new Product(1,"Women's shirt",100000.0,2));
        products.add(new Product(2,"Women's skirt",200000.0,2));
        products.add(new Product(3,"Women's shoes",1000000.0,4));

        products.add(new Product(1,"Kid's shirt",70000.0,3));
        products.add(new Product(2,"Kid's pant",60000.0,3));
        products.add(new Product(3,"Kid's shoes",120000.0,4));

    }

    @Override
    public void getAll() {
        for (Product item : products){
            System.out.println(item);
        }

    }

    @Override
    public void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What you want to seek?");
        int option = scanner.nextInt();
        for (Product item : products){
            if(item.getCategory_id() == option ){
                System.out.println(item);
            }
        }
    }

}
