package ru.netology;
import ru.netology.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        try {
            repo.removeById(7);


        }catch (NegativeArraySizeException e) {
            System.out.println("ERROR");

        }
    }
}

