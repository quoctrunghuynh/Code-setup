import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Shopee {
    public static void main(String[] args) {
        CategoryServiceImpl.add();
        CategoryServiceImpl.getAll();

        ProductService productService = new ProductServiceImpl();
        productService.add();
        productService.getById();
    }
}
