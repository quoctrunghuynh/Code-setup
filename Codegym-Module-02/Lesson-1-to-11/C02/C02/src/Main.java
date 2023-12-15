import service.CategoryService;
import service.impl.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.add();
        categoryService.getAll();
    }
}