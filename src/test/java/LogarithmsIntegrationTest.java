import exceptions.UnreachableResultException;
import functions.logarithms.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;
public class LogarithmsIntegrationTest {

    private static final double accuracy = 10e-5;

    static Stream<Arguments> valuesRangeProvider() {
        return Stream.of(
                arguments(0.000102311231000),
                arguments(0.246322311231000),
                arguments(0.492542311231000),
                arguments(0.500000000000000),
                arguments(0.811231100000000),
                arguments(1.122462200000000),
                arguments(1.433693300000000),
                arguments(1.744924400000000),
                arguments(2.0),
                arguments(2.311231100000000),
                arguments(2.933693300000000)
        );
    }

    @DisplayName("Log2: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_0(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(2, accuracy)).thenReturn(log(2));
            assertEquals(log(value)/log(2), Logarithm2.compLog2(value, accuracy));
        }
    }

    @DisplayName("Log3: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_1(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(3, accuracy)).thenReturn(log(3));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(log(value)/log(3), Logarithm3.compLog3(value, accuracy));
        }
    }

    @DisplayName("Log5: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_2(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(5, accuracy)).thenReturn(log(5));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(log(value)/log(5), Logarithm5.compLog5(value, accuracy));
        }
    }

    @DisplayName("Log310 Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_3(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(10, accuracy)).thenReturn(log(10));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(log(value)/log(10), Logarithm10.compLog10(value, accuracy));
        }
    }
}
