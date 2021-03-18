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
                arguments(-6.282185307179586, 1001001.3330000667),
                arguments(-6.082385307179586, 31.05019804380372),
                arguments(-5.882585307179586, 9.93687436922086),
                //first partition
                arguments(-5.682785307179586, 5.593333063231319),
                arguments(-5.482985307179586, 3.913329194532811),
                arguments(-5.283185307179586, 3.0543755433717226),
                arguments(-5.083185307179586, 2.5399291229263317),
                arguments(-4.883185307179586, 2.202224946785458),
                arguments(-4.683185307179587, 1.9716413614704094),
                arguments(-4.483185307179586, 1.8211270045213657),
                arguments(-4.283185307179586, 1.751792882702752),
                //second partition
                arguments(-4.183185307179587, 1.7571991502609825),
                arguments(-4.083185307179586, 1.801936484720827),
                arguments(-3.983185307179586, 1.9048300228564787),
                arguments(-3.883185307179586, 2.1000923538122396),
                //third partition
                arguments(-3.7831853071795862, 2.4533306831080557),
                arguments(-3.663185307179586, 3.28785616092963),
                arguments(-3.543185307179586, 5.190132528306663),
                arguments(-3.423185307179586, 10.49304956103955),
                arguments(-3.303185307179586, 33.49693575249216),
                //forth partition
                arguments(-3.140592653589793, 1001001.333000066700000),
                arguments(-2.940792653589793, 31.050198043803720),
                arguments(-2.740992653589793, 9.936874369220860),
                arguments(-2.541192653589793, 5.593333063231319),
                arguments(-2.341392653589793, 3.913329194532811),
                arguments(-2.141592653589793, 3.054375543371723),
                arguments(-1.941592653589793, 2.539929122926332),
                arguments(-1.741592653589793, 2.202224946785458),
                arguments(-1.541592653589794, 1.971641361470409),
                arguments(-1.341592653589793, 1.821127004521366),
                arguments(-1.141592653589793, 1.751792882702752),
                arguments(-1.041592653589794, 1.757199150260983),
                arguments(-0.941592653589793, 1.801936484720827),
                arguments(-0.841592653589793, 1.904830022856479),
                arguments(-0.741592653589793, 2.100092353812240),
                arguments(-0.641592653589793, 2.453330683108056),
                arguments(-0.521592653589793, 3.287856160929630),
                arguments(-0.401592653589793, 5.190132528306663),
                arguments(-0.281592653589793, 10.493049561039550),
                arguments(-0.161592653589793, 33.496935752492160)
                //fifth partition
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
        when(firstFunction.sin.comp(value)).thenReturn(sin(value));
        when(firstFunction.cos.comp(value)).thenReturn(cos(value));
        when(firstFunction.csc.comp(value)).thenReturn(1/sin(value));
        when(firstFunction.sec.comp(value)).thenReturn(1/cos(value));
        assertEquals(expected, sys.comp(value), accuracy);
    }
}
