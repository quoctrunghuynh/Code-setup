package service.impl;

import entity.Category;
import service.CategoryService;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryServiceImpl implements CategoryService {

    private static ArrayList<Category> categories = new ArrayList<>();


    public static void add() {
        categories.add(new Category(1, "Men fashion"));
        categories.add(new Category(2, "Women fashion"));
        categories.add(new Category(3, "Kid fashion"));
        categories.add(new Category(4, "Shoes"));
    }


    public static void getAll() {
        for(Category element : categories){
            System.out.println(element);
        }
    }
}
