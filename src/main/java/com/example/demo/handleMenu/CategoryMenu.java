package com.example.demo.handleMenu;

import com.example.demo.data.category.ICategoryService;
import com.example.demo.model.Category;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CategoryMenu {

    private final ICategoryService categoryService;

    public CategoryMenu(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void handleMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            try {
                System.out.println("1. Add");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. View All Categories");
                System.out.println("0. Back");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addCategory(scanner);
                        break;
                    case 2:
                        updateCategory(scanner);
                        break;
                    case 3:
                        deleteCategory(scanner);
                        break;
                    case 4:
                        printAllCategories();
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
                scanner.nextLine(); // Đọc dòng new line sau khi xảy ra exception
            }
        }
    }

    private void addCategory(Scanner scanner) {
        System.out.println("Enter category details:");
        try {
            System.out.print("Category Code: ");
            int categoryCode = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng new line sau khi đọc số
            System.out.print("Name: ");
            String nameCategory = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();

            // Kiểm tra và xử lý các trường hợp không hợp lệ
            if (categoryCode <= 0) {
                System.out.println("Invalid category code. Category code must be a positive number.");
                return;
            }

            // Kiểm tra và xử lý các trường hợp không hợp lệ khác

            Category newCategory = new Category();
            newCategory.setCategoryCode(categoryCode);
            newCategory.setNameCategory(nameCategory);
            newCategory.setDescription(description);
            categoryService.addCategory(newCategory);

            System.out.println("Category added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values for category code.");
            scanner.nextLine(); // Đọc dòng new line sau khi xảy ra exception
        }
    }

    private void updateCategory(Scanner scanner) {
        System.out.print("Enter Category ID to update: ");
        try {
            int categoryId = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng new line sau khi đọc số

            Category existingCategory = categoryService.findCategoryById(categoryId);
            if (existingCategory != null) {
                System.out.println("Enter updated category details:");
                System.out.print("Category Code: ");
                int categoryCode = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng new line sau khi đọc số
                System.out.print("Name: ");
                String nameCategory = scanner.nextLine();
                System.out.print("Description: ");
                String description = scanner.nextLine();

                // Kiểm tra và xử lý các trường hợp không hợp lệ
                if (categoryCode <= 0) {
                    System.out.println("Invalid category code. Category code must be a positive number.");
                    return;
                }

                // Kiểm tra và xử lý các trường hợp không hợp lệ khác

                existingCategory.setCategoryCode(categoryCode);
                existingCategory.setNameCategory(nameCategory);
                existingCategory.setDescription(description);
                categoryService.updateCategory(existingCategory);

                System.out.println("Category updated successfully.");
            } else {
                System.out.println("Category not found with ID: " + categoryId);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values for category ID and category code.");
            scanner.nextLine(); // Đọc dòng new line sau khi xảy ra exception
        }
    }

    private void deleteCategory(Scanner scanner) {
        System.out.print("Enter Category ID to delete: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng new line sau khi đọc số

        Category existingCategory = categoryService.findCategoryById(categoryId);
        if (existingCategory != null) {
            categoryService.deleteCategory(categoryId);
            System.out.println("Category deleted successfully.");
        } else{
            System.out.println("Category not found with ID: " + categoryId);
        }
    }

    private void printAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            System.out.println("Categories:");
            for (Category category : categories) {
                System.out.println(category);
            }
        }
    }
}