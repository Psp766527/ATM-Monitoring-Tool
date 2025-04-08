package com.kinective.atm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    private Calculator calculator = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    void testSum() {
        int expectedResult = 17;
        int actualResult = calculator.doSum(12, 3, 2);
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    void testMult(){
        int expectedResult = 6;
        int actualResult = calculator.doMult(1,1,1);
        assertThat(actualResult).isBetween(0,10);
    }

    @Test
    void testCompare(){
        boolean actualResult = calculator.compare(1,1);
        assertThat(actualResult).isTrue();
    }
}
