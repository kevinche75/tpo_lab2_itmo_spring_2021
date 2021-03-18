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
import system.SystemFunctions;

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
    static SystemFunctions sys;

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
        sys = new SystemFunctions(accuracy);
        sys.firstFunction = firstFunction;
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(0.001, 1001001.3330000667),
                arguments(0.2008, 31.05019804380372),
                arguments(0.4006, 9.93687436922086),
                arguments(0.6004, 5.593333063231319),
                arguments(0.8002, 3.913329194532811),
                //first partition
                arguments(1, 3.0543755433717226),
                arguments(1.2, 2.5399291229263317),
                arguments(1.4, 2.202224946785458),
                arguments(1.5999999999999999, 1.9716413614704094),
                arguments(1.7999999999999998, 1.8211270045213657),
                //second partition
                arguments(2, 1.751792882702752),
                arguments(2.1, 1.7571991502609825),
                arguments(2.2, 1.801936484720827),
                arguments(2.3000000000000003, 1.9048300228564787),
                arguments(2.4000000000000004, 2.1000923538122396),
                //third partition
                arguments(2.5, 2.4533306831080557),
                arguments(2.62, 3.28785616092963),
                arguments(2.74, 5.190132528306663),
                arguments(2.8600000000000003, 10.49304956103955),
                arguments(2.9800000000000004, 33.49693575249216)
                //forth partition
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

    @DisplayName("Integration Test with Mocks: System")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_2(double value, double expected) throws UnreachableResultException {
        value-=2*Math.PI;
        when(firstFunction.sin.comp(value)).thenReturn(sin(value));
        when(firstFunction.cos.comp(value)).thenReturn(cos(value));
        when(firstFunction.csc.comp(value)).thenReturn(1/sin(value));
        when(firstFunction.sec.comp(value)).thenReturn(1/cos(value));
        assertEquals(expected, sys.comp(value), accuracy);
    }
}
