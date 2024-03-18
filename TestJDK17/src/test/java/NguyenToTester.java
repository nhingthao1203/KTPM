
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author thao4
 */
public class NguyenToTester {

    @Test
    public void TestOddNumber() {
        boolean actual = NguyenTo.isNguyenTo(5);
        boolean excepted = true;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void testNumber1() {
        boolean actual = NguyenTo.isNguyenTo(3);
        boolean excepted = true;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void testException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            NguyenTo.isNguyenTo(-1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 3, 5, 7, 11, 23})
    public void testOddNum(int n) {
        boolean actual = NguyenTo.isNguyenTo(n);
        Assertions.assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({"9,false", "13,true", "4,false", "7,true"})
    public void testCSV(int n, boolean expected) {
        boolean actual = NguyenTo.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv",
            numLinesToSkip = 1)
    public void testCSVFile(int n,
            boolean expected) {
        boolean actual = NguyenTo.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "primeData")
    public void testMethod(int n,
            boolean expected) {
        boolean actual = NguyenTo.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> primeData() {
        return Stream.of(
                arguments(4, false),
                arguments(6, false)
        );
    }
}
