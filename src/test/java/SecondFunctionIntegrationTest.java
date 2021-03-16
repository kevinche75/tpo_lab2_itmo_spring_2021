import exceptions.UnreachableResultException;
import functions.logarithms.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import system.FirstFunction;
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
                arguments(0.000102311231000, -29.23847366209),
                arguments(0.246322311231000, -4.45893724258089),
                arguments(0.492542311231000, -2.25371140416083),
                arguments(0.500000000000000, -2.20588682467688),
                arguments(0.811231100000000, -0.66577002577549),
                arguments(1.122462200000000, 0.367648234188425),
                arguments(1.433693300000000, 1.146479746256129),
                arguments(1.744924400000000, 1.771690059352390),
                arguments(2.0, 2.20589),
                arguments(2.311231100000000, 2.666170527086873),
                arguments(2.933693300000000, 3.425120297315866)
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
