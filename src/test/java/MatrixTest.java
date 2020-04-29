import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.Assert.*;

public class MatrixTest {
    private static Matrix m;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before MatrixTest.class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After MatrixTest.class");
    }

    @Before
    public void init(){
        m = new Matrix();
    }

    @After
    public void after(){
        m = null;
    }

    @Test
    public void multiply() {
        double[][] temp1 = {
                {2,1,4},
                {3,0,1}
        };
        double[][] temp2 = {
                {3,1},
                {1,2},
                {1,2}
        };
        double[][] actual = {
                {11,12},
                {10,5}
        };
        assertArrayEquals(actual, m.multiply(temp1, temp2));
    }

    @Test
    public void sumMatrix() {
        double[][] temp1 = {
                {2,1},
                {3,0}
        };
        double[][] temp2 = {
                {3,1},
                {1,2}
        };
        double[][] actual = {
                {5,2},
                {4,2}
        };
        assertArrayEquals(actual, m.sumMatrix(temp1, temp2));
    }

    @Test
    public void subtractMatrix() {
        double[][] temp1 = {
                {5,1},
                {3,7}
        };
        double[][] temp2 = {
                {3,1},
                {1,2}
        };
        double[][] actual = {
                {2,0},
                {2,5}
        };
        assertArrayEquals(actual, m.subtractMatrix(temp1, temp2));
    }

    @Test
    public void addition() {
        double[][] temp = {
                {11,12},
                {10,5}
        };
        double[][] actual = {
                {16,17},
                {15,10}
        };
        double N = 5;
        double[][] result = m.addition(temp,N);
        assertArrayEquals(actual, result);
    }

    @Test
    public void subtraction() {
        double[][] temp = {
                {11,12},
                {10,5}
        };
        double[][] actual = {
                {6,7},
                {5,0}
        };
        double N = 5;
        double[][] result = m.subtraction(temp,N);
        assertArrayEquals(actual, result);
    }

    @Test
    public void multiplyOnNumber() {
        double[][] temp = {
                {11,12},
                {10,5}
        };
        double[][] actual = {
                {55,60},
                {50,25}
        };
        double N = 5;
        double[][] result = m.multiplyOnNumber(temp,N);
        assertArrayEquals(actual, result);
    }

    @ParameterizedTest
    @CsvSource({"6, 7, 4, 1, 30, 35, 20, 5",
                "3, 2, 3, 2, 15, 10, 15, 10",
                "4, 5, 6, 10, 20, 25, 30, 50"})
    public void multiplyOnNumberByParam(String num1, String num2, String num3, String num4,
                                        String num5, String num6, String num7, String num8) {
        double N = 5;
        double[][] temp = {{Double.parseDouble(num1), Double.parseDouble(num2),
                            Double.parseDouble(num3), Double.parseDouble(num4)}};
        double[][] actual = {{Double.parseDouble(num5), Double.parseDouble(num6),
                            Double.parseDouble(num7), Double.parseDouble(num8)}};
        assertArrayEquals(actual, m.multiplyOnNumber(temp, N));
    }

    @Test
    public void multiplyFile() {
        double[][] temp1 = m.getMatrixFromFile("A.txt");
        double[][] temp2 = m.getMatrixFromFile("B.txt");
        double[][] actual = m.getMatrixFromFile("C_multiply.txt");
        assertArrayEquals(actual, m.multiply(temp1, temp2));
    }

    @Test
    public void sumMatrixFile() {
        double[][] temp1 = m.getMatrixFromFile("A.txt");
        double[][] temp2 = m.getMatrixFromFile("B.txt");
        double[][] actual = m.getMatrixFromFile("C_sum.txt");
        assertArrayEquals(actual, m.sumMatrix(temp1, temp2));
    }

    @Test
    public void subtractMatrixFile() {
        double[][] temp1 = m.getMatrixFromFile("A.txt");
        double[][] temp2 = m.getMatrixFromFile("B.txt");
        double[][] actual = m.getMatrixFromFile("C_sub.txt");
        assertArrayEquals(actual, m.subtractMatrix(temp1, temp2));
    }

    @Test
    public void multiplyOnNumberFile() {
        double[][] temp1 = m.getMatrixFromFile("A.txt");
        double N = 5;
        double[][] actual = {
                {10, 5, 20},
                {15, 0, 5},
                {35, 25, 25}};
        assertArrayEquals(actual, m.multiplyOnNumber(temp1, N));
    }
}