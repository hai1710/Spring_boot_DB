package com.example.demo;

import com.example.demo.data.category.CategoryService;
import com.example.demo.data.product.ProductService;
import com.example.demo.data.store.StoreService;
import com.example.demo.handleMenu.CategoryMenu;
import com.example.demo.handleMenu.ProductMenu;
import com.example.demo.handleMenu.StoreMenu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Scanner;

public class AppRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo JdbcTemplate và cấu hình nguồn dữ liệu
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ex3_sql");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // Tạo JdbcTemplate từ nguồn dữ liệu
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Khởi tạo StoreService với JdbcTemplate
        StoreService storeService = new StoreService(jdbcTemplate);
        StoreMenu storeMenu = new StoreMenu(storeService);

        // Khởi tạo CategoryService với JdbcTemplate
        CategoryService categoryService = new CategoryService(jdbcTemplate);
        CategoryMenu categoryMenu = new CategoryMenu(categoryService);

        // Khởi tạo ProductService với JdbcTemplate
        ProductService productService = new ProductService(jdbcTemplate);
        ProductMenu productMenu = new ProductMenu(productService);

        boolean quit = false;
        while (!quit) {
            System.out.println("1. Category Menu");
            System.out.println("2. Product Menu");
            System.out.println("3. Store Menu");
            System.out.println("0. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                     categoryMenu.handleMenu(scanner);
                    break;
                case 2:
                     productMenu.handleMenu(scanner);
                    break;
                case 3:
                    storeMenu.handleMenu(scanner);
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting the application...");
    }
}