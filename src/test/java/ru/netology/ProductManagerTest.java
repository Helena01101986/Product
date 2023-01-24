package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import static org.mockito.Mockito.*;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Незнайка на Луне", 300, "Носов");
    Product product2 = new Book(2, "Чебурашка и Гена", 500, "Успенский");
    Product product3 = new Book(3, "Приключения Незнайки", 200, "Носов");
    Product product4 = new Smartphone(4, "Смартфон", 1_00, "Nokia");

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
    }

    @Test
    public void shouldAddProducts() {

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBook() {

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("Незнай");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Смартфон");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameCategory() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Книги");
        Assertions.assertArrayEquals(expected, actual);
    }


}



