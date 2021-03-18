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
import system.SystemFunctions;

import static org.mockito.Mockito.mockStatic;
public class LogarithmsIntegrationTest {

    private static final double accuracy = 10e-5;
    static SystemFunctions sys;

    @BeforeAll
    static void SetUp(){
        sys = new SystemFunctions(accuracy);
    }

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

    @DisplayName("System Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_4(double value, double expected) throws UnreachableResultException {
        try (MockedStatic<LogarithmNatural> logN = mockStatic(LogarithmNatural.class)){
            logN.when(() -> LogarithmNatural.compLogN(value, accuracy)).thenReturn(log(value));
            logN.when(() -> LogarithmNatural.compLogN(10, accuracy)).thenReturn(log(10));
            logN.when(() -> LogarithmNatural.compLogN(2, accuracy)).thenReturn(log(2));
            logN.when(() -> LogarithmNatural.compLogN(3, accuracy)).thenReturn(log(3));
            logN.when(() -> LogarithmNatural.compLogN(5, accuracy)).thenReturn(log(5));
            System.out.println(LogarithmNatural.compLogN(value, accuracy));
            assertEquals(expected, sys.comp(value));
        }
    }
}
