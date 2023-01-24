package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product[] products = new Product[0];
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "Незнайка на Луне", 300, "Носов");
    Product product2 = new Book(2, "Чебурашка и Гена", 500, "Успенский");
    Product product3 = new Book(3, "Приключения Незнайки", 200, "Носов");
    Product product4 = new Smartphone(4, "Смартфон", 1_00, "Nokia");

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

    }

    @Test
    public void shouldAddAllProducts() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProduct() {
        repo.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
