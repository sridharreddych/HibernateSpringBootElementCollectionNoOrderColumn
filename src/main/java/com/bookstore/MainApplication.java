package com.bookstore;

import com.bookstore.service.ShoppingCartService;
import com.bookstore.entity.ShoppingCart;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final ShoppingCartService shoppingCartService;

    public MainApplication(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            System.out.println("\nAdd one book at the beginning of the current cart ...");
            shoppingCartService.addToTheBeginning();
            
            System.out.println("\nAdd one book at the end of the current cart ...");
            shoppingCartService.addToTheEnd();
            
            System.out.println("\nAdd one book in the middle of the current cart ...");
            shoppingCartService.addInTheMiddle();
            
            System.out.println("\nRemove first book from the cart ...");
            shoppingCartService.removeFirst();
            
            System.out.println("\nRemove last book from the cart ...");
            shoppingCartService.removeLast();
            
            System.out.println("\nRemove middle book from the cart ...");
            shoppingCartService.removeMiddle();
            
        };
    }
}

/*
*How Regular @ElementCollection (Without @OrderColumn) Works

Description: This application reveals the possible performance penalties of using @ElementCollection. In this case, without @OrderColumn. As you can see in the next item (34) adding @OrderColumn can mitigate some performance penalties.

Key points:

an @ElementCollection doesn't have a primary key
an @ElementCollection is mapped in a separate table
avoid @ElementCollection when you have a lot of inserts/deletes on this collection; inserts/deletes will cause Hibernate to delete all the existing table rows, process the collection in-memory, and re-insert the remaining table rows to mirror the collection from memory
the more entries we have in this collection the greater the performance penalty will be
*/