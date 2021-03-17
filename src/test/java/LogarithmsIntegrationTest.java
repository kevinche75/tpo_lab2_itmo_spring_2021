import exceptions.UnreachableResultException;
import functions.logarithms.*;
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

    static Stream<Arguments> valuesRangeProviderLog2() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0200818489848),
                arguments(0.040061386738600005),
                arguments(0.060040924492400005),
                arguments(0.0800204622462),
                arguments(0.1),
                //first partition
                arguments(0.1199795377538),
                arguments(0.19598363020304),
                arguments(0.27198772265228),
                arguments(0.34799181510152),
                arguments(0.42399590755076),
                //second partition
                arguments(0.5),
                arguments(1.2),
                arguments(1.9),
                arguments(2.5999999999999996),
                arguments(3.3),
                //third partition
                arguments(4.0),
                arguments(6.4),
                arguments(8.8),
                arguments(11.200000000000001),
                arguments(13.600000000000001)
                //forth partition
                );
    }

    @DisplayName("Log2: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog2")
    void test_0(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(2, accuracy)).thenReturn(log(2));
            assertEquals(log(value)/log(2), Logarithm2.compLog2(value, accuracy));
        }
    }

    static Stream<Arguments> valuesRangeProviderLog3() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0200818489848),
                arguments(0.040061386738600005),
                arguments(0.060040924492400005),
                arguments(0.0800204622462),
                arguments(0.1),
                //first partition
                arguments(0.1),
                arguments(0.28),
                arguments(0.46),
                arguments(0.64),
                arguments(0.8200000000000001),
                //second partition
                arguments(1.1),
                arguments(1.6800000000000002),
                arguments(2.2600000000000002),
                arguments(2.8400000000000003),
                arguments(3.4200000000000004),
                //third partition
                arguments(4.0),
                arguments(6.4),
                arguments(8.8),
                arguments(11.200000000000001),
                arguments(13.600000000000001)
                //forth partition
        );
    }

    @DisplayName("Log3: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog3")
    void test_1(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(3, accuracy)).thenReturn(log(3));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(log(value)/log(3), Logarithm3.compLog3(value, accuracy));
        }
    }

    static Stream<Arguments> valuesRangeProviderLog5() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0400818489848),
                arguments(0.0800613867386),
                arguments(0.1200409244924),
                arguments(0.1600204622462),
                //first partition
                arguments(0.2),
                arguments(0.36),
                arguments(0.52),
                arguments(0.68),
                arguments(0.8400000000000001),
                //second partition
                arguments(1.1),
                arguments(3.08),
                arguments(5.0600000000000005),
                arguments(7.040000000000001),
                arguments(9.020000000000001)
                //third partition
        );
    }

    @DisplayName("Log5: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog5")
    void test_2(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(5, accuracy)).thenReturn(log(5));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(log(value)/log(5), Logarithm5.compLog5(value, accuracy));
        }
    }

    static Stream<Arguments> valuesRangeProviderLog10() {
        return Stream.of(
                arguments(0.000102311231),
                arguments(0.0400818489848),
                arguments(0.0800613867386),
                arguments(0.1200409244924),
                arguments(0.1600204622462),
                //first partition
                arguments(0.2),
                arguments(0.36),
                arguments(0.52),
                arguments(0.68),
                arguments(0.8400000000000001),
                //second partition
                arguments(1.1),
                arguments(3.08),
                arguments(5.0600000000000005),
                arguments(7.040000000000001),
                arguments(9.020000000000001)
                //third partition
        );
    }

    @DisplayName("Log310 Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProviderLog10")
    void test_3(Double value) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(10, accuracy)).thenReturn(log(10));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(log(value)/log(10), Logarithm10.compLog10(value, accuracy));
        }
    }
}
