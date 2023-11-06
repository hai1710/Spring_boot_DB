package com.example.demo.handleMenu;

import com.example.demo.data.product.IProductService;
import com.example.demo.model.Product;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {

    private final IProductService productService;

    public ProductMenu(IProductService productService) {
        this.productService = productService;
    }

    public void handleMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            try {
                System.out.println("1. Add");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. View All Products");
                System.out.println("0. Back");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addProduct(scanner);
                        break;
                    case 2:
                        updateProduct(scanner);
                        break;
                    case 3:
                        deleteProduct(scanner);
                        break;
                    case 4:
                        printAllProducts();
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.println("Enter product details:");
        try {
            System.out.print("Product Code: ");
            int productCode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Price: ");
            BigDecimal price = scanner.nextBigDecimal();
            scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Image: ");
            String image = scanner.nextLine();
            System.out.print("Quantity in Stock: ");
            int quantityInStock = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quantity Sold: ");
            int quantitySold = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Store ID: ");
            int storeId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Category ID: ");
            int categoryId = scanner.nextInt();
            scanner.nextLine();

            Product newProduct = new Product();
            newProduct.setProductCode(productCode);
            newProduct.setProductName(productName);
            newProduct.setPrice(price);
            newProduct.setDescription(description);
            newProduct.setImage(image);
            newProduct.setQuantityInStock(quantityInStock);
            newProduct.setQuantitySold(quantitySold);
            newProduct.setIdStore(storeId);
            newProduct.setIdCategory(categoryId);

            productService.addProduct(newProduct);

            System.out.println("Product added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values for product code, price, quantity, store ID, and category ID.");
            scanner.nextLine();
        }
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Enter Product ID to update: ");
        try {
            int productId = scanner.nextInt();
            scanner.nextLine();

            Product existingProduct = productService.findProductById(productId);
            if (existingProduct != null) {
                System.out.println("Enter updated product details:");
                System.out.print("Product Code: ");
                int productCode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Product Name: ");
                String productName = scanner.nextLine();
                System.out.print("Price: ");
                BigDecimal price = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.print("Description: ");
                String description = scanner.nextLine();
                System.out.print("Image: ");
                String image = scanner.nextLine();
                System.out.print("Quantity in Stock: ");
                int quantityInStock = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Quantity Sold: ");
                int quantitySold = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Store ID: ");
                int storeId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Category ID: ");
                int categoryId = scanner.nextInt();
                scanner.nextLine();

                existingProduct.setProductCode(productCode);
                existingProduct.setProductName(productName);
                existingProduct.setPrice(price);
                existingProduct.setDescription(description);
                existingProduct.setImage(image);
                existingProduct.setQuantityInStock(quantityInStock);
                existingProduct.setQuantitySold(quantitySold);
                existingProduct.setIdStore(storeId);
                existingProduct.setIdCategory(categoryId);

                productService.updateProduct(existingProduct);

                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found with ID: " + productId);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values for product ID, product code, price, quantity, store ID, and category ID.");
            scanner.nextLine();
        }
    }

    private void deleteProduct(Scanner scanner) {
        System.out.print("Enter Product ID to delete: ");
        try {
            int productId = scanner.nextInt();
            scanner.nextLine();

            Product existingProduct = productService.findProductById(productId);
            if (existingProduct != null) {
                productService.deleteProduct(productId);
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found with ID: " + productId);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid product ID.");
            scanner.nextLine();
        }
    }

    private void printAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}