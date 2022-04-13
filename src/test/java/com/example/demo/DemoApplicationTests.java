package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests {
    @Test
        void probando() {
    }
    public static int NumRandom() {
        int min = 1;
        int max = 10;

        Random random = new Random();

        int valor=random.nextInt(max + min) + min;
        return valor;
    }
/*mensaje de prueba Daniel Arteaga*/
}
