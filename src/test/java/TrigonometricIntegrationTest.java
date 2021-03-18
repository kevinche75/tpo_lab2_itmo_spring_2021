import exceptions.UnreachableResultException;
import functions.logarithms.Logarithm2;
import functions.logarithms.LogarithmNatural;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import system.SystemFunctions;

import java.util.stream.Stream;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;

public class TrigonometricIntegrationTest {

    private static final double accuracy = 10e-5;
    static SystemFunctions sys;

    @BeforeAll
    static void SetUp(){
        sys = new SystemFunctions(accuracy);
    }

    static Stream<Arguments> valuesRangeProviderCsc() {
        return Stream.of(
                arguments(-3.0732733228718345),
                arguments(-3.004954992153876),
                arguments(-2.9366366614),
                arguments(-2.868318330717959),
                //first partition
                arguments(-2.8),
                arguments(-2.6399999999999997),
                arguments(-2.4799999999999995),
                arguments(-2.3199999999999994),
                arguments(-2.1599999999999993),
                //second partition
                arguments(-1.82),
                arguments(-1.6400000000000001),
                arguments(-1.4600000000000002),
                arguments(-1.2800000000000002),
                //third partition
                arguments(-1.1),
                arguments(-0.9600000000000001),
                arguments(-0.8200000000000001),
                arguments(-0.68),
                arguments(-0.54),
                //forth partition
                arguments(-0.4),
                arguments(-0.32),
                arguments(-0.24),
                arguments(-0.15999999999999998),
                arguments(-0.07999999999999997),
                //fifth partition
                arguments(0.06831853671795865),
                arguments(0.1366370634359173),
                arguments(0.20495559015387596),
                arguments(0.2732741168718346),
                //sixth partition
                arguments(0.3415926435897933),
                arguments(0.43327411487183465),
                arguments(0.5249555861538759),
                arguments(0.6166370574359172),
                arguments(0.7083185287179585),
                //seventh partition
                arguments(0.8),
                arguments(1.12),
                arguments(1.44),
                arguments(1.7599999999999998),
                arguments(2.0799999999999996),
                //ninth partition
                arguments(2.5),
                arguments(2.6283185107179587),
                arguments(2.7566370214359175),
                arguments(2.8849555321538762),
                arguments(3.013274042871835)
                //tenth partition
                );
    }

    @DisplayName("Cosecant: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderCsc")
    void test_0(Double value) throws UnreachableResultException {
        try (MockedStatic<Sinus> sin = mockStatic(Sinus.class)){
            sin.when(() -> Sinus.compSin(value, accuracy)).thenReturn(sin(value));
            assertEquals(1/sin(value), Cosecant.compCsc(value, accuracy), accuracy);
        }
    }

    static Stream<Arguments> valuesRangeProviderSin(){
        return Stream.of(
                arguments(-6.283185307179586),
                arguments(-5.654866776461628),
                arguments(-5.026548245743669),
                arguments(-4.39822971502571),
                arguments(-3.7699111843077517),
                arguments(-3.141592653589793),
                arguments(-2.5132741228718345),
                arguments(-1.8849555921538759),
                arguments(-1.2566370614359172),
                arguments(-0.6283185307179586),
                arguments(0.0),
                arguments(0.6283185307179586),
                arguments(1.2566370614359172),
                arguments(1.8849555921538759),
                arguments(2.5132741228718345),
                arguments(3.141592653589793),
                arguments(3.7699111843077517),
                arguments(4.39822971502571),
                arguments(5.026548245743669),
                arguments(5.654866776461628)
                );
    }

    @DisplayName("Sinus: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderSin")
    void test_1(Double value) throws UnreachableResultException {
        try (MockedStatic<Cosine> cos = mockStatic(Cosine.class)){
            cos.when(() -> Cosine.compCos(PI/2 - value, accuracy)).thenReturn(Math.cos(Math.PI/2 - value));
            assertEquals(sin(value), Sinus.compSin(value, accuracy), accuracy);
        }
    }

    static Stream<Arguments> valuesRangeProviderSec() {
        return Stream.of(
                arguments(-1.502476996076938),
                arguments(-1.4341586653589795),
                arguments(-1.3658403346051036),
                arguments(-1.2975220039230626),
                //first partition
                arguments(-1.2292036732051033),
                arguments(-1.0692036732051031),
                arguments(-0.909203673205103),
                arguments(-0.7492036732051028),
                arguments(-0.5892036732051027),
                //second partition
                arguments(-0.2492036732051035),
                arguments(-0.06920367320510357),
                arguments(0.11079632679489637),
                arguments(0.2907963267948963),
                //third partition
                arguments(0.47079632679489647),
                arguments(0.6107963267948965),
                arguments(0.7507963267948965),
                arguments(0.8907963267948965),
                arguments(1.0307963267948965),
                //forth partition
                arguments(1.1707963267948966),
                arguments(1.2507963267948965),
                arguments(1.3307963267948966),
                arguments(1.4107963267948966),
                arguments(1.4907963267948965),
                //fifth partition
                arguments(1.6391148635128552),
                arguments(1.7074333902308139),
                arguments(1.7757519169487725),
                arguments(1.8440704436667312),
                arguments(1.91238897038469),
                //sixth partition
                arguments(2.004070441666731),
                arguments(2.0957519129487725),
                arguments(2.187433384230814),
                arguments(2.279114855512855),
                arguments(2.3707963267948964),
                //seventh partition
                arguments(2.6907963267948967),
                arguments(3.0107963267948965),
                arguments(3.3307963267948963),
                arguments(3.650796326794896),
                arguments(4.070796326794897),
                //ninth partition
                arguments(4.199114837512855),
                arguments(4.327433348230814),
                arguments(4.455751858948773),
                arguments(4.5840703696667315)
                //tenth partition
        );
    }

    @DisplayName("Secant: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderSec")
    void test_2(Double value) throws UnreachableResultException {
        try (MockedStatic<Cosine> cos = mockStatic(Cosine.class)){
            cos.when(() -> Cosine.compCos(value, accuracy)).thenReturn(cos(value));
            assertEquals(1/cos(value), Secant.compSec(value, accuracy), accuracy);
        }
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(-6.282185307179586, 1001001.3330000667),
                arguments(-6.082385307179586, 31.05019804380372),
                arguments(-5.882585307179586, 9.93687436922086),
                arguments(-5.682785307179586, 5.593333063231319),
                arguments(-5.482985307179586, 3.913329194532811),
                //first partition
                arguments(-5.283185307179586, 3.0543755433717226),
                arguments(-5.083185307179586, 2.5399291229263317),
                arguments(-4.883185307179586, 2.202224946785458),
                arguments(-4.683185307179587, 1.9716413614704094),
                arguments(-4.483185307179586, 1.8211270045213657),
                //second partition
                arguments(-4.283185307179586, 1.751792882702752),
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

    @DisplayName("System: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_3(double value, double expected) throws UnreachableResultException {
//        System.out.printf("arguments(%.15f, %.15f),\n", value+Math.PI, expected);
        try (MockedStatic<Cosine> cos = mockStatic(Cosine.class)){
            cos.when(() -> Cosine.compCos(value, accuracy/100)).thenReturn(cos(value));
            cos.when(() -> Cosine.compCos(PI/2 - value, accuracy/100)).thenReturn(Math.cos(Math.PI/2 - value));
            assertEquals(expected, sys.comp(value), accuracy);
        }
    }
}
