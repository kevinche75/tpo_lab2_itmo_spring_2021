import exceptions.UnreachableResultException;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import system.FirstFunction;

import java.util.stream.Stream;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FirstFunctionIntegrationTest {

    private static final double accuracy = 10e-5;
    static FirstFunction firstFunction;
    static Cosine cos;
    static Sinus sin;
    static Cosecant csc;
    static Secant sec;

    @BeforeAll
    static void setUp() {
        cos = mock(Cosine.class);
        sin = mock(Sinus.class);
        csc = mock(Cosecant.class);
        sec = mock(Secant.class);
        firstFunction = new FirstFunction(accuracy);
        firstFunction.cos = cos;
        firstFunction.sin = sin;
        firstFunction.sec = sec;
        firstFunction.csc = csc;
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(-6.160185307179586, 75.52160620692274),
                arguments(-5.485185307179586, 3.9259456338239573),
                arguments(-4.810185307179586, 2.107734738140778),
                arguments(-4.135185307179587, 1.772855123015100),
                arguments(-3.460185307179587, 8.160422140205835),
                arguments(-2.785185307179587, 11.900324932977870),
                arguments(-2.110185307179587, 2.956920550480631),
                arguments(-1.435185307179587, 1.882169698947829),
                arguments(-0.760185307179587, 2.054418374526884),
                arguments(-0.085185307179587, 127.429901541783270)
        );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_0(double value, double expected) throws UnreachableResultException {
        when(firstFunction.sin.comp(value)).thenReturn(sin(value));
        when(firstFunction.cos.comp(value)).thenReturn(cos(value));
        when(firstFunction.csc.comp(value)).thenReturn(1/sin(value));
        when(firstFunction.sec.comp(value)).thenReturn(1/cos(value));
        assertEquals(expected, firstFunction.comp(value), accuracy);
    }

    static Stream<Arguments> withExceptionsProvider(){
        return Stream.of(
                arguments(-6.283185307179586, true),
                arguments(-4.71238898038469, false),
                arguments(-3.141592653589793, true),
                arguments(-1.5707963267948966, false),
                arguments(0.0, true)
        );
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values with exceptions, x = {0}")
    @MethodSource("withExceptionsProvider")
    void test_1(double value, boolean sinE) throws UnreachableResultException {
        if (sinE){
            when(firstFunction.csc.comp(value)).thenThrow(new UnreachableResultException(""));
        } else {
            when(firstFunction.sec.comp(value)).thenThrow(new UnreachableResultException(""));
        }
        assertThrows(UnreachableResultException.class, () -> firstFunction.comp(value));
    }
}
