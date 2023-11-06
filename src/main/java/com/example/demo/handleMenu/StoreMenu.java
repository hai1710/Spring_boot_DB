package com.example.demo.handleMenu;


import com.example.demo.data.store.IStoreService;
import com.example.demo.model.Store;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StoreMenu {

    private final IStoreService IStoreService;

    public StoreMenu(IStoreService IStoreService) {
        this.IStoreService = IStoreService;
    }

    public void handleMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            try {
                System.out.println("1. Add");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. View All Stores");
                System.out.println("0. Back");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStore(scanner);
                        break;
                    case 2:
                        updateStore(scanner);
                        break;
                    case 3:
                        deleteStore(scanner);
                        break;
                    case 4:
                        printAllStores();
                        break;
                    case 5:
                        searchStoreById(scanner);
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

    private void addStore(Scanner scanner) {
        System.out.println("Enter store details:");
        try {
            System.out.print("Store Code: ");
            int storeCode = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng new line sau khi đọc số
            System.out.print("Name: ");
            String nameStore = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();

            // Kiểm tra và xử lý các trường hợp không hợp lệ
            if (storeCode <= 0) {
                System.out.println("Invalid store code. Store code must be a positive number.");
                return;
            }

            // Kiểm tra và xử lý các trường hợp không hợp lệ khác

            Store newStore = new Store();
            newStore.setStoreCode(storeCode);
            newStore.setNameStore(nameStore);
            newStore.setAddress(address);
            IStoreService.addStore(newStore);

            System.out.println("Store added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values for store code.");
            scanner.nextLine(); // Đọc dòng new line sau khi xảy ra exception
        }
    }

    private void updateStore(Scanner scanner) {
        System.out.print("Enter Store ID to update: ");
        try {
            int storeId = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng new line sau khi đọc số

            Store existingStore = IStoreService.findStoreById(storeId);
            if (existingStore != null) {
                System.out.println("Enter updated store details:");
                System.out.print("Store Code: ");
                int storeCode = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng new line sau khi đọc số
                System.out.print("Name: ");
                String nameStore = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();

                // Kiểm tra và xử lý các trường hợp không hợp lệ
                if (storeCode <= 0) {
                    System.out.println("Invalid store code. Store code must be a positive number.");
                    return;
                }

                // Kiểm tra và xử lý các trường hợp không hợp lệ khác

                existingStore.setStoreCode(storeCode);
                existingStore.setNameStore(nameStore);
                existingStore.setAddress(address);
                IStoreService.updateStore(existingStore);

                System.out.println("Store updated successfully.");
            } else {
                System.out.println("Store not found with ID: " + storeId);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values for store ID and store code.");
            scanner.nextLine(); // Đọc dòng new line sau khi xảy ra exception
        }
    }

    private void deleteStore(Scanner scanner) {
        System.out.print("Enter Store ID to delete: ");
        int storeId = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng new line sau khi đọc số

        Store existingStore = IStoreService.findStoreById(storeId);
        if (existingStore != null) {
            IStoreService.deleteStore(storeId);
            System.out.println("Store deleted successfully.");
        } else {
            System.out.println("Store not found with ID: " + storeId);
        }
    }

    private void printAllStores() {
        List<Store> stores = IStoreService.getAllStores();
        if (stores.isEmpty()) {
            System.out.println("No stores found.");
        } else {
            System.out.println("All Stores:");
            for (Store store : stores) {
                System.out.println(store);
            }
        }
    }

    private void searchStoreById(Scanner scanner) {
        System.out.print("Enter Store ID: ");
        int storeId = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng new line sau khi đọc số

        Store store = IStoreService.findStoreById(storeId);
        if (store != null) {
            System.out.println("Store found:");
            System.out.println(store);
        } else {
            System.out.println("Store not found with ID: " + storeId);
        }
    }
}