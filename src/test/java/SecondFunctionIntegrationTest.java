import exceptions.UnreachableResultException;
import functions.logarithms.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import system.SecondFunction;

import java.util.stream.Stream;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecondFunctionIntegrationTest {

    private static final double accuracy = 10e-5;
    static SecondFunction secondFunction;
    static Logarithm2 log2;
    static Logarithm3 log3;
    static Logarithm5 log5;
    static Logarithm10 log10;
    static LogarithmNatural logN;

    @BeforeAll
    static void setUp() {
        log2 = mock(Logarithm2.class);
        log3 = mock(Logarithm3.class);
        log5 = mock(Logarithm5.class);
        log10 = mock(Logarithm10.class);
        logN = mock(LogarithmNatural.class);
        secondFunction = new SecondFunction(accuracy);
        secondFunction.log2 = log2;
        secondFunction.log3 = log3;
        secondFunction.log5 = log5;
        secondFunction.log10 = log10;
        secondFunction.logN = logN;
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(1e-05, -36.63898708517993),
                arguments(0.020008, -12.448435295127894),
                arguments(0.040006, -10.24334385721948),
                arguments(0.060004, -8.953247957053604),
                arguments(0.080002, -8.037854800486267),
                //first partition
                arguments(0.1, -7.327797417035985),
                arguments(0.43999999999999995, -2.6127065562956107),
                arguments(0.7799999999999999, -0.7907088916889399),
                arguments(1.1199999999999999, 0.3606596993941751),
                arguments(1.46, 1.204344432099686),
                //second partition
                arguments(1.8, 1.870585203536312),
                arguments(2.72, 3.184432892505961),
                arguments(3.6400000000000006, 4.11163726979887),
                arguments(4.5600000000000005, 4.828760871993972),
                arguments(5.48, 5.413634268218162),
                //third partition
                arguments(6.4, 5.907523531025266),
                arguments(7.5200000000000005, 6.420746829048286),
                arguments(8.64, 6.862582983155537),
                arguments(9.76, 7.250487818184711),
                arguments(10.879999999999999, 7.5962065418597104)
                //forth partition
                );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_0(double value, double expected) throws UnreachableResultException {
        when(secondFunction.logN.comp(value)).thenReturn(log(value));
        when(secondFunction.log2.comp(value)).thenReturn(log(value)/log(2));
        when(secondFunction.log3.comp(value)).thenReturn(log(value)/log(3));
        when(secondFunction.log5.comp(value)).thenReturn(log(value)/log(5));
        when(secondFunction.log10.comp(value)).thenReturn(log(value)/log(10));
        assertEquals(expected, secondFunction.comp(value), accuracy);
    }

    static Stream<Arguments> withExceptionsProvider(){
        return Stream.of(
                arguments(1, true)
        );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values with exceptions, x = {0}")
    @MethodSource("withExceptionsProvider")
    void test_1(double value, boolean sinE) throws UnreachableResultException {
        assertThrows(UnreachableResultException.class, () -> secondFunction.comp(value));
    }
}
